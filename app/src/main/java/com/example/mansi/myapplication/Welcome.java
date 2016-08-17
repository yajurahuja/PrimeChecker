package com.example.mansi.myapplication;

import android.content.Intent;
import android.os.Bundle;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by MANSI on 17-08-2016.
 */
public class Welcome extends AppCompatActivity implements View.OnClickListener{
    private Button mStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        mStart=(Button) findViewById(R.id.button1);
        mStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
     if(v.getId()==R.id.button1) {
         Intent intent = new Intent(Welcome.this, MainActivity.class);
         startActivity(intent);
     }
    }
}
