package com.example.myapplication2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import android.support.v7.widget.Toolbar;
import android.support.v4.app.Fragment;

public class Main2Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toast.makeText(Main2Activity.this,"Succesfull log",Toast.LENGTH_LONG).show();

       Toolbar toolbar=findViewById(R.id.toolbar);
       setSupportActionBar(toolbar);
       drawer=findViewById(R.id.drawer_layout);
        NavigationView navigationView=findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
          ActionBarDrawerToggle toogle=new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toogle);
           toogle.syncState();


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.nav_appliances:
                //  getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new MessageFragment());
                Intent intent = new Intent(this, appliancesAcitivity.class);
                startActivity(intent);
                break;
            case R.id.nav_food:
                //  getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new MessageFragment());
                Intent intent2 = new Intent(this, food1Activity.class);
                startActivity(intent2);
                break;
            case R.id.nav_faq:
                //  getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new MessageFragment());
                Intent intent3 = new Intent(this, faq.class);
                startActivity(intent3);
                break;
            case R.id.nav_clothes:
                //  getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new MessageFragment());
                Intent intent4 = new Intent(this, clothesActivity.class);
                startActivity(intent4);
                break;
            case R.id.nav_profile:
                //  getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new MessageFragment());
                Intent intent5 = new Intent(this, myprofile.class);
                startActivity(intent5);
                break;







        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}