package com.example.shreya.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Show_sugg extends AppCompatActivity {
    String str="",str1="",str2="",str3="";
    TextView mt;
    String tx="";
    Button ba3,log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_sugg);
        mt=(TextView) findViewById(R.id.mn);
        ba3=(Button) findViewById(R.id.ba3);
        log=(Button) findViewById(R.id.log);
        SQLiteDatabase mydatabase = openOrCreateDatabase("studb",MODE_PRIVATE,null);


        Cursor rs = mydatabase.rawQuery("Select * from sugges;",null);
        while(rs.moveToNext())
        {
            str=rs.getString(0);
            str1=rs.getString(1);
            str2=rs.getString(2);
            str3=rs.getString(3);
            mt.append(str+"\t\t"+str1+"\t\t"+str2+"\t\t"+str3+"\n");

        }
        ba3.setOnClickListener(new View.OnClickListener(){public void onClick(View k){
            Intent i = new Intent(getApplicationContext(), reply.class);
            startActivity(i);

        }});

        log.setOnClickListener(new View.OnClickListener(){public void onClick(View k){
            Intent i=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);




        }});

    }
}
