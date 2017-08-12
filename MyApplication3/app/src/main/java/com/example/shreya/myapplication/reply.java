package com.example.shreya.myapplication;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class reply extends AppCompatActivity {
    EditText er1,er2,er3;
    Button br1,log;
    String user="",pass="",msg="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply);

        er1=(EditText) findViewById(R.id.er1);
        er2=(EditText) findViewById(R.id.er2);
        er3=(EditText) findViewById(R.id.er3);
        br1=(Button) findViewById(R.id.br1);
        log=(Button) findViewById(R.id.log);


            br1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View k) {

                    user = er1.getText().toString();
                    pass = er2.getText().toString();
                    msg = er3.getText().toString();

                    SQLiteDatabase mydb = openOrCreateDatabase("studb", MODE_PRIVATE, null);
                    mydb.execSQL("CREATE TABLE IF NOT EXISTS repl(user varchar, pass varchar, msg varchar);");

                    mydb.execSQL("INSERT INTO repl values(" + "'" + user + "'" + "," + "'" + pass + "'" + "," + "'" + msg + "'" + ");");
                    Toast.makeText(getApplicationContext(), "SENT", Toast.LENGTH_LONG).show();
                    Intent i=new Intent(getApplicationContext(),Main_admin.class);
                    startActivity(i);


                }
            });
        log.setOnClickListener(new View.OnClickListener(){public void onClick(View k){
            Intent i=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);
        }});

    }
}
