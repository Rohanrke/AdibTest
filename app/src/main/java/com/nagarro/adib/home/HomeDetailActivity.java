package com.nagarro.adib.home;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.nagarro.adib.constants.Constants;
import com.nagarro.adib.core.BaseActivity;
import com.nagarro.adib.databinding.ActivityHomeBinding;
import com.nagarro.adib.R;
import com.squareup.picasso.Picasso;

import java.net.URI;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;

public class HomeDetailActivity extends BaseActivity {

    ActivityHomeBinding mBinding;
    private HomeDetailViewModel viewModel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(HomeDetailViewModel.class);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_home);
        setData(getIntent().getStringExtra(Constants.ITEM_ID));


    }

    private void setData(String name){

        String url = viewModel.getData(name).getValue().getImageurl();
        Picasso.get()
                .load(url)
                .transform(new CropCircleTransformation())
                .into(mBinding.imageMain);
    }
}
