package com.nagarro.adib.home;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.nagarro.adib.home.model.HeroModel;
import com.nagarro.adib.home.repo.HomeRepo;


public class HomeDetailViewModel extends ViewModel {

    private LiveData<HeroModel> data;
    private HomeRepo repo = new HomeRepo();

    public LiveData<HeroModel> getData(String name) {
        if (this.data == null) {
            data = repo.getHero(name);
        }
        return data;
    }



}
