package com.example.daggerpractise.di;


import com.example.daggerpractise.AuthActivity;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {


    @ContributesAndroidInjector
    abstract AuthActivity contributeAuthActivity();






}
