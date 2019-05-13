package com.example.myapplication2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class faq extends AppCompatActivity  {
    private Button b1;
    private EditText q;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
        b1=(Button) findViewById(R.id.faq_button);
        q=(EditText)findViewById(R.id.faq_edittext);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String filename="appliancesorders";
                String userinfo=q+"\n";
                try {
                    FileOutputStream out=openFileOutput(filename, Context.MODE_PRIVATE);
                    out.write(userinfo.getBytes());
                    out.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }});





    }
}
