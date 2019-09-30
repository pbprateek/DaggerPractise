package com.example.daggerpractise.ui.auth;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.daggerpractise.SessionManager;
import com.example.daggerpractise.models.User;
import com.example.daggerpractise.network.auth.AuthApi;

import javax.inject.Inject;

import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class AuthViewModel extends ViewModel {


    private static final String TAG = "AuthViewModel";

    private final AuthApi authApi;
    private SessionManager sessionManager;


    @Inject
    public AuthViewModel(AuthApi authApi, SessionManager sessionManager) {
        this.authApi = authApi;
        this.sessionManager = sessionManager;

    }


    public void authenciateWithId(int id) {
        sessionManager.authenticateWithId(queryuserId(id));
    }


    private LiveData<AuthResource<User>> queryuserId(int id) {
        return LiveDataReactiveStreams.fromPublisher(
                authApi.getUser(id)
                        .onErrorReturn(new Function<Throwable, User>() {
                            @Override
                            public User apply(Throwable throwable) throws Exception {
                                //Create a Dummy User to Return
                                User errorUser = new User();
                                errorUser.setId(-1);
                                return errorUser;
                            }
                        }).map(new Function<User, AuthResource<User>>() {
                    @Override
                    public AuthResource<User> apply(User user) throws Exception {
                        if (user.getId() == -1) {
                            return AuthResource.error("Could not Authenticate", (User) null);
                        }
                        return AuthResource.authenticated(user);
                    }
                })
                        .subscribeOn(Schedulers.io())
        );
    }


    public LiveData<AuthResource<User>> observeAuthState() {
        return sessionManager.getAuthUser();
    }


}
