package com.movilecourse.zunecommerce.Helper;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.movilecourse.zunecommerce.Domain.CartDomain;
import com.movilecourse.zunecommerce.Interface.CartDAO;

@Database(entities = {CartDomain.class},version = 1,exportSchema = false)
public abstract  class CartDatabase extends RoomDatabase {

    private static CartDatabase instance;
    public abstract CartDAO Dao();

    public static synchronized CartDatabase getInstance(Context context) {

        if (instance == null) {

            instance = Room.databaseBuilder(context.getApplicationContext(),
                            CartDatabase.class, "cart_database")
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries()
                            .build();
        }
        return instance;
    }
}
