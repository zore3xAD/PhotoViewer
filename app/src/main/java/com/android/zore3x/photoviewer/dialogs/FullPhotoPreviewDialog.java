package com.android.zore3x.photoviewer.dialogs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.zore3x.photoviewer.R;
import com.squareup.picasso.Picasso;

public class FullPhotoPreviewDialog extends DialogFragment {

    public static final String ARG_PHOTO_ID = "photoId";
    private String mPhotoId;

    private ImageView mFullPhotoImageView;

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

//        mFullPhotoImageView = view.findViewById(R.id.fullPhotoPreview_imageView);

        return view;
    }
}
