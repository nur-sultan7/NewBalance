package com.example.newbalance.Utils;

import android.content.Context;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

public class NetworkUtils {
    private static String BASE_URL ="https://sample.fitnesskit-admin.ru/schedule/get_group_lessons_v2/1/";

    public static class AsyncJSONLoader extends AsyncTaskLoader<JSONArray>
    {


        public AsyncJSONLoader(@NonNull Context context) {
            super(context);
        }

        @Override
        protected void onStartLoading() {
            super.onStartLoading();
            forceLoad();
        }

        @Nullable
        @Override
        public JSONArray loadInBackground() {
            JSONArray result =null;
            URL url =null;
            try {
                url = new URL(BASE_URL);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            if (url==null)
            {
                return null;
            }
            HttpURLConnection connection=null;
            try {
                connection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = connection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                StringBuilder stringBuilder = new StringBuilder();
                String line = bufferedReader.readLine();
                while (line!=null)
                {
                    stringBuilder.append(line);
                    line=bufferedReader.readLine();
                }
                result = new JSONArray(stringBuilder.toString());

            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }
            finally {
                if (connection!=null)
                    connection.disconnect();
            }
            return result;

        }
    }
}
