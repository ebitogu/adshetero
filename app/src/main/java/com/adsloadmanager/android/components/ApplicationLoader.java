package com.adsloadmanager.android.components;

import android.app.Application;

import com.adsloadmanager.android.R;
import com.google.android.gms.ads.MobileAds;

public class ApplicationLoader extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        MobileAds.initialize(this, getString(R.string.admob_app_id));
    }

}
