package com.example.dsg.controller.venues;

import com.example.dsg.model.domain.VenueDisplaybleItem;



public interface VenuesListItemCallback {
    void onClickVenue(VenueDisplaybleItem venueDisplaybleItem);
    void onClickVenueFavorite(VenueDisplaybleItem venueDisplaybleItem, boolean isFavorite);
}
