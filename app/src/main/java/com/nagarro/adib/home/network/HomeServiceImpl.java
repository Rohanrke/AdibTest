package com.nagarro.adib.home.network;



import android.arch.lifecycle.MutableLiveData;

import com.nagarro.adib.App;
import com.nagarro.adib.core.ConnectionFactory;
import com.nagarro.adib.home.db.HeroDao;
import com.nagarro.adib.home.model.HeroModel;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeServiceImpl {


    private HeroDao heroDao;





    /**
     *   // Dagger can be used for dependency injection for HeroDao
     *
     */
    public HomeServiceImpl(){

        heroDao = App.getInstance().getDatabase().heroDao();
    }

    public void  getHeroList(){

        HomeService service = ConnectionFactory.getHttpConnection();
        Call<List<HeroModel>> call =
                service.getHeroList();

        call.enqueue(new Callback<List<HeroModel>>() {
            @Override
            public void onResponse(Call<List<HeroModel>> call, Response<List<HeroModel>> response) {
                List<HeroModel> model = response.body();
                heroDao.save(model);
            }

            @Override
            public void onFailure(Call<List<HeroModel>> call, Throwable t) {


            }
        });


    }

}
