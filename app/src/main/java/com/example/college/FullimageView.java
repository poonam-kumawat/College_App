package com.example.college;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;

public class FullimageView extends AppCompatActivity {
    private PhotoView imageview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullimage_view);
        getSupportActionBar().setTitle("Gallery");
        String image=getIntent().getStringExtra("image");
        imageview=findViewById(R.id.imageview);
        Glide.with(this).load(image).into(imageview);
    }
}