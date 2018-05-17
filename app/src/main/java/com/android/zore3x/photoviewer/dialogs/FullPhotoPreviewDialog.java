package com.android.zore3x.photoviewer.dialogs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.android.zore3x.photoviewer.App;
import com.android.zore3x.photoviewer.R;
import com.android.zore3x.photoviewer.api.Unsplash;
import com.android.zore3x.photoviewer.api.model.Photo;
import com.squareup.picasso.Picasso;

public class FullPhotoPreviewDialog extends DialogFragment {

    public static final String ARG_PHOTO_ID = "photoId";
    private String mPhotoId;

    private Photo mPhoto;

    private ImageView mFullPhotoImageView;
    private ImageButton mDownloadButton;

    public static FullPhotoPreviewDialog newInstance(String photoId) {

        Bundle args = new Bundle();

        args.putString(ARG_PHOTO_ID, photoId);

        FullPhotoPreviewDialog fragment = new FullPhotoPreviewDialog();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_full_photo, container, false);

        mPhotoId = getArguments().getString(ARG_PHOTO_ID);

        mFullPhotoImageView = view.findViewById(R.id.fullPhotoPreview_imageView);
        mDownloadButton = view.findViewById(R.id.downloadPhoto_button);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        App.getUnsplash().getPhoto(mPhotoId, new Unsplash.OnPhotoLoadedListener() {
            @Override
            public void onComplete(Photo photo) {
                mPhoto = photo;
                // загрузка картинки
                Picasso.get().load(mPhoto.getUrls().getRegular()).into(mFullPhotoImageView);
            }

            @Override
            public void onError(String error) {
                int d ;
            }
        });

        mFullPhotoImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mDownloadButton.getVisibility() == View.GONE) {
                    mDownloadButton.setVisibility(View.VISIBLE);
                } else {
                    mDownloadButton.setVisibility(View.GONE);
                }
            }
        });
    }
}
