package com.example.newbalance.data;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.loader.content.AsyncTaskLoader;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private static LessonsDataBase database;
    private LiveData<List<Lesson>> lessons;

    public MainViewModel(@NonNull Application application) {
        super(application);
        database =LessonsDataBase.getInstance(getApplication());
        lessons=database.lessonsDao().getAllLessons();
    }

    public LiveData<List<Lesson>> getLessons() {
        return lessons;
    }
    public void insertLesson(Lesson lesson)
    {
        new InsertLessonTask().execute(lesson);
    }
    public void deleteAllLessons()
    {
        new DeleteAllLessonsTask().execute();

    }
    public static class DeleteAllLessonsTask extends AsyncTask<Void,Void,Void>
    {

        @Override
        protected Void doInBackground(Void... voids) {
            database.lessonsDao().deleteAllLessons();
            return null;
        }
    }
    public static class InsertLessonTask extends AsyncTask<Lesson,Void,Void>
    {

        @Override
        protected Void doInBackground(Lesson... lessons) {
            database.lessonsDao().insertLesson(lessons[0]);
            return null;
        }
    }

}
