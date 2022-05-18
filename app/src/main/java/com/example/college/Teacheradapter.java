package com.example.college;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.college.R;

import java.util.List;

public class Teacheradapter extends RecyclerView.Adapter<com.example.college.Teacheradapter.Teacherviewadpter> {
    private List<TeacherData> list;
    private Context context;


    public Teacheradapter(List<com.example.college.TeacherData> list, Context context) {
        this.list = list;
        this.context = context;

    }

    @NonNull
    @Override
    public Teacherviewadpter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.faculty_item_layout, parent, false);
        return new Teacherviewadpter(view);


    }

    @Override
    public void onBindViewHolder(@NonNull Teacherviewadpter holder, int position) {
        com.example.college.TeacherData item = list.get(position);
        holder.name.setText(item.getName());
        holder.Subject.setText(item.getSubject());
        holder.post.setText(item.getPost());
        try {
            Glide.with(context).load(item.getImage()).into(holder.imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Teacherviewadpter extends RecyclerView.ViewHolder {
        private TextView name, Subject, post;
        private Button update;
        private ImageView imageView;


        public Teacherviewadpter(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.teachername);
            Subject = itemView.findViewById(R.id.teacherSubject);
            post = itemView.findViewById(R.id.teacherpost);

            imageView = itemView.findViewById(R.id.teacherimg);
        }
    }
}

