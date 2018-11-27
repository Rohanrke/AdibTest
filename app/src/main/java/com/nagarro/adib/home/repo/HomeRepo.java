package com.nagarro.adib.home.repo;

import android.arch.lifecycle.LiveData;
import com.nagarro.adib.App;
import com.nagarro.adib.core.BaseRepo;
import com.nagarro.adib.home.db.HeroDao;
import com.nagarro.adib.home.model.HeroModel;
import com.nagarro.adib.home.network.HomeServiceImpl;

import java.util.List;

public class HomeRepo implements BaseRepo {

    HeroDao heroDao;

    /**
     * // Dagger can be used for dependency injection for HeroDao
     *
     */
     public HomeRepo(){

         heroDao = App.getInstance().getDatabase().heroDao();
     }

    /**
     *    Can user Dagger for HomeServiceImpl instance
     *
     */
    private HomeServiceImpl service = new HomeServiceImpl();

     public LiveData<List<HeroModel>> getHeroData(){

         service.getHeroList();
         return heroDao.load();
     }


    public LiveData<HeroModel> getHero(String name){

        return heroDao.getHero(name);
    }


}
