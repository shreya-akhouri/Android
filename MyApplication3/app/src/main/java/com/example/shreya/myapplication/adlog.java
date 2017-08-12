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



public class adlog extends AppCompatActivity {
    EditText e20,e21;
    Button b20;
    String user="",pass="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adlog);
        e20=(EditText) findViewById(R.id.e20);
        e21=(EditText) findViewById(R.id.e21);
        b20=(Button) findViewById(R.id.b20);


        b20.setOnClickListener(new View.OnClickListener(){public void onClick(View k){
            user=e20.getText().toString();
            pass=e21.getText().toString();
            if(user.equals("admin"))
            {
                if(pass.equals("new"))
                {
                    Toast.makeText(getApplicationContext(),user,Toast.LENGTH_LONG);
                    Intent i = new Intent(getApplicationContext(), Main_admin.class);
                    startActivity(i);

                }
                else{
                    Toast.makeText(getApplicationContext(),"invalid password",Toast.LENGTH_LONG);
                }
            }

            else{
                Toast.makeText(getApplicationContext(),"invalid username",Toast.LENGTH_LONG);
            }

        }});



    }
}
