package com.android.zore3x.photoviewer.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.zore3x.photoviewer.R;
import com.android.zore3x.photoviewer.api.model.Photo;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PhotosLineAdapter extends RecyclerView.Adapter<PhotosLineAdapter.PhotoLineViewHolder> {

    private List<Photo> mPhotoList;

    public PhotosLineAdapter(List<Photo> photoList) {
        mPhotoList = photoList;
    }

    @Override
    public PhotoLineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_photo, parent, false);

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

    class PhotoLineViewHolder extends RecyclerView.ViewHolder {

        private ImageView mUserPhotoSmallImageView;
        private ImageView mPhotoImageView;

        private TextView mUsernameTexView;
        private TextView mDescriptionTexView;

        public PhotoLineViewHolder(View itemView) {
            super(itemView);

            mUserPhotoSmallImageView = itemView.findViewById(R.id.card_userPhotoSmall_imageView);
            mPhotoImageView = itemView.findViewById(R.id.card_photo_imageView);
            mUsernameTexView = itemView.findViewById(R.id.card_username_textView);
            mDescriptionTexView = itemView.findViewById(R.id.card_description_textView);
        }

        public void bind(Photo photo) {

            // загрузка изображния
            Picasso.get()
                    .load(photo.getUrls().getRegular())
                    .placeholder(R.drawable.placeholder_photo)
                    .into(mPhotoImageView);

            // загрузка аватара автора
            Picasso.get()
                    .load(photo.getUser().getProfileImage().getSmall())
                    .placeholder(R.drawable.user_placeholder)
                    .into(mUserPhotoSmallImageView);
            // описание
            mDescriptionTexView.setText(photo.getDescription());

            // имя пользователя
            mUsernameTexView.setText(photo.getUser().getUsername());
        }
    }
}
