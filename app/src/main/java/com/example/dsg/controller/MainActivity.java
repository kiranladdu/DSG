package com.example.dsg.controller;

import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.dsg.DsgApplication;
import com.example.dsg.R;
import com.example.dsg.controller.venues.VenuesListFragment;
import com.example.dsg.controller.venues.detail.VenuesDetailFragment;
import com.example.dsg.inject.component.DsgComponent;
import com.example.dsg.location.LocationHelper;
import com.example.dsg.model.DataManager;
import com.example.dsg.model.domain.VenueDisplaybleItem;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

import javax.inject.Inject;


public class MainActivity extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener, NavigationListener {

    private LocationHelper locationHelper;
    @Inject protected DataManager dataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        component().inject(this);

        locationHelper = new LocationHelper(this);
        locationHelper.checkpermission();
        if (locationHelper.checkPlayServices()) {
            locationHelper.buildGoogleApiClient();
        }
    }

    @Override public void onConnected(@Nullable Bundle bundle) {
        Location location = locationHelper.getLocation();
2        if (location != null) {
            dataManager.setCurrentLocation(location.getLatitude(), location.getLongitude());
        }

        VenuesListFragment fragment = new VenuesListFragment();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment, VenuesListFragment.TAG).commit();
    }

    @Override public void onConnectionSuspended(int i) {
        locationHelper.connectApiClient();
    }

    @Override public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    protected DsgComponent component() {
        return ((DsgApplication) getApplication()).getDsgComponent();
    }

    @Override public void showDetailScreen(VenueDisplaybleItem venueDisplaybleItem) {

        VenuesDetailFragment venuesDetailFragment = VenuesDetailFragment.newInstance(venueDisplaybleItem);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, venuesDetailFragment, VenuesListFragment.TAG);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();


    }
}
