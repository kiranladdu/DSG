package com.example.dsg.controller.venues;

import android.content.Context;
import android.databinding.Bindable;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.example.dsg.R;
import com.example.dsg.model.domain.VenueDisplaybleItem;
import com.example.dsg.viewmodel.DsgViewModel;

public class VenuesListItemViewModel extends DsgViewModel {

    VenueDisplaybleItem mVenueDisplaybleItem;
    private VenuesListItemCallback mCallback;

    public VenuesListItemViewModel(VenuesListItemCallback callback, VenueDisplaybleItem venueDisplaybleItem) {
        mCallback = callback;
        mVenueDisplaybleItem = venueDisplaybleItem;
    }

    @Bindable
    public String getName() {
        return mVenueDisplaybleItem.getmName();
    }

    @Bindable
    public String getAddress() {
        return mVenueDisplaybleItem.getmDisplayableAddress();
    }

    @Bindable
    public String getDistance() {
        return String.valueOf(mVenueDisplaybleItem.getmDistanceFromCurrentLocation());
    }

    @Bindable
    public Drawable getDrawable() {
        Context context = ((Fragment) mCallback).getContext();
        int drawableResId = mVenueDisplaybleItem.ismIsFavorite() ? R.drawable.ic_star_black : R.drawable.ic_star_border_black;
        return ContextCompat.getDrawable(context, drawableResId);
    }

    @Bindable
    public int getColorResId() {
        int colorResId = mVenueDisplaybleItem.ismIsFavorite() ? R.color.green : R.color.gray_dark;
        Context context = ((Fragment) mCallback).getContext();
        return ContextCompat.getColor(context, colorResId);
    }

    public View.OnClickListener onClickListenerVenue() {
        return this::onClickVenue;
    }

    public void onClickVenue(View view) {
        mCallback.onClickVenue(mVenueDisplaybleItem);
    }

    public View.OnClickListener onClickListenerFavorite() {
        return this::onClickVenueFavorite;
    }

    public void onClickVenueFavorite(View view) {
        mCallback.onClickVenueFavorite(mVenueDisplaybleItem, !mVenueDisplaybleItem.ismIsFavorite());
    }

}
