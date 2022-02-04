package com.example.hw26.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.hw26.model.TaskModel;
import com.example.hw26.model.TaskModel;

@Database(entities = {TaskModel.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract com.example.hw26.room.TaskDao taskDao();
}
