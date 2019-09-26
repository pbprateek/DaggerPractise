package com.example.daggerpractise;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

public class ViewModelProviderFactory implements ViewModelProvider.Factory {


    private final Map<Class<? extends ViewModel>, Provider<ViewModel>> mProviderMap;

    @Inject
    public ViewModelProviderFactory(Map<Class<? extends ViewModel>, Provider<ViewModel>> providerMap) {
        mProviderMap = providerMap;
    }


    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        Provider<? extends ViewModel> creator = mProviderMap.get(modelClass);
        if (creator == null) { // if the viewmodel has not been created

            // loop through the allowable keys (aka allowed classes with the @ViewModelKey)
            for (Map.Entry<Class<? extends ViewModel>, Provider<ViewModel>> entry : mProviderMap.entrySet()) {

                // if it's allowed, set the Provider<ViewModel>
                if (modelClass.isAssignableFrom(entry.getKey())) {
                    creator = entry.getValue();
                    break;
                }
            }
        }

        // if this is not one of the allowed keys, throw exception
        if (creator == null) {
            throw new IllegalArgumentException("unknown model class " + modelClass);
        }

        // return the Provider
        try {
            return (T) creator.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //return (T) mProviderMap.get(modelClass).get();//This line alone works too
}
