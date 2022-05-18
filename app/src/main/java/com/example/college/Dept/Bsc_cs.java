package com.example.college.Dept;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.college.R;

public class Bsc_cs extends AppCompatActivity implements View.OnClickListener {
    private CardView coursecs,eligiblecs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bsc_cs);
        getSupportActionBar().setTitle("Computer Science");
        coursecs=findViewById(R.id.coursecs);
        eligiblecs=findViewById(R.id.eligiblecs);
        coursecs.setOnClickListener(this);
        eligiblecs.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.eligiblecs:
                intent=new Intent(Bsc_cs.this, Eligibility_cs.class);
                startActivity(intent);
                break;
            case R.id.coursecs:
                intent=new Intent(Bsc_cs.this, Course_cs.class);
                startActivity(intent);
                break;

        }

    }
}