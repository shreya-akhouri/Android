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

public class view_reply extends AppCompatActivity {
    TextView ev1,ev2;
    String user="", pass="",rep="";
    Button log;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_reply);
        ev1 = (TextView) findViewById(R.id.ev1);
        ev2 = (TextView) findViewById(R.id.ev2);
        log=(Button) findViewById(R.id.log);
        user = getIntent().getStringExtra("user");
        pass = getIntent().getStringExtra("pass");
        SQLiteDatabase mydb = openOrCreateDatabase("studb", MODE_PRIVATE, null);
        Cursor resultSet = mydb.rawQuery("Select * from repl where user ='"+user+"' and pass='"+ pass+"';", null);

            if (resultSet.moveToFirst()) {
                rep = resultSet.getString(2);


                ev1.setText(user);
                ev2.setText(rep);


            }
            else{
                Toast.makeText(getApplicationContext(),"No reply",Toast.LENGTH_LONG).show();
            }
        log.setOnClickListener(new View.OnClickListener(){public void onClick(View k){
            Intent i=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);




        }});


    }
}
