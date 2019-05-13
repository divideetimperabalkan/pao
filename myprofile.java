package com.example.myapplication2;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.InputStream;

public class myprofile extends AppCompatActivity {
    private TextView profile_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myprofile);
       // profile_name=(TextView)findViewById(R.id.myprofile_name);
       // profile_name.setText(getIntent().getStringExtra("Name"));
      //  SharedPreferences sharedPreferences=getSharedPreferences("Pr", Context.MODE_PRIVATE);
       // String id_token=sharedPreferences.getString("Logged","Not logged");
      //  profile_name.setText(id_token);

    }
    private void readuser(){
        user  user1=new user();
      //  InputStream=getResources().openRawResource(R.raw.data);

    }

}
