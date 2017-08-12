package com.example.shreya.res_billing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Main2Activity extends Activity {


    EditText e3,e4,e5;
    Button b3,b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        b3=(Button)findViewById(R.id.b3);
        b4=(Button)findViewById(R.id.b4);
        e3=(EditText)findViewById(R.id.e3);
        e4=(EditText)findViewById(R.id.e4);
        e5=(EditText)findViewById(R.id.e5);
        b3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View k) {
                Toast.makeText(getApplicationContext(),"SAVED",Toast.LENGTH_LONG).show();

            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View k) {
                e3.setText("");
                e4.setText("");
                e5.setText("");

            }
        });

    }
}
