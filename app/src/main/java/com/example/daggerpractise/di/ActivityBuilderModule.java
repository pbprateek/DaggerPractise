package com.example.daggerpractise.di;


import com.example.daggerpractise.ui.auth.AuthActivity;
import com.example.daggerpractise.ui.auth.AuthViewModel;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {


    //This limits the Scope of AuthViewModel to Auth Activity
    @ContributesAndroidInjector(modules = {AuthViewModelModule.class})
    abstract AuthActivity contributeAuthActivity();






}
