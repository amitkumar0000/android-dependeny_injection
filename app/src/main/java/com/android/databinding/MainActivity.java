package com.android.databinding;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.databinding.component.DaggerBattleComponent;
import com.android.databinding.models.War;
import com.android.databinding.module.ContextModule;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DaggerBattleComponent daggerBattleComponent = (DaggerBattleComponent) DaggerBattleComponent.builder().
                contextModule(new ContextModule(this)).build();


        War war = daggerBattleComponent.getWar();
        Context context = daggerBattleComponent.getContext();
        war.perpare();
        war.report();

    }
}
