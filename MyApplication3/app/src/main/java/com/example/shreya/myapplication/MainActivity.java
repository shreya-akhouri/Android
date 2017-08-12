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



public class MainActivity extends AppCompatActivity {
    EditText e1, e2;
    Button b1,b2,b3;
    String user="",pass="",email="",mobile="",branch="",session="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText) findViewById(R.id.e1);
        e2=(EditText) findViewById(R.id.e2);
        b1=(Button) findViewById(R.id.b1);
        b2=(Button) findViewById(R.id.b2);
        b3=(Button) findViewById(R.id.b3);
        b1.setOnClickListener(new View.OnClickListener(){public void onClick(View k){
            user=e1.getText().toString();
            pass=e2.getText().toString();
        SQLiteDatabase mydb=openOrCreateDatabase("studb",MODE_PRIVATE,null);
            Cursor resultSet=mydb.rawQuery("Select * from stud1 where Username = '"+user+"'and pass= '"+pass+"'",null);
            if(user.equals("")&& pass.equals(""))
            {
                Toast.makeText(getApplicationContext() , "Please Enter  User Name or Password" , Toast.LENGTH_LONG ).show();
            }

            else if( resultSet.moveToFirst())
            {

                user = resultSet.getString(0);
                email = resultSet.getString(2);
                mobile = resultSet.getString(3);
                branch= resultSet.getString(4);
                session = resultSet.getString(5);

                Intent i = new Intent(getApplicationContext(), result.class);
                i.putExtra("user", user);
                i.putExtra("pass", pass);
                startActivity(i);

            }
            else
            {
                Toast.makeText(getApplicationContext() , "Please Enter Right User Name or Password" , Toast.LENGTH_LONG ).show();
            }


        }});

        b2.setOnClickListener(new View.OnClickListener(){public void onClick(View k){


                Intent i = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(i);

        }});
        b3.setOnClickListener(new View.OnClickListener(){public void onClick(View k){


            Intent i = new Intent(getApplicationContext(), adlog.class);
            startActivity(i);

        }});

    }
}
