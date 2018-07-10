package com.android.databinding.models;

import android.content.Context;

import javax.inject.Inject;

public class War {

    Boltons boltons;
    Starks starks;

    @Inject
    public War( Boltons boltons, Starks starks){
        this.boltons = boltons;
        this.starks = starks;
    }

    public void perpare(){
        boltons.prepareForWar();
        starks.prepareForWar();
    }

    public void report(){
        boltons.reportForWar();
        starks.reportForWar();
    }


}
