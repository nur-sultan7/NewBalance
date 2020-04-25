package com.example.newbalance.Utils;

import com.example.newbalance.data.Lesson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JSONUtils {
    private static String KEY_NAME = "name";
    private static String KEY_START_TIME = "startTime";
    private static String KEY_END_TIME = "endTime";
    private static String KEY_TEACHER_NAME = "teacher";
    private static String KEY_PLACE = "place";
    private static String KEY_DESCRIPTION = "description";
    private static String KEY_WEEK_OF_DAY = "weekDay";

    public static ArrayList<Lesson> getArrayJSON(JSONArray jsonArray)
    {
        ArrayList<Lesson> arrayList=new ArrayList<>();
        if (jsonArray==null)
            return arrayList;
        for (int i=0;i<jsonArray.length();i++)
        {
            try {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String lessonName = jsonObject.getString(KEY_NAME);
                String startTime = jsonObject.getString(KEY_START_TIME);
                String endTime = jsonObject.getString(KEY_END_TIME);
                String teacherName = jsonObject.getString(KEY_TEACHER_NAME);
                String placeName = jsonObject.getString(KEY_PLACE);
                String description = jsonObject.getString(KEY_DESCRIPTION);
                int weekOfDay = jsonObject.getInt(KEY_WEEK_OF_DAY);
                arrayList.add(new Lesson(lessonName,startTime,endTime,teacherName,placeName,description,weekOfDay));
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
        return arrayList;
    }
}
