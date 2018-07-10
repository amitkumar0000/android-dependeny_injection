package com.android.databinding.component;


import android.content.Context;

import com.android.databinding.models.War;
import com.android.databinding.module.ContextModule;

import dagger.Component;
import dagger.Module;

@Component(modules = ContextModule.class)
public interface BattleComponent {
    War getWar();

    Context getContext();
}
