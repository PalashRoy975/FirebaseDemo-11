package com.example.ad.rock_paper_scissors;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.*;

public class MainActivity extends AppCompatActivity {

    Button rock,paper,scissors;
    TextView me,cpu,tv_score;
    ImageView  iv_cpu,iv_me;
    String mychoise,cpuchoise,result,message;
    Random r_cpu;
    Toast tm ;
    int pc=0,my=0,Round=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        me = (TextView) findViewById(R.id.me);
        cpu = (TextView) findViewById(R.id.pc);
        rock = (Button) findViewById(R.id.b_rock);
        paper = (Button) findViewById(R.id.b_paper);
        scissors = (Button) findViewById(R.id.b_sci);
        iv_cpu = (ImageView) findViewById(R.id.p_cpu);
        iv_me = (ImageView) findViewById(R.id.p_me);
        tv_score=(TextView)findViewById(R.id.tv);
        r_cpu = new Random();
        rock.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mychoise = "rock";
                Round++;
                iv_me.setImageResource(R.drawable.rock);
                calculate();


            }
        });
        paper.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mychoise = "paper";
                Round++;
                iv_me.setImageResource(R.drawable.paper);
                calculate();


            }
        });

        scissors.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mychoise = "scissors";
                Round++;
                iv_me.setImageResource(R.drawable.scissors);
                calculate();

            }
        });
    }
    public void roundcnt(){

        if(Round>10){
            Toast.makeText(MainActivity.this,"game end",Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(MainActivity.this,Final.class);
            if(my>pc)
                intent.putExtra("result","PLAYER");
            else if(pc>my)
                intent.putExtra("result","COMPUTER");
            else
                intent.putExtra("result","MATCH DRAW");
            startActivity(intent);

        }
    }
    public void calculate()
    {
        int r=r_cpu.nextInt(3);
        if(r==0)
        {
            cpuchoise="rock";
            iv_cpu.setImageResource(R.drawable.rock);

        }
        else if(r==1)
        {
            cpuchoise="paper";
            iv_cpu.setImageResource(R.drawable.paper);
        }
        else if(r==2)
        {
            cpuchoise="scissors";
            iv_cpu.setImageResource(R.drawable.scissors);
        }
        if(mychoise.equals("rock") && cpuchoise.equals("paper"))
        {
            pc++;
            result="You Lose";
        }
        else if(mychoise.equals("rock") && cpuchoise.equals("scissors"))
        {
            my++;
            result="You Win";
        }
        else if(mychoise.equals("rock") && cpuchoise.equals("rock"))
        {
            result="Match Draw";
        }
        else if(mychoise.equals("paper") && cpuchoise.equals("paper"))
        {
            result="Match Draw";
        }
        else if(mychoise.equals("paper") && cpuchoise.equals("rock"))
        {
            my++;
            result="You Win";
        }
        else if(mychoise.equals("paper") && cpuchoise.equals("scissors"))
        {
            pc++;
            result="You Lose";
        }
        else if(mychoise.equals("scissors") && cpuchoise.equals("paper"))
        {
            my++;
            result="You Win";
        }
        else if(mychoise.equals("scissors") && cpuchoise.equals("rock"))
        {
            pc++;
            result="You Lose";
        }
        else if(mychoise.equals("scissors") && cpuchoise.equals("scissors"))
        {
            result="Match Draw";
        }

        if(tm!=null) tm.cancel();
        tm=Toast.makeText(MainActivity.this,result,Toast.LENGTH_SHORT);
        tm.show();
        tv_score.setText("       "+Integer.toString(my)+"                      "+Integer.toString(pc));
        roundcnt();

    }



}
