package com.example.shreya.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;


public class student_det extends AppCompatActivity {


    String user="",mobile="";
    TextView met;
    Button log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_det);
        met=(TextView) findViewById(R.id.met);
        SQLiteDatabase mydb=openOrCreateDatabase("studb",MODE_PRIVATE,null);
        Cursor resultSet=mydb.rawQuery("Select * from stud1;",null);
        log=(Button) findViewById(R.id.log);
        while(resultSet.moveToNext())
        {
            user= resultSet.getString(0);
            mobile=resultSet.getString(3);
            met.append(user+"\t\t\t\t\t\t\t\t\t\t\t"+mobile+"\n");
        }

        log.setOnClickListener(new View.OnClickListener(){public void onClick(View k){
            Intent i=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);




        }});


    }
}
