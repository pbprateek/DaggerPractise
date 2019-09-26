package com.example.daggerpractise.di;

import androidx.lifecycle.ViewModel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import dagger.MapKey;



//Dagger will automatically generate Map bcz of @MapKey with key as any class extending ViewModel ,And any ViewModel Provider will have to
//annotate with @IntoMap Annotation to store the value in that map

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@MapKey
@interface ViewModelKey {
    Class<? extends ViewModel> value();
}
