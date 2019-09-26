package com.example.daggerpractise.di;

import androidx.lifecycle.ViewModel;

import com.example.daggerpractise.ui.auth.AuthViewModel;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;


@Module
public class AuthViewModelModule {

    @Provides
    @IntoMap
    @ViewModelKey(AuthViewModel.class)
    ViewModel authViewModel() {
        return new AuthViewModel();
    }
}
