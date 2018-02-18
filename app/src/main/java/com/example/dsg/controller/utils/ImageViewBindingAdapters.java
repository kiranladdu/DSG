package com.example.dsg.controller.utils;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImageViewBindingAdapters {

    @BindingAdapter(value = {"imageUrl", "placeholder"}, requireAll = false)
    public static void setImageUrl(ImageView imageView, String imageUrl, Drawable placeHolder) {

        if (TextUtils.isEmpty(imageUrl)) return;
        Picasso.with(imageView.getContext())
                .load(imageUrl)
                .resize(512, 512)
                .centerCrop()
                .into(imageView);

    }

}
