package com.example.dsg.model;

import com.example.dsg.model.domain.VenueDisplaybleItem;

import java.util.List;

import javax.inject.Inject;

public class DataManager {

    private double mCurrentLatitude;
    private double mCurrentLongitude;
    private List<VenueDisplaybleItem> mVenueDisplaybleItemList;

    @Inject
    public DataManager() {
    }

    public void setCurrentLocation(double latitude, double longtiude){
       mCurrentLatitude = latitude;
       mCurrentLongitude = longtiude;
   }

    public double getmCurrentLatitude() {
        return mCurrentLatitude;
    }

    public double getmCurrentLongitude() {
        return mCurrentLongitude;
    }

    public boolean isCurrentLocationAvailable(){
       return mCurrentLatitude != 0 && mCurrentLongitude != 0;
   }

    public List<VenueDisplaybleItem> getmVenueDisplaybleItemList() {
        return mVenueDisplaybleItemList;
    }

    public void setmVenueDisplaybleItemList(List<VenueDisplaybleItem> mVenueDisplaybleItemList) {
        this.mVenueDisplaybleItemList = mVenueDisplaybleItemList;
    }

    public void setVenueFavorite(VenueDisplaybleItem venueDisplaybleItem, boolean isFavorite){
        for (VenueDisplaybleItem item: mVenueDisplaybleItemList){
            if (item.getmId().equalsIgnoreCase(venueDisplaybleItem.getmId())){
                item.setmIsFavorite(isFavorite);
            } else{
                item.setmIsFavorite(false);
            }
        }
    }
}
