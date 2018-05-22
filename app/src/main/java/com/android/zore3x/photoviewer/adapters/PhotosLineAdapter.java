package com.android.zore3x.photoviewer.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.zore3x.photoviewer.R;
import com.android.zore3x.photoviewer.activities.UserInformationActivity;
import com.android.zore3x.photoviewer.api.model.Photo;
import com.android.zore3x.photoviewer.dialogs.FullPhotoPreviewDialog;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PhotosLineAdapter extends RecyclerView.Adapter<PhotosLineAdapter.PhotoLineViewHolder> {

    private List<Photo> mPhotoList;
    private Context mContext;

    public PhotosLineAdapter(Context context, List<Photo> photoList) {
        mContext = context;
        mPhotoList = photoList;
    }

    @Override
    public PhotoLineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_photo_item, parent, false);

        return new PhotoLineViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PhotoLineViewHolder holder, int position) {

        holder.bind(mPhotoList.get(position));

    }

    public void setPhotoList(List<Photo> photoList) {
        mPhotoList = photoList;
    }

    @Override
    public int getItemCount() {
        return mPhotoList.size();
    }

    class PhotoLineViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private Photo mCurrentPhoto;

        private ImageView mUserPhotoSmallImageView;
        private ImageView mPhotoImageView;

        private TextView mUsernameTexView;
        private TextView mDescriptionTexView;

        private ImageButton mShowMoreImageButton;

        private ConstraintLayout mUserBlockConstraintLayout;
        private ConstraintLayout mExifBlockConstraintLayout;

        public PhotoLineViewHolder(View itemView) {
            super(itemView);

            mUserPhotoSmallImageView = itemView.findViewById(R.id.card_userPhotoSmall_imageView);
            mPhotoImageView = itemView.findViewById(R.id.card_photo_imageView);
            mUsernameTexView = itemView.findViewById(R.id.card_username_textView);
            mDescriptionTexView = itemView.findViewById(R.id.card_description_textView);
            mUserBlockConstraintLayout = itemView.findViewById(R.id.userBlock_constraintLayout);
            mExifBlockConstraintLayout = itemView.findViewById(R.id.exifBlock_constraintLayout);
            mShowMoreImageButton = itemView.findViewById(R.id.showMore_imageButton);

            mPhotoImageView.setOnClickListener(this);
            mUserBlockConstraintLayout.setOnClickListener(this);
            mShowMoreImageButton.setOnClickListener(this);
        }

        public void bind(Photo photo) {

            mCurrentPhoto = photo;

            // загрузка изображния
            Picasso.get()
                    .load(mCurrentPhoto.getUrls().getRegular())
                    .placeholder(R.drawable.placeholder_photo)
                    .into(mPhotoImageView);

            // загрузка аватара автора
            Picasso.get()
                    .load(mCurrentPhoto.getUser().getProfileImage().getSmall())
                    .placeholder(R.drawable.user_placeholder)
                    .into(mUserPhotoSmallImageView);
            // описание
            mDescriptionTexView.setText(mCurrentPhoto.getDescription());

            // имя пользователя
            mUsernameTexView.setText(mCurrentPhoto.getUser().getUsername());
        }

        @Override
        public void onClick(View view) {

            switch (view.getId()) {
                case R.id.card_photo_imageView:
                    FullPhotoPreviewDialog.newInstance(mCurrentPhoto.getId())
                            .show(((AppCompatActivity)mContext).getSupportFragmentManager(), "fullPhotoDialog");

                    break;
                case R.id.userBlock_constraintLayout:
                    Intent intent = UserInformationActivity.newIntent(mContext, mCurrentPhoto.getUser().getUsername());
                    mContext.startActivity(intent);
                    break;
                case R.id.showMore_imageButton:

                    if(mPhotoImageView.getVisibility() == View.VISIBLE) {
                        mPhotoImageView.setVisibility(View.GONE);
                        mExifBlockConstraintLayout.setVisibility(View.VISIBLE);
                    } else {
                        mPhotoImageView.setVisibility(View.VISIBLE);
                        mExifBlockConstraintLayout.setVisibility(View.GONE);
                    }


                    break;
            }
        }
    }
}
