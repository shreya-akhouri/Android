package com.example.shreya.myapplication;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {
    EditText e3,e4,e5,e6,e7,e8;
    Button b3;
    String user="",pass="",email="",mobile="",branch="",session="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        e3=(EditText) findViewById(R.id.e3);
        e4=(EditText) findViewById(R.id.e4);
        e5=(EditText) findViewById(R.id.e5);
        e6=(EditText) findViewById(R.id.e6);
        e7=(EditText) findViewById(R.id.e7);
        e8=(EditText) findViewById(R.id.e8);
        b3=(Button) findViewById(R.id.b3);

        b3.setOnClickListener(new View.OnClickListener(){public void onClick(View k){
            user=e3.getText().toString();
            pass=e4.getText().toString();
            mobile=e5.getText().toString();
            email=e6.getText().toString();
           branch=e7.getText().toString();
            session=e8.getText().toString();
          SQLiteDatabase mydb=openOrCreateDatabase("studb",MODE_PRIVATE,null);
            mydb.execSQL("CREATE TABLE IF NOT EXISTS stud1(username varchar, pass varchar,email varchar,mobile varchar, branch varchar,session varchar);");

            mydb.execSQL("INSERT INTO stud1 values("+"'"+user+"'"+","+"'"+pass+"'"+","+"'"+email+"'"+","+"'"+mobile+"'"+","+"'"+branch+"'"+","+"'"+session+"'"+");");
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);

        }});

    }
}