package com.example.dsg.model.domain;

import android.location.Location;

import com.example.dsg.model.DataManager;
import com.example.dsg.model.web.venue.Photo;
import com.example.dsg.model.web.venue.Venue;
import com.example.dsg.model.web.venue.Venues;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static com.example.dsg.controller.utils.Constants.EMPTY_STRING;


public class VenueMapper {

    private DataManager mDataManager;

    public VenueMapper(DataManager dataManager) {
        mDataManager = dataManager;
    }

    public VenueDisplaybleItem mapToDisplayableItem(Venue venue) throws Exception {
        VenueDisplaybleItem venueDisplaybleItem = new VenueDisplaybleItem();

        venueDisplaybleItem.setmId(venue.getId());
        venueDisplaybleItem.setmName(venue.getName());
        venueDisplaybleItem.setmUrl(venue.getUrl());
        Photo photo = venue.getPhotos() != null ? venue.getPhotos().get(0) : null;
        venueDisplaybleItem.setmPhotoUrl(photo != null ? photo.getUrl() : EMPTY_STRING);
        venueDisplaybleItem.setmDistanceFromCurrentLocation(getDistanceInMiles(venue));
        com.example.dsg.model.web.venue.Location location = venue.getLocation();
        String address = EMPTY_STRING;
        if (location != null) {
            if (location.getAddress() != null) {
                address = location.getAddress() + ", " + location.getCity() + "," + location.getState() + "," + location.getCountry() + "," + location.getPostalCode();
            }
        }
        venueDisplaybleItem.setmDisplayableAddress(address);
        return venueDisplaybleItem;

    }

    public float getDistanceInMiles(Venue venue) {
        float distance = 0;

        if (mDataManager.isCurrentLocationAvailable()) {
            float[] dist = new float[1];
            Location.distanceBetween(mDataManager.getmCurrentLatitude(), mDataManager.getmCurrentLongitude(), venue.getLocation().getLatitude(), venue.getLocation().getLongitude(), dist);
            distance = dist[0] * 0.000621371192f;
        }
        return roundTwoDecimals(distance);
    }

    float roundTwoDecimals(float d) {
        DecimalFormat twoDForm = new DecimalFormat("#.##");
        return Float.valueOf(twoDForm.format(d));
    }

    public List<VenueDisplaybleItem> getVenueDisplaybleItemList(Venues venues) {

        List<VenueDisplaybleItem> venueDisplaybleItems = new ArrayList<>();
        for (Venue venue : venues.getmVenues()) {
            try {
                venueDisplaybleItems.add(mapToDisplayableItem(venue));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return venueDisplaybleItems;

    }

}
