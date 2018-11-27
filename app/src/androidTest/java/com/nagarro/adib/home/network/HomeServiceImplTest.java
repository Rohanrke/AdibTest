package com.nagarro.adib.home.network;

import com.nagarro.adib.home.model.HeroModel;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class HomeServiceImplTest {


    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getHeroList() {

        HeroModel heroModel = new HeroModel();
        heroModel.setName("Test Name");
        Mockito.when(heroModel.getName())
    }
}