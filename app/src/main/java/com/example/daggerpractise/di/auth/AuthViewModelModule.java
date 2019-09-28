package com.example.daggerpractise.di.auth;

import androidx.lifecycle.ViewModel;

import com.example.daggerpractise.di.ViewModelKey;
import com.example.daggerpractise.network.auth.AuthApi;
import com.example.daggerpractise.ui.auth.AuthViewModel;

import javax.inject.Inject;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;


@Module
public abstract class AuthViewModelModule {


    /*
    @Inject
    AuthApi authApi;


    @Provides
    @IntoMap
    @ViewModelKey(AuthViewModel.class)
    ViewModel authViewModel() {
        return new AuthViewModel(authApi);
    }
    */


    //Both Will work

    @IntoMap
    @ViewModelKey(AuthViewModel.class)
    @Binds
    public abstract ViewModel bindAuthViewModel(AuthViewModel viewModel);

}
