package com.android.zore3x.photoviewer.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.zore3x.photoviewer.R;
import com.android.zore3x.photoviewer.api.model.Photo;
import com.squareup.picasso.Picasso;

import java.util.List;

public class UsersPhotoAdapter extends RecyclerView.Adapter<UsersPhotoAdapter.ImageViewHolder> {

    private List<Photo> mUserPhotoList;

    public UsersPhotoAdapter(List<Photo> userPhotoList) {
        mUserPhotoList = userPhotoList;
    }

    public void setUserPhotoList(List<Photo> userPhotoList) {
        mUserPhotoList = userPhotoList;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.photo_item, parent, false);

        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        holder.bind(mUserPhotoList.get(position));
    }

    @Override
    public int getItemCount() {
        return mUserPhotoList.size();
    }

    class ImageViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImageView;

        public ImageViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.simple_user_photo_imageView);
        }

        public void bind(Photo photo) {
            Picasso.get()
                    .load(photo.getUrls().getSmall())
                    .into(mImageView);
        }
    }

}
