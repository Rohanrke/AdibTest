package com.nagarro.adib.home;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.nagarro.adib.home.model.HeroModel;
import com.nagarro.adib.home.repo.HomeRepo;

import java.util.List;

public class HomeViewModel extends ViewModel {

    private LiveData<List<HeroModel>> data;
    private HomeRepo repo = new HomeRepo();

    public void init() {
        if (this.data != null) {
            return;
        }
        data = repo.getHeroData();
    }

    public LiveData<List<HeroModel>> getHeroes() {

        return data;
    }






}
