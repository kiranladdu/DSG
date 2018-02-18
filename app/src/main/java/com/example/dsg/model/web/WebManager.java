package com.example.dsg.model.web;

import com.example.dsg.model.web.venue.Venue;
import com.example.dsg.model.web.venue.Venues;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import retrofit2.Retrofit;

public class WebManager {

    private RequestInterface mRequestInterface;

    @Inject
    public WebManager(Retrofit retrofit) {
        mRequestInterface = retrofit.create(RequestInterface.class);
    }

    public Single<Venues> getVenues() {
        return mRequestInterface.getVenues();
    }
}
