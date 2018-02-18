package com.example.dsg.controller.venues;

import com.example.dsg.viewmodel.DsgViewModel;

public class VenuesViewModel extends DsgViewModel{
    private VenuesCallback mCallback;

    public VenuesViewModel(VenuesCallback callback) {
        mCallback = callback;
    }
}
