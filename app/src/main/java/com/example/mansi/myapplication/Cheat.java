package com.example.mansi.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by MANSI on 25-08-2016.
 */
public class Cheat extends AppCompatActivity{
    private TextView numb, ans;

    private String n;
    private int num;
    private int check =1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cheat);

        Intent intent = getIntent();
        num = intent.getIntExtra("number",0);
//        n = getIntent().getStringExtra("number");
        numb = (TextView)findViewById(R.id.numb);
        ans = (TextView)findViewById(R.id.ans);
//        num = Integer.parseInt(n);
        n = Integer.toString(num);
        numb.setText(n);
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

        if(check == 1)
        {
            ans.setText("Prime Number");
        }
        else
        {
            ans.setText("Composite Number");
        }


    }
}
