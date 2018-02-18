package com.example.dsg.inject.component;

import com.example.dsg.DsgApplication;
import com.example.dsg.controller.MainActivity;
import com.example.dsg.controller.base.BaseFragment;
import com.example.dsg.controller.venues.VenuesListFragment;

public interface DsgComponent {

    // Application
    void inject(DsgApplication application);

    // Activities
    void inject(MainActivity activity);

    // Fragments
    void inject(BaseFragment fragment);

    void inject(VenuesListFragment fragment);

}