package com.nagarro.adib.home.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.nagarro.adib.home.model.HeroModel;

@Database(entities = {HeroModel.class}, version = 1, exportSchema = false)
public abstract class HeroDatabase extends RoomDatabase {



    // --- DAO ---
    public abstract HeroDao heroDao();
}
