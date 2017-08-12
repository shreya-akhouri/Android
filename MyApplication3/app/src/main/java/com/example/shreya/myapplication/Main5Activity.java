package com.example.shreya.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main5Activity extends AppCompatActivity {
        String pass="",user="",pass2="",pass3="";
        EditText e70,e71;
    Button b70,log;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        e70=(EditText) findViewById(R.id.e70);
        e71=(EditText) findViewById(R.id.e71);
        b70=(Button) findViewById(R.id.b70);
        log=(Button) findViewById(R.id.log);

        log.setOnClickListener(new View.OnClickListener(){public void onClick(View k){
            Intent i=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);




        }});


        b70.setOnClickListener(new View.OnClickListener(){public void onClick(View k){
            pass2=e70.getText().toString();
            pass3=e71.getText().toString();
           Toast.makeText(getApplicationContext(),"new password="+pass3+"old="+pass2,Toast.LENGTH_LONG).show();
               try {
                   SQLiteDatabase mydb = openOrCreateDatabase("studb", MODE_PRIVATE, null);


                   mydb.execSQL("update stud1 set pass="+"'"+pass3+"'"+" where pass="+"'"+pass2+"'"+";");

                   Toast.makeText(getApplicationContext(), "new password=" + pass3, Toast.LENGTH_LONG).show();
               }
               catch (Exception e)
               {
                   Toast.makeText(getApplicationContext(),"error"+e, Toast.LENGTH_LONG).show();
               }
               //Intent i=new Intent(getApplicationContext(),Main4Activity.class);
               //startActivity(i);





        }});

    }
}
