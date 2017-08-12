package com.example.shreya.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.util.*;
import java.util.Calendar;
import java.util.Date;


public class Main_admin extends AppCompatActivity {
    EditText e10;
    Button b10,ba1,ba9;
    TextView t10;
    String msg="",dt="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitvity_admin);
        e10=(EditText) findViewById(R.id.e10);
        b10=(Button) findViewById(R.id.b10);
        t10=(TextView)findViewById(R.id.t10);
        ba1=(Button)findViewById(R.id.ba1);
        ba9=(Button)findViewById(R.id.ba9);
        dt=String.valueOf(new java.util.Date());

        b10.setOnClickListener(new View.OnClickListener(){public void onClick(View k){
            msg=e10.getText().toString();

            SQLiteDatabase mydb=openOrCreateDatabase("studb",MODE_PRIVATE,null);
            mydb.execSQL("CREATE TABLE IF NOT EXISTS messg(message varchar, date1 varchar);");


                mydb.execSQL("INSERT INTO messg values("+"'"+msg+"'"+","+"'"+dt+"'"+")");

                Toast.makeText(getApplicationContext(), "POSTED", Toast.LENGTH_LONG);
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);

        }});
        t10.setOnClickListener(new View.OnClickListener(){public void onClick(View k){
        Intent i=new Intent(getApplicationContext(),student_det.class);
            startActivity(i);


        }});

        ba1.setOnClickListener(new View.OnClickListener(){public void onClick(View k){
            Intent i=new Intent(getApplicationContext(),Show_sugg.class);
            startActivity(i);


        }});
        ba9.setOnClickListener(new View.OnClickListener(){public void onClick(View k){
            Intent i=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);


        }});
    }
}
