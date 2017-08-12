package com.example.shreya.myapplication;


import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class result extends AppCompatActivity {
    TextView tv1,tv2,tv3;
    String user="",pass="",sug="",dt="";
    EditText ex;
    Button b99,b94,b95;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        tv1=(TextView) findViewById(R.id.tv1);
        tv2=(TextView) findViewById(R.id.tv2);
        tv3=(TextView) findViewById(R.id.tv3);
        user=getIntent().getStringExtra("user");
        pass=getIntent().getStringExtra("pass");
        ex=(EditText) findViewById(R.id.ex);
        b99=(Button) findViewById(R.id.b99);
        b94=(Button) findViewById(R.id.b94);
        b95=(Button) findViewById(R.id.b95);

        dt=String.valueOf(new java.util.Date());

        tv1.setText(user);

        tv2.setOnClickListener(new View.OnClickListener(){public void onClick(View k){
            Intent i = new Intent(getApplicationContext(), Main3Activity.class);
            startActivity(i);

        }});
        tv3.setOnClickListener(new View.OnClickListener(){public void onClick(View k){
            Intent i = new Intent(getApplicationContext(), Main4Activity.class);
            i.putExtra("user", user);
            i.putExtra("pass", pass);
            startActivity(i);

        }});
        b99.setOnClickListener(new View.OnClickListener(){public void onClick(View k){
            sug=ex.getText().toString();

            SQLiteDatabase mydb=openOrCreateDatabase("studb",MODE_PRIVATE,null);
            mydb.execSQL("CREATE TABLE IF NOT EXISTS sugges(sugg varchar, dat varchar, user varchar,pass varchar);");

            mydb.execSQL("INSERT INTO sugges values("+"'"+sug+"'"+","+"'"+dt+"'"+","+"'"+user+"'"+","+"'"+pass+"'"+");");

            Toast.makeText(getApplicationContext(),"Suggest",Toast.LENGTH_LONG);

            Intent i = new Intent(getApplicationContext(), result.class);
            startActivity(i);

        }});
        b95.setOnClickListener(new View.OnClickListener(){public void onClick(View k){
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);

        }});
        b94.setOnClickListener(new View.OnClickListener(){public void onClick(View k){
            Intent i = new Intent(getApplicationContext(), view_reply.class);
            i.putExtra("user", user);
            i.putExtra("pass", pass);
            startActivity(i);

        }});



    }
}