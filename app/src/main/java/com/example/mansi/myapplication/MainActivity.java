package com.example.mansi.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button yes;
    private Button no;
    private FloatingActionButton fab;
    private int num;
    private String s;
    private int check = 1;
    private TextView question, number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        number = (TextView)findViewById(R.id.number);
        question = (TextView)findViewById(R.id.question);

        Random rand = new Random();
        num = rand.nextInt((1000 - 2) + 1) + 2;

        s = Integer.toString(num);
        number.setText(s);
        question.setText("Is this a Prime Number?");
        check = 1;
        int temp;
        for(int i=2;i<=num/2;i++)
        {
            temp=num%i;
            if(temp==0)
            {
                check = 0;
                break;
            }
        }
        yes=(Button) findViewById(R.id.yes);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if(check==1){
                        Toast.makeText(MainActivity.this,
                                "Yayy!! You got it right", Toast.LENGTH_LONG).show();
                    }
               else
                {
                    Toast.makeText(MainActivity.this,
                            "Oops!! Try again", Toast.LENGTH_LONG).show();
                }

            }
        });


        no=(Button) findViewById(R.id.no);
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check==0){
                    Toast.makeText(MainActivity.this,
                            "Yayy!! You got it right", Toast.LENGTH_LONG).show();
                }
                 else
                {
                    Toast.makeText(MainActivity.this,
                            "Oops!! Try again", Toast.LENGTH_LONG).show();
                }

            }
        });

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

}
