package com.example.shreya.res_billing;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Shreya on 09-06-2017.
 */

public class Main3Activity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


    }
    public void onClick_A(View view)
    {
        Intent i=new Intent(this, MainAActivity.class);
        startActivity(i);
    }
    public void onClick_B(View view)
    {
        Intent i=new Intent(this, MainBActivity.class);
        startActivity(i);
    }
    public void onClick_C(View view)
    {
        Intent i=new Intent(this, MainCActivity.class);
        startActivity(i);
    }
}
