package com.example.shreya.res_billing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText e1, e2;
    Button b1, b2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.b1);
        e1 = (EditText) findViewById(R.id.e1);
        e2 = (EditText) findViewById(R.id.e2);
        b2 = (Button) findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View k) {
                Intent i = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(i);

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View k) {

                   Intent i = new Intent(getApplicationContext(), Main3Activity.class);
                        startActivity(i);


            }
        });

    }
}
