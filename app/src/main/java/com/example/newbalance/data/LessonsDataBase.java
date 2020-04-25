package com.example.newbalance.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Lesson.class},version = 1,exportSchema = false)
public abstract class LessonsDataBase extends RoomDatabase {
    private static LessonsDataBase dataBase;
    private static final String DB_NAME ="lessons.db";
    private static final Object LOCK = new Object();

    public static LessonsDataBase getInstance(Context context)
    {
        synchronized (LOCK)
        {
            if (dataBase==null)
            {
                dataBase = Room.databaseBuilder(context,LessonsDataBase.class,DB_NAME).fallbackToDestructiveMigration().build();
            }
        }
        return dataBase;
    }
    public abstract LessonsDao lessonsDao();


}
