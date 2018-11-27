package com.nagarro.adib.home.repo;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.nagarro.adib.home.db.HeroDao;
import com.nagarro.adib.home.model.HeroModel;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class HomeRepoTest {

    private LiveData<List<HeroModel>> data;

    @Mock
    private HeroDao mockHeroDao;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        data = new MutableLiveData<>();
    }

    @Test
    public void getHeroData() {
    }

    @Test(expected = RuntimeException.class)
    public void testAddHero() {
        HeroModel heroModel = new HeroModel();
        heroModel.setName("Hero");
        Mockito.when(mockHeroDao.save(heroModel))
                .thenReturn(new HeroModel());


    }
    @Test
    public void testGetHeroByName(){

      HeroModel heroModel = mockHeroDao.getHero("Hero").getValue();
      Assert.assertNotNull(heroModel);
      Assert.assertEquals("Hero",heroModel.getName());

    }

    @Test
    public void getHero() {
        data = mockHeroDao.load();
        Assert.assertNull(data);
        Assert.assertTrue(data.getValue().size()>0);

    }
}