package com.example.college;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Notice extends AppCompatActivity {
    private RecyclerView deleteNoticeRecycle;
    private ProgressBar Progressbar;
    private ArrayList<NoticeData> list;
    private noticeadapter adapter;
    private DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);
        getSupportActionBar().setTitle("Notice");
        deleteNoticeRecycle=findViewById(R.id.deleteNoticeRecycle);
        Progressbar=findViewById(R.id.Progressbar);
        reference= FirebaseDatabase.getInstance().getReference().child("Notice");

        deleteNoticeRecycle.setLayoutManager(new LinearLayoutManager(Notice.this));
        deleteNoticeRecycle.setHasFixedSize(true);
        getNotice();



    }

    private void getNotice() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list=new ArrayList<>();
                for (DataSnapshot snapshot1:snapshot.getChildren() ){
                    NoticeData data=snapshot1.getValue(NoticeData.class);
                    list.add(0,data);
                }
                adapter=new noticeadapter(Notice.this,list);
                adapter.notifyDataSetChanged();
                Progressbar.setVisibility(View.GONE);
                deleteNoticeRecycle.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Progressbar.setVisibility(View.GONE);
                Toast.makeText(Notice.this, error.getMessage(), Toast.LENGTH_SHORT).show();


            }
        });

    }
}
