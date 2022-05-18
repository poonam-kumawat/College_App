package com.example.college.Dept;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.college.Dashboard;
import com.example.college.R;

public class dept extends AppCompatActivity implements View.OnClickListener {
     private CardView BSCIT,BSCcs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dept);
        getSupportActionBar().setTitle("Department");
        BSCIT=findViewById(R.id.BSCIT);
        BSCcs=findViewById(R.id.BSCcs);
        BSCIT.setOnClickListener(this);
        BSCcs.setOnClickListener(this);

    }
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.BSCIT:
                intent=new Intent(dept.this, Bscit.class);
                startActivity(intent);
                break;
            case R.id.BSCcs:
                intent=new Intent(dept.this, Bsc_cs.class);
                startActivity(intent);
                break;
        }
    }

}