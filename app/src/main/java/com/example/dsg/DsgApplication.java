package com.example.dsg;

import android.support.multidex.MultiDexApplication;

import com.example.dsg.inject.component.DaggerDsgApplicationComponent;
import com.example.dsg.inject.component.DsgComponent;
import com.example.dsg.inject.modules.DsgModule;
import com.example.dsg.model.web.WebManager;

import net.danlew.android.joda.JodaTimeAndroid;

import javax.inject.Inject;

public class DsgApplication extends MultiDexApplication {

    @Inject protected WebManager mWebManager;

    private static DsgComponent mDsgComponent;

    protected void createComponent() {
        setComponent(DaggerDsgApplicationComponent.builder()
                .dsgModule(new DsgModule(this))
                .build());
    }

    public DsgComponent getDsgComponent() {
        return mDsgComponent;
    }

    public static void setComponent(DsgComponent dsgComponent) {
        mDsgComponent = dsgComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        setupDagger();
        setupJodaTime();
    }

    private void setupDagger() {
        createComponent();
        mDsgComponent.inject(this);
    }

    private void setupJodaTime() {
        JodaTimeAndroid.init(this);
    }

}