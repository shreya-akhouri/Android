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

public class Main3Activity extends AppCompatActivity {
        TextView mt;
    String str="",date="";
    Button log;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mt=(TextView) findViewById(R.id.mt);
        log=(Button) findViewById(R.id.log);
        SQLiteDatabase mydatabase = openOrCreateDatabase("studb",MODE_PRIVATE,null);


        Cursor rs = mydatabase.rawQuery("Select * from messg;",null);
        while(rs.moveToNext())
        {
            str=rs.getString(0);
            date=rs.getString(1);
            mt.append(str+"\t\t\t\t\t\t\t\t"+date+"\n");

        }
        log.setOnClickListener(new View.OnClickListener(){public void onClick(View k){
            Intent i=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);





        }});

    }
}
