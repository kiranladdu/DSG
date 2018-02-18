package com.example.dsg.controller.venues.detail;

import android.databinding.Bindable;

import com.example.dsg.model.domain.VenueDisplaybleItem;
import com.example.dsg.viewmodel.DsgViewModel;


public class VenueDetailViewModel extends DsgViewModel {

    VenueDisplaybleItem mVenueDisplaybleItem;
    private VenueDetailCallback mCallback;

    public VenueDetailViewModel(VenueDetailCallback callback, VenueDisplaybleItem venueDisplaybleItem) {
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
    public String getPhotoUrl() {

        return mVenueDisplaybleItem.getmPhotoUrl();
    }


}
