package com.example.daggerpractise.ui.auth;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

public class AuthViewModel extends ViewModel {


    public MutableLiveData<String> string;

    @Inject
    public AuthViewModel() {
        string = new MutableLiveData<>();
        string.postValue("DEKHO");
    }

    public LiveData<String> getString(){
        return string;
    }


}
