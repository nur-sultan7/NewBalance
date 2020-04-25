package com.example.newbalance;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.newbalance.Utils.JSONUtils;
import com.example.newbalance.Utils.NetworkUtils;
import com.example.newbalance.adapters.LessonsAdapter;
import com.example.newbalance.data.Lesson;
import com.example.newbalance.data.MainViewModel;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<JSONArray> {

    private static final int LOADER_ID =1233;
    LoaderManager loaderManager;
    LessonsAdapter lessonsAdapter;
    RecyclerView recyclerView;
    MainViewModel mainViewModel;
    private boolean firstTime = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainViewModel= ViewModelProviders.of(this).get(MainViewModel.class);
        recyclerView = findViewById(R.id.recyclerViewLessens);
        lessonsAdapter = new LessonsAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(lessonsAdapter);
        loaderManager = LoaderManager.getInstance(this);
        LiveData<List<Lesson>> listLiveData = mainViewModel.getLessons();
        listLiveData.observe(this, new Observer<List<Lesson>>() {
            @Override
            public void onChanged(List<Lesson> lessons) {
                if (!firstTime) {
                    lessonsAdapter.setLessons(lessons);
                    firstTime=true;
                }
            }
        });

        downloadData();
    }
    public void downloadData()
    {
        loaderManager.restartLoader(LOADER_ID,null,this);
    }


    @NonNull
    @Override
    public Loader<JSONArray> onCreateLoader(int id, @Nullable Bundle args) {
        NetworkUtils.AsyncJSONLoader jsonLoader = new NetworkUtils.AsyncJSONLoader(this);
        return jsonLoader;
    }

    @Override
    public void onLoadFinished(@NonNull Loader<JSONArray> loader, JSONArray data) {
        ArrayList<Lesson> lessonArrayList = JSONUtils.getArrayJSON(data);
        if (lessonArrayList!=null && !lessonArrayList.isEmpty())
        {
            mainViewModel.deleteAllLessons();
            for (Lesson lesson:lessonArrayList)
            {
                mainViewModel.insertLesson(lesson);
            }
            lessonsAdapter.setLessons(lessonArrayList);
        }
        loaderManager.destroyLoader(LOADER_ID);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<JSONArray> loader) {

    }
}
