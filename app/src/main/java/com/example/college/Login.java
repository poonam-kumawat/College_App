package com.example.college;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    private TextView openreg,openforgetpass;
    private EditText logemail,logpassword;
    private Button Log;
    private String email,pass;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        auth=FirebaseAuth.getInstance();
        openreg=findViewById(R.id.openreg);
        logemail=findViewById(R.id.logemail);
        logpassword=findViewById(R.id.logpassword);
        openforgetpass=findViewById(R.id.openforgetpass);
        Log=findViewById(R.id.Log);
        openforgetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this,ForgetPassword.class));
            }
        });
        Log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateData();
            }
        });

        openreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openregister();
            }
        });
    }

    private void validateData() {
        email=logemail.getText().toString();
        pass=logpassword.getText().toString();
        if(email.isEmpty() || pass.isEmpty()) {
            Toast.makeText(this, "Please Provide all fields", Toast.LENGTH_SHORT).show();

        }else{
            loginuser();

        }

    }

    private void loginuser() {
        auth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    openMain();
                }else{
                    Toast.makeText(Login.this, "Error:"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Login.this, "Error:"+e.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void openMain() {
        startActivity(new Intent(Login.this,Dashboard.class));
        finish();

    }

    private void openregister() {
        startActivity(new Intent(Login.this,registeration.class));
        finish();
    }

}