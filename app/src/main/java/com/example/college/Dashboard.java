package com.example.college;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.college.canteen.Canteen;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener;
import com.google.firebase.auth.FirebaseAuth;

public class Dashboard extends AppCompatActivity implements OnNavigationItemSelectedListener, View.OnClickListener {
    private DrawerLayout drawerLayout;
    CardView department,gallery,notice,visit,canteen,about;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        auth=FirebaseAuth.getInstance();
        getSupportActionBar().setTitle("JK College");

        department=findViewById(R.id.department);
        gallery=findViewById(R.id.gallery);
        notice=findViewById(R.id.notice);
        visit=findViewById(R.id.visit);
        canteen=findViewById(R.id.canteen);
        about=findViewById(R.id.about);
        drawerLayout=findViewById(R.id.drawerLayout);
        navigationView=findViewById(R.id.navigation_view);
        toggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.start,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(this);
        department.setOnClickListener(this);
        gallery.setOnClickListener(this);
        notice.setOnClickListener(this);
        visit.setOnClickListener(this);
        canteen.setOnClickListener(this);
        about.setOnClickListener(this);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.option_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }
        if(item.getItemId()==R.id.logout){
            auth.signOut();
            openLogin();

        }
        return true;
    }

    private void openLogin() {
        startActivity(new Intent(Dashboard.this,Login.class));
        finish();

    }
    @Override
    protected void onStart() {
        super.onStart();
        if(auth.getCurrentUser() ==null) {
            openLogin();
        }
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()){

            case R.id.navigation_website:
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.jkghansoli.com/"));
                startActivity(intent);
                break;
            case R.id.navigation_staff:
                intent=new Intent(Dashboard.this, Teaching_Staff.class);
                startActivity(intent);
                break;

            case R.id.navigation_vedio:
                intent=new Intent(Dashboard.this, Facility.class);
                startActivity(intent);

                break;
            case R.id.navigation_rate:
                Uri uri =Uri.parse("https://play.google.com/store/apps/details?id="+getApplicationContext().getPackageName());
                Intent i =new Intent(Intent.ACTION_VIEW,uri);
                try {
                    startActivity(i);
                } catch (Exception e) {
                    Toast.makeText(this,"Unable to open" +e.getMessage(),Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.navigation_Ebook:
                intent=new Intent(Dashboard.this, Ebook.class);
                startActivity(intent);
                break;

        }
        return true;
    }








    @Override
    public void onClick(View view) {
        Intent intent;
        switch(view.getId()){
            case R.id.department:
                intent=new Intent(Dashboard.this, com.example.college.Dept.dept.class);
                startActivity(intent);
                break;
            case R.id.gallery:
                intent=new Intent(Dashboard.this, gallery.class);
                startActivity(intent);
                break;
            case R.id.notice:
                intent=new Intent(Dashboard.this, Notice.class);
                startActivity(intent);
                break;
            case R.id.visit:
                intent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("google.navigation:q=19.117114,73.003950&mode=l"));
                intent.setPackage("com.google.android.apps.maps");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
                break;
            case R.id.canteen:
                intent=new Intent(Dashboard.this, Canteen.class);
                startActivity(intent);
                break;
            case R.id.about:
                intent=new Intent(Dashboard.this, About.class);
                startActivity(intent);
                break;




        }

    }
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen((GravityCompat.START))){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else
            super.onBackPressed();
    }
}