package com.example.daggerpractise.di;

import androidx.lifecycle.ViewModel;

import com.example.daggerpractise.ViewModelProviderFactory;
import com.example.daggerpractise.ui.auth.AuthViewModel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;

import javax.inject.Provider;

import dagger.MapKey;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;

@Module
class ViewModelFactoryModule {

    @Provides
    ViewModelProviderFactory viewModelFactory(Map<Class<? extends ViewModel>, Provider<ViewModel>> providerMap) {
        return new ViewModelProviderFactory(providerMap);
    }


}
