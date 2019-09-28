package com.example.daggerpractise.ui.auth;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.daggerpractise.models.User;
import com.example.daggerpractise.network.auth.AuthApi;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class AuthViewModel extends ViewModel {


    private static final String TAG = "AuthViewModel";

    private final AuthApi authApi;

    public MutableLiveData<String> string;

    @Inject
    public AuthViewModel(AuthApi authApi) {
        this.authApi = authApi;
        string = new MutableLiveData<>();
        string.postValue("DEKHO");


        authApi.getUser(1).toObservable().subscribeOn(Schedulers.io()).subscribe(new Observer<User>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(User responseBody) {
                Log.d(TAG, responseBody.getUsername());
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    public LiveData<String> getString() {
        return string;
    }


}
