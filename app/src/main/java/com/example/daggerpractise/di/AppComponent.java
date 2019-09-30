package com.example.daggerpractise.di;

import android.app.Application;

import com.example.daggerpractise.BaseApplication;
import com.example.daggerpractise.SessionManager;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;


@Singleton
//This basically means that this Component owns the @Singelton scope,so now it will look for dependecies using
//Singelton
@Component(
        modules = {AndroidSupportInjectionModule.class, ActivityBuilderModule.class,
                AppModule.class, ViewModelFactoryModule.class}
)
public interface AppComponent extends AndroidInjector<BaseApplication> {


    SessionManager sessionManager();

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }


}
