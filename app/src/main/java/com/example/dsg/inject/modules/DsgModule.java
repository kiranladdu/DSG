package com.example.dsg.inject.modules;

import android.app.Application;
import android.content.Context;

import com.example.dsg.model.DataManager;
import com.example.dsg.model.web.WebManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class DsgModule {

    private Application mApplication;

    public DsgModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    public Application provideApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return mApplication;
    }


    @Provides
    @Singleton
    WebManager provideWebManager(Retrofit retrofit) {
        return new WebManager(retrofit);
    }

    @Provides
    @Singleton
    DataManager provideDataManager(Context context) {
        return new DataManager();
    }

}