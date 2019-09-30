package com.example.daggerpractise.di.main;


import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.lifecycle.ViewModel;

import com.example.daggerpractise.di.ViewModelKey;
import com.example.daggerpractise.ui.main.images.ImagesViewModel;
import com.example.daggerpractise.ui.main.profile.ProfileViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class MainViewModelsModule {


    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel.class)
    public abstract ViewModel bindProfileViewModel(ProfileViewModel viewModel);


    @Binds
    @IntoMap
    @ViewModelKey(ImagesViewModel.class)
    public abstract ViewModel bindPostsViewModel(ImagesViewModel viewModel);
}
