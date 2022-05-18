package com.example.college;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.slider.Slider;

import java.util.ArrayList;
import java.util.List;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        getSupportActionBar().setTitle("About us");
        ImageSlider imageSlider=findViewById(R.id.image_slider);

        List<SlideModel> imageList=new ArrayList<>();
        imageList.add(new SlideModel(R.drawable.img1,"COLLEGE" , ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.img2,"PLAY GROUND" ,ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.img4,"LIBRARY" ,ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.img3,"COMPUTER LAB" ,ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.img6,"CLASS ROOM" ,ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.img7,"AV ROOM", ScaleTypes.FIT));



        imageSlider.setImageList(imageList,ScaleTypes.FIT);

    }


}