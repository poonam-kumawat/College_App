package com.example.college.Dept;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.college.R;

public class Bscit extends AppCompatActivity implements View.OnClickListener {
    private CardView eligible,course;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bscit);
        getSupportActionBar().setTitle("Information Technology");
        eligible=findViewById(R.id.eligible);
        course=findViewById(R.id.course);
        eligible.setOnClickListener(this);
        course.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.eligible:
                intent=new Intent(Bscit.this, Eligibility.class);
                startActivity(intent);
                break;
            case R.id.course:
                intent=new Intent(Bscit.this, Course.class);
                startActivity(intent);
                break;

        }
    }
}