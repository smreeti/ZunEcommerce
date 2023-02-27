package com.movilecourse.zunecommerce.Interface;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.movilecourse.zunecommerce.Domain.CartDomain;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface CartDAO {
    @Insert
    void insert(CartDomain model);
    @Update
    void update(CartDomain model);
    @Delete
    void delete(CartDomain model);
    @Query("DELETE FROM cartTable")
    void deleteAllCourses();
    @Query("SELECT * FROM cartTable ORDER BY productName ASC")
    List<CartDomain> getAllItems();
}
