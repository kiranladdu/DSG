package com.example.dsg.model.web;

import com.example.dsg.model.web.venue.Venue;
import com.example.dsg.model.web.venue.Venues;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface RequestInterface {

    @GET("venue")
    Single<Venues> getVenues();

}
