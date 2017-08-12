package com.example.shreya.res_billing;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Shreya on 09-06-2017.
 */

public class MainBActivity extends Activity {
    Button btn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        btn=(Button)findViewById(R.id.Btn);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View k) {
                Toast.makeText(getApplicationContext(),"ORDER PLACED",Toast.LENGTH_LONG).show();

            }
        });
    }
}
