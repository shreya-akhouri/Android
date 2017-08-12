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

public class Main4Activity extends AppCompatActivity {
    String user="",pass="",email="",session="",branch="",mobile="";
    TextView t40,t41,t42,t43,t44,t45;
    Button b55;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        t40=(TextView) findViewById(R.id.t40);
        t41=(TextView) findViewById(R.id.t41);
        t42=(TextView) findViewById(R.id.t42);
        t44=(TextView) findViewById(R.id.t44);
        t45=(TextView) findViewById(R.id.t45);
        b55=(Button) findViewById(R.id.b55);
        user=getIntent().getStringExtra("user");
        pass=getIntent().getStringExtra("pass");
        t40.setText(user);
    //Toast.makeText(getApplicationContext(),"username="+user+"password="+pass,Toast.LENGTH_LONG).show();
           SQLiteDatabase mydb=openOrCreateDatabase("studb",MODE_PRIVATE,null);
            Cursor resultSet=mydb.rawQuery("Select * from stud1 where username = '"+user+"'and pass= '"+pass+"';",null);
        //Toast.makeText(getApplicationContext(),"okay",Toast.LENGTH_LONG).show();
            /**if(user.equals("")&& pass.equals(""))
            {
                Toast.makeText(getApplicationContext() , "Please Enter  User Name or Password" , Toast.LENGTH_LONG ).show();
            }**/
            try {
                if (resultSet.moveToFirst()) {
                    email = resultSet.getString(2);
                    mobile = resultSet.getString(3);
                    branch = resultSet.getString(4);
                    session = resultSet.getString(5);

                    t41.setText(email);
                    t42.setText(branch);
                    t44.setText(session);
                    t45.setText(mobile);

                }
            }
            catch(Exception e)
            {

            }


 /**           else
            {
                Toast.makeText(getApplicationContext() , "Please Enter Right User Name or Password" , Toast.LENGTH_LONG ).show();
            }

**/
        b55.setOnClickListener(new View.OnClickListener(){public void onClick(View k){
            Intent i = new Intent(getApplicationContext(), Main5Activity.class);

            startActivity(i);

        }});



    }
}
