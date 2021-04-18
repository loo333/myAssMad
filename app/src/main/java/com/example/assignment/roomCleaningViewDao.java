package com.example.assignment;


import androidx.room.Dao;
import androidx.room.Delete;

@Dao
public interface roomCleaningViewDao {

    @Delete
    public void deletView(roomCleaningView view);

}
