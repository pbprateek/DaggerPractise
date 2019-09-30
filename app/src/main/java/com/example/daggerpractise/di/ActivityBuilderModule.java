package com.example.daggerpractise.di;


import com.example.daggerpractise.di.auth.AuthModule;
import com.example.daggerpractise.di.auth.AuthViewModelModule;
import com.example.daggerpractise.di.main.MainFragmentBuildersModule;
import com.example.daggerpractise.di.main.MainModule;
import com.example.daggerpractise.di.main.MainViewModelsModule;
import com.example.daggerpractise.ui.auth.AuthActivity;
import com.example.daggerpractise.ui.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {


    //This limits the Scope of AuthViewModel to Auth Activity,internall this creates a SubComponent
    @ContributesAndroidInjector(modules = {AuthViewModelModule.class, AuthModule.class})
    abstract AuthActivity contributeAuthActivity();

    @ContributesAndroidInjector(modules = {MainFragmentBuildersModule.class, MainViewModelsModule.class, MainModule.class})
    abstract MainActivity contributeMainActivity();






}
