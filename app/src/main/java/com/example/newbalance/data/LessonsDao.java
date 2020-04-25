package com.example.newbalance.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface LessonsDao {
    @Query("SELECT * FROM lessons")
    LiveData<List<Lesson>> getAllLessons();

    @Query("DELETE FROM lessons")
    void deleteAllLessons();

    @Insert
    void insertLesson(Lesson lesson);
    @Delete
    void deleteLesson(Lesson lesson);

}
