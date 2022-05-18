package com.example.college.Dept;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.college.R;

public class Course extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        getSupportActionBar().setTitle("Course Content");
    }
}