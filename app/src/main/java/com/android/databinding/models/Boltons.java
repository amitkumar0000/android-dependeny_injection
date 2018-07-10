package com.android.databinding.models;

import android.util.Log;

import com.android.databinding.interfaces.House;

import javax.inject.Inject;

public class Boltons implements House {
    final String TAG = "BoltonsDagger";

    @Inject
    public Boltons(){}

    @Override
    public void prepareForWar() {
        Log.d(TAG," prepareForWar");
    }

    @Override
    public void reportForWar() {
        Log.d(TAG," reportForWar");

    }
}
