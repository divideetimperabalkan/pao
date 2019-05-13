package com.example.myapplication2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class clothesActivity extends AppCompatActivity {
    private Button b1;
    private TextView d1,d2;
    private EditText adrs,loc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes);

       setContentView(R.layout.activity_appliances_acitivity);
        b1=(Button) findViewById(R.id.cl_appliances_order);
        d1=(TextView)findViewById(R.id.cl_textView);
        d2=(TextView)findViewById(R.id.cl_locatie_app);
        adrs=(EditText)findViewById(R.id.cl_editText);
        loc=(EditText)findViewById(R.id.cl_editText2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String filename="appliancesorders.csv";
                String userinfo=d1+","+d2+"\n";
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
