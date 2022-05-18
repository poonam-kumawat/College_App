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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class registeration extends AppCompatActivity {
    private EditText registername,registeremail,registerpassword,registerno,registerclass;
    private Button register;
    private String name,email,pass,num,classs;
    private FirebaseAuth auth;
    private TextView openlog;
    private DatabaseReference reference,dbref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        auth=FirebaseAuth.getInstance();
        reference= FirebaseDatabase.getInstance().getReference();
        registername=findViewById(R.id.registername);
        registeremail=findViewById(R.id.registeremail);
        registerpassword=findViewById(R.id.registerpassword);
        registerno=findViewById(R.id.registerno);
        registerclass=findViewById(R.id.registerclass);
        register=findViewById(R.id.register);
        openlog=findViewById(R.id.openlog);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateData();
            }
        });
        openlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogin();
            }
        });
    }

    private void openLogin() {
        startActivity(new Intent(registeration.this,Login.class));
        finish();

    }
    @Override
    protected void onStart() {
        super.onStart();
        if(auth.getCurrentUser() !=null){
            openMain();
        }
    }

    private void openMain() {
        startActivity(new Intent(registeration.this,Dashboard.class));
        finish();
    }



    private void validateData() {
        name=registername.getText().toString();
        email=registeremail.getText().toString();
        pass=registerpassword.getText().toString();
        num=registerno.getText().toString();
        classs=registerclass.getText().toString();
        if(name.isEmpty()){
            registername.setError("Required");
            registername.requestFocus();
        }else if(email.isEmpty()){
            registeremail.setError("Required");
            registeremail.requestFocus();

        }else if(pass.isEmpty()){
            registerpassword.setError("Required");
            registerpassword.requestFocus();

        }else if(num.isEmpty()){
            registerno.setError("Required");
            registerno.requestFocus();

        }else if(classs.isEmpty()){
            registerclass.setError("Required");
            registerclass.requestFocus();

        }else{
            createuser();

        }
    }

    private void createuser() {
        auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
                    if(user.isEmailVerified()){
                        uploadData();

                    }else{
                        user.sendEmailVerification();
                        Toast.makeText(registeration.this,"Check Your Email to Verify your Account",Toast.LENGTH_LONG).show();
                    }


                }else{
                    Toast.makeText(registeration.this, "Error:"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(registeration.this, "Error :"+e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void uploadData() {
        dbref=reference.child("users");
        String key=dbref.push().getKey();
        HashMap<String,String> user=new HashMap();
        user.put("key",key);
        user.put("name",name);
        user.put("email",email);
        user.put("Rollno",num);
        user.put("Class",classs);
        dbref.child(key).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(registeration.this, "User created", Toast.LENGTH_SHORT).show();
                    openMain();

                }else{
                    Toast.makeText(registeration.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(registeration.this,e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}