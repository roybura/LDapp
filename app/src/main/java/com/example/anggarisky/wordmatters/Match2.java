package com.example.anggarisky.wordmatters;

import android.content.Intent;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;

public class Match2 extends AppCompatActivity {

    ImageView iv11,iv12,iv13,iv14,iv21,iv22,iv23,iv24;

    Integer[] cardsarray = {101,102,103,104,201,202,203,204};
    private Chronometer chronometer;
    private boolean running;
    private long stop,correct_time;


    int img11,img12,img13,img14,img21,img22,img23,img24;
    int stcard,ndcard;
    int clickst,clicknd;
    int cardnum = 1;
    int turn =1;
    int count=4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match2);


        chronometer = findViewById(R.id.chronometer);
        Button btn = (Button) findViewById(R.id.butlevel);
        final Button btn_s = (Button) findViewById(R.id.start);


        iv11 = (ImageView) findViewById(R.id.iv11);
        iv12 = (ImageView) findViewById(R.id.iv12);
        iv13 = (ImageView) findViewById(R.id.iv13);
        iv14 = (ImageView) findViewById(R.id.iv14);
        iv21 = (ImageView) findViewById(R.id.iv21);
        iv22 = (ImageView) findViewById(R.id.iv22);
        iv23 = (ImageView) findViewById(R.id.iv23);
        iv24 = (ImageView) findViewById(R.id.iv24);

        iv11.setTag("0");
        iv12.setTag("1");
        iv13.setTag("2");
        iv14.setTag("3");
        iv21.setTag("4");
        iv22.setTag("5");
        iv23.setTag("6");
        iv24.setTag("7");

        btn_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time();
                btn_s.setVisibility(View.INVISIBLE);
            }

        });



        chronometer.setVisibility(View.INVISIBLE);
        frontofCardResources();

        Collections.shuffle(Arrays.asList(cardsarray));

        iv11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thecard = Integer.parseInt((String) v.getTag());
                doStuff(iv11,thecard);

            }
        });
        iv12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thecard = Integer.parseInt((String) v.getTag());
                doStuff(iv12,thecard);

            }
        });
        iv13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thecard = Integer.parseInt((String) v.getTag());
                doStuff(iv13,thecard);

            }
        });
        iv14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thecard = Integer.parseInt((String) v.getTag());
                doStuff(iv14,thecard);

            }
        });
        iv21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thecard = Integer.parseInt((String) v.getTag());
                doStuff(iv21,thecard);

            }
        });
        iv22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thecard = Integer.parseInt((String) v.getTag());
                doStuff(iv22,thecard);

            }
        });
        iv23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thecard = Integer.parseInt((String) v.getTag());
                doStuff(iv23,thecard);

            }
        });
        iv24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thecard = Integer.parseInt((String) v.getTag());
                doStuff(iv24,thecard);

            }
        });
    }

    private void time(){
        final TextView time = (TextView) findViewById(R.id.time);
        Thread t = new Thread() {
            @Override
            public void run() {
                while (!isInterrupted()) {

                    try {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if(count ==1) {
                                    chronometer.setVisibility(View.VISIBLE);
                                    if (!running) {
                                        chronometer.setBase(SystemClock.elapsedRealtime());
                                        chronometer.start();
                                        running = true;
                                    }
                                    time.setVisibility(View.INVISIBLE);
                                    count = 0;

                                }else
                                    count--;

                                time.setText(String.valueOf(count));
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return;
                    }
                }
            }
        };
        t.start();

    }

    private void doStuff(ImageView iv, int card){
        if(cardsarray[card] == 101){
            iv.setImageResource(img11);
        }else if(cardsarray[card] == 102){
            iv.setImageResource(img12);
        }else if(cardsarray[card] == 103) {
            iv.setImageResource(img13);
        }else if(cardsarray[card] == 104) {
            iv.setImageResource(img14);
        }else if(cardsarray[card] == 201) {
            iv.setImageResource(img21);
        }else if(cardsarray[card] == 202) {
            iv.setImageResource(img22);
        }else if(cardsarray[card] == 203) {
            iv.setImageResource(img23);
        }else if(cardsarray[card] == 204) {
            iv.setImageResource(img24);
        }

        if(cardnum ==1 ){
            stcard = cardsarray[card];
            if(stcard > 200){
                stcard = stcard - 100;
            }
            cardnum = 2;
            clickst = card;
            iv.setEnabled(false);
        }else if(cardnum == 2){
            ndcard = cardsarray[card];
            if(ndcard >200){
                ndcard = ndcard -100;
            }
            cardnum = 1;
            clicknd = card;

            iv11.setEnabled(false);
            iv12.setEnabled(false);
            iv13.setEnabled(false);
            iv14.setEnabled(false);
            iv21.setEnabled(false);
            iv22.setEnabled(false);
            iv23.setEnabled(false);
            iv24.setEnabled(false);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    calculate();
                }
            }, 1000);
        }

    }
    private void calculate(){

        if(stcard == ndcard){
            if(clickst ==0){
                iv11.setVisibility(View.INVISIBLE);
            }else if(clickst ==1){
                iv12.setVisibility(View.INVISIBLE);
            }else if(clickst ==2){
                iv13.setVisibility(View.INVISIBLE);
            }else if(clickst ==3){
                iv14.setVisibility(View.INVISIBLE);
            }else if(clickst ==4){
                iv21.setVisibility(View.INVISIBLE);
            }else if(clickst ==5){
                iv22.setVisibility(View.INVISIBLE);
            }else if(clickst ==6){
                iv23.setVisibility(View.INVISIBLE);
            }else if(clickst ==7) {
                iv24.setVisibility(View.INVISIBLE);
            }
            if(clicknd ==0){
                iv11.setVisibility(View.INVISIBLE);
            }else if(clicknd ==1){
                iv12.setVisibility(View.INVISIBLE);
            }else if(clicknd ==2){
                iv13.setVisibility(View.INVISIBLE);
            }else if(clicknd ==3){
                iv14.setVisibility(View.INVISIBLE);
            }else if(clicknd ==4){
                iv21.setVisibility(View.INVISIBLE);
            }else if(clicknd ==5) {
                iv22.setVisibility(View.INVISIBLE);
            }else if(clicknd ==6) {
                iv23.setVisibility(View.INVISIBLE);
            }else if(clicknd ==7) {
                iv24.setVisibility(View.INVISIBLE);
            }
        }else{
            iv11.setImageResource(R.drawable.bb);
            iv12.setImageResource(R.drawable.bb);
            iv13.setImageResource(R.drawable.bb);
            iv14.setImageResource(R.drawable.bb);
            iv21.setImageResource(R.drawable.bb);
            iv22.setImageResource(R.drawable.bb);
            iv23.setImageResource(R.drawable.bb);
            iv24.setImageResource(R.drawable.bb);
        }
        iv11.setEnabled(true);
        iv12.setEnabled(true);
        iv13.setEnabled(true);
        iv14.setEnabled(true);
        iv21.setEnabled(true);
        iv22.setEnabled(true);
        iv23.setEnabled(true);
        iv24.setEnabled(true);

        checkend();

    }

    private void checkend(){
        final long t1 = getIntent().getExtras().getLong("time1");
        if(iv11.getVisibility() == View.INVISIBLE &&
                iv12.getVisibility() == View.INVISIBLE &&
                iv13.getVisibility() == View.INVISIBLE &&
                iv14.getVisibility() == View.INVISIBLE &&
                iv21.getVisibility() == View.INVISIBLE &&
                iv22.getVisibility() == View.INVISIBLE &&
                iv23.getVisibility() == View.INVISIBLE &&
                iv24.getVisibility() == View.INVISIBLE){


            Button btn = (Button) findViewById(R.id.butlevel);

            btn.setText("ด่านต่อไป");
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Match2.this, Match3.class);
//                    Intent in = new Intent(match_two.this,Data.class);
                    i.putExtra("time2",correct_time+t1);
                    startActivity(i);
                }
            });
            endtime();
        }


    }

    private void endtime() {
        if (running) {
            chronometer.stop();
            stop = SystemClock.elapsedRealtime() - chronometer.getBase();
            correct_time = stop / 1000;
            Toast.makeText(Match2.this, " seconds: " + correct_time,
                    Toast.LENGTH_SHORT).show();
            running = false;
        }
    }
    private void frontofCardResources(){
        img11 = R.drawable.b;
        img12 = R.drawable.d;
        img13 = R.drawable.k;
        img14 = R.drawable.n;
        img21 = R.drawable.b2;
        img22 = R.drawable.d2;
        img23 = R.drawable.k2;
        img24 = R.drawable.n2;

    }

}
