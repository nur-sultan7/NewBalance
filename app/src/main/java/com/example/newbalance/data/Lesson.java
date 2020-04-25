package com.example.newbalance.data;

import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "lessons")
public class Lesson {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String lessonName;
    private String startTime;
    private String endTime;
    private String teacherName;
    private String placeName;
    private String description;
    private int dayOfWeek;



    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }


    public Lesson(int id, String lessonName, String startTime, String endTime, String teacherName, String placeName, String description, int dayOfWeek) {
        this.id = id;
        this.lessonName = lessonName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.teacherName = teacherName;
        this.placeName = placeName;
        this.description = description;
        this.dayOfWeek = dayOfWeek;
    }

    public int getId() {
        return id;
    }

    public int getDayOfWeek()
    {
        return dayOfWeek;
    }
    public String getDayOfWeekString() {
        switch (dayOfWeek)
        {
            case 1:
                return "Понедельник";
            case 2:
                return "Вторник";
            case 3:
                return "Среда";
            case 4:
                return "Четверг";
            case 5:
                return "Пятница";
            case 6:
                return "Суббота";
            default:
                return "Воскресенье";
        }
    }

    @Ignore
    public Lesson(String lessonName, String startTime, String endTime, String teacherName, String placeName, String description, int dayOfWeek) {
        this.lessonName = lessonName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.teacherName = teacherName;
        this.placeName = placeName;
        this.description = description;
        this.dayOfWeek = dayOfWeek;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
