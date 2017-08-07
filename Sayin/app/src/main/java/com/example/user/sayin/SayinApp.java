package com.example.user.sayin;

import android.app.Application;

import com.example.user.sayin.database.Sayin_database;

/**
 * Created by root on 8/8/17.
 */

public class SayinApp extends Application {

    public static Sayin_database database;
    @Override
    public void onCreate() {
        super.onCreate();
        database = new Sayin_database(getApplicationContext(),"sayin");


    }
}
