package com.example.newbalance.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newbalance.R;
import com.example.newbalance.data.Lesson;

import java.util.ArrayList;
import java.util.List;

public class LessonsAdapter extends RecyclerView.Adapter<LessonsAdapter.LessonViewHolder> {

    private List<Lesson> lessons=new ArrayList<>();



    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LessonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lesson_of_day,parent,false);
        return new LessonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LessonViewHolder holder, int position) {
        Lesson lesson = lessons.get(position);
        holder.textViewLesson.setText(lesson.getLessonName());
        holder.textViewStartTime.setText(lesson.getStartTime());
        holder.textViewEndTime.setText(lesson.getEndTime());
        holder.textViewTeacher.setText(lesson.getTeacherName());
        holder.textViewPlace.setText(lesson.getPlaceName());
        holder.textViewDescription.setText(lesson.getDescription());
        holder.textViewDayOfWeek.setText(lesson.getDayOfWeekString());
    }

    @Override
    public int getItemCount() {
        return lessons.size();
    }

    class LessonViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewLesson;
        private TextView textViewStartTime;
        private TextView textViewEndTime;
        private TextView textViewTeacher;
        private TextView textViewPlace;
        private TextView textViewDescription;
        private TextView textViewDayOfWeek;

        public LessonViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewLesson = itemView.findViewById(R.id.textViewLessonName);
            textViewStartTime = itemView.findViewById(R.id.textViewStartTime);
            textViewEndTime = itemView.findViewById(R.id.textViewEndTime);
            textViewTeacher = itemView.findViewById(R.id.textViewTeacherName);
            textViewPlace = itemView.findViewById(R.id.textViewPlaceName);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);
            textViewDayOfWeek = itemView.findViewById(R.id.textViewDayOfWeek);
        }
    }
}
