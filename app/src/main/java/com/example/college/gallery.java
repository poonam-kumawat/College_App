package com.example.college;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class gallery extends AppCompatActivity {
    RecyclerView convoctioncycle, Sportscycle,sportcycle,avhan,other;
    GalleryAdapter adapter;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        getSupportActionBar().setTitle("GALLERY");
        convoctioncycle=findViewById(R.id.convoctioncycle);
        Sportscycle=findViewById(R.id.Sportscycle);
        sportcycle=findViewById(R.id.sportcycle);
        avhan=findViewById(R.id.avhan);
        other=findViewById(R.id.other);
        reference= FirebaseDatabase.getInstance().getReference().child("gallery");
        getConvoImage();
        getSportImage();
        getsportsImage();
        getavhanImage();
        getotherImage();
    }

    private void getotherImage() {
        reference.child("Other Events").addValueEventListener(new ValueEventListener() {
            List<String> imageList=new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    String data=(String)snapshot.getValue();
                    imageList.add(0,data);
                }
                adapter=new GalleryAdapter(gallery.this,imageList);
                other.setLayoutManager(new GridLayoutManager(gallery.this, 3));
                other.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {


            }
        });




    }

    private void getavhanImage() {
        reference.child("Avahan").addValueEventListener(new ValueEventListener() {
            List<String> imageList=new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    String data=(String)snapshot.getValue();
                    imageList.add(0,data);
                }
                adapter=new GalleryAdapter(gallery.this,imageList);
                avhan.setLayoutManager(new GridLayoutManager(gallery.this, 3));
                avhan.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {


            }
        });

    }

    private void getsportsImage() {
        reference.child("Sports Day").addValueEventListener(new ValueEventListener() {
            List<String> imageList=new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    String data=(String)snapshot.getValue();
                    imageList.add(0,data);
                }
                adapter=new GalleryAdapter(gallery.this,imageList);
                sportcycle.setLayoutManager(new GridLayoutManager(gallery.this, 3));
                sportcycle.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {


            }
        });

    }

    private void getSportImage() {
        reference.child("Independence Day").addValueEventListener(new ValueEventListener() {
            List<String> imageList=new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    String data=(String)snapshot.getValue();
                    imageList.add(0,data);
                }
                adapter=new GalleryAdapter(gallery.this,imageList);
                Sportscycle.setLayoutManager(new GridLayoutManager(gallery.this, 3));
                Sportscycle.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {


            }
        });
    }

    private void getConvoImage() {
        reference.child("Convocation").addValueEventListener(new ValueEventListener() {
            List<String> imageList=new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    String data=(String)snapshot.getValue();
                    imageList.add(0,data);
                }
                adapter=new GalleryAdapter(gallery.this,imageList);
                convoctioncycle.setLayoutManager(new GridLayoutManager(gallery.this, 3));
                convoctioncycle.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {


            }
        });

    }
}