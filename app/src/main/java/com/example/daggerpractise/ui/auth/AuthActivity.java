package com.example.daggerpractise.ui.auth;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.RequestManager;
import com.example.daggerpractise.R;
import com.example.daggerpractise.ViewModelProviderFactory;
import com.example.daggerpractise.databinding.ActivityAuthBinding;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class AuthActivity extends DaggerAppCompatActivity {


    @Inject
    Drawable logo;

    @Inject
    RequestManager requestManager;

    @Inject
    ViewModelProviderFactory mViewModelFactory;

    ActivityAuthBinding binding;

    private AuthViewModel authViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_auth);
        authViewModel = ViewModelProviders.of(this,mViewModelFactory).get(AuthViewModel.class);
        setLogo();

        authViewModel.getString().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.userIdInput.setText(s);
            }
        });
    }


    private void setLogo() {

        requestManager.load(logo)
                .into(binding.loginLogo);
    }
}
