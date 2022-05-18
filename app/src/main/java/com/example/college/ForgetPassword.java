package com.example.college;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetPassword extends AppCompatActivity {
    private Button forgetbtn;
    private EditText forgetemail;
    private String email;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        auth=FirebaseAuth.getInstance();
        forgetemail=findViewById(R.id.forgetemail);
        forgetbtn=findViewById(R.id.forgetbtn);
        forgetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateData();
            }
        });
    }

    private void validateData() {
        email=forgetemail.getText().toString();
        if(email.isEmpty()){
            forgetemail.setError("Requried");
        }else{
            forgetPass();

        }
    }

    private void forgetPass() {
        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(ForgetPassword.this, "Check your Email", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(ForgetPassword.this,Login.class));
                    finish();
                }else{
                    Toast.makeText(ForgetPassword.this, "Error:"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}