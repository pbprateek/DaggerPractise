package com.example.daggerpractise.ui.main.profile;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.daggerpractise.R;
import com.example.daggerpractise.ViewModelProviderFactory;
import com.example.daggerpractise.databinding.ProfileFragmentBinding;
import com.example.daggerpractise.models.User;
import com.example.daggerpractise.ui.auth.AuthResource;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

import static com.example.daggerpractise.ui.auth.AuthResource.AuthStatus.AUTHENTICATED;

public class ProfileFragment extends DaggerFragment {


    private static final String TAG = "ProfileFragment";
    
    private ProfileViewModel viewModel;

    private ProfileFragmentBinding binding;

    @Inject
    ViewModelProviderFactory providerFactory;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

       binding= DataBindingUtil.inflate(inflater,R.layout.profile_fragment,container,false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(this,providerFactory).get(ProfileViewModel.class);
        subscribeObservers();
    }




    private void subscribeObservers(){
        viewModel.getAuthenticatedUser().removeObservers(getViewLifecycleOwner());
        viewModel.getAuthenticatedUser().observe(getViewLifecycleOwner(), new Observer<AuthResource<User>>() {
            @Override
            public void onChanged(AuthResource<User> userAuthResource) {
                if(userAuthResource != null){
                    switch (userAuthResource.status){


                        case AUTHENTICATED:{
                            Log.d(TAG, "onChanged: ProfileFragment: AUTHENTICATED... " +
                                    "Authenticated as: " + userAuthResource.data.getEmail());
                            setUserDetails(userAuthResource.data);
                            break;
                        }

                        case ERROR:{
                            Log.d(TAG, "onChanged: ProfileFragment: ERROR...");
                            setErrorDetails(userAuthResource.message);
                            break;
                        }
                    }
                }
            }
        });
    }
    





    private void setErrorDetails(String message){
        binding.email.setText(message);
        binding.username.setText("error");
        binding.website.setText("error");
    }

    private void setUserDetails(User user){
        binding.email.setText(user.getEmail());
        binding.username.setText(user.getUsername());
        binding.website.setText(user.getWebsite());
    }

}
