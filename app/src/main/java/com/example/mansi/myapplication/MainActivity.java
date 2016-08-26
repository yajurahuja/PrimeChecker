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
    private Button skip;
    private FloatingActionButton fab;
    private FloatingActionButton fab1;
    private int num;
    private String s;
    private int check = 1;
    private TextView question, number;
    private TextView warning, score;
    private int disp;
    private int quiz;
    private int qs=0;
    private int h1 = 0;
    private int a2 = 0;
    private String okay;
    private String n1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
            Intent intent = getIntent();
            quiz = intent.getIntExtra("score",0);
//        disp= getIntent().getStringExtra("cheat");
//        quiz= getIntent().getStringExtra("score");
//        qs = Integer.parseInt(quiz);
        number = (TextView)findViewById(R.id.number);
        question = (TextView)findViewById(R.id.question);
        warning = (TextView)findViewById(R.id.warning);
        score = (TextView)findViewById(R.id.score);

        Random rand = new Random();
        num = rand.nextInt((1000 - 2) + 1) + 2;

        s = Integer.toString(num);
        number.setText(s);
        String fscore = "Score: " + quiz;
        score.setText(fscore);
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
                        quiz += 1;
                        Toast.makeText(MainActivity.this,
                                "Yayy!! You got it right", Toast.LENGTH_LONG).show();
                    }
               else
                {
                    quiz -= 1;
                    Toast.makeText(MainActivity.this,
                            "Oops!! Try again", Toast.LENGTH_LONG).show();
                }
//                okay = Integer.toString(qs);
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                intent.putExtra("score",quiz);
                startActivity(intent);
                finish();

            }
        });


        no=(Button) findViewById(R.id.no);
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check==0){
                    quiz += 1;
                    Toast.makeText(MainActivity.this,
                            "Yayy!! You got it right", Toast.LENGTH_LONG).show();
                }
                 else
                {
                    quiz -= 1;
                    Toast.makeText(MainActivity.this,
                            "Oops!! Try again", Toast.LENGTH_LONG).show();
                }
//                okay = Integer.toString(qs);

                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                intent.putExtra("score",quiz);
                startActivity(intent);
                finish();

            }
        });

        skip = (Button) findViewById(R.id.skip);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    Toast.makeText(MainActivity.this,
                            "Question skipped!!", Toast.LENGTH_LONG).show();

//                okay = Integer.toString(qs);

                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                intent.putExtra("score",quiz);
                startActivity(intent);
                finish();

            }
        });

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                h1 = 1;
                if(a2==0)
                {
                    warning.setText("Hint Given");
                }
                Intent intent = new Intent(MainActivity.this, Hint.class);
                startActivity(intent);
            }
        });

        fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a2 = 1;
                warning.setText("Answer Given");
                Intent intent = new Intent(MainActivity.this, Cheat.class);
//                n1 = Integer.toString(num);
                intent.putExtra("number",num);
                startActivity(intent);
            }
        });
    }
}
