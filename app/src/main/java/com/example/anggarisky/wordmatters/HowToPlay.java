package com.example.anggarisky.wordmatters;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HowToPlay extends AppCompatActivity {

    public int statusGame; // 1 for match, 2 for push,3 for seek
    TextView howTo;
    Button startPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_play);

        howTo = findViewById(R.id.howto);
        startPlay = findViewById(R.id.startToPlay);

        Bundle bundle = getIntent().getExtras();
        statusGame = bundle.getInt("statusGame");
        Log.d(" howtoplay",""+ statusGame);

        if(statusGame == 1){
            howTo.setText(R.string.how_to_play1);
        }else if(statusGame == 2){
            howTo.setText(R.string.how_to_play2);
        }else {
            howTo.setText(R.string.how_to_play3);
        }

        startPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(statusGame == 1){
                    Log.d(" to Game 1","1");
                    ChangeToGame1();
                }else if(statusGame == 2){
                    Log.d(" to Game 2","2");
                    ChangeToGame2();
                }else if(statusGame == 3){
                    Log.d(" to Game 2","3");
                    ChangeToGame3();
                }

            }
        });

    }



    public void ChangeToGame1(){
        Intent a = new Intent(HowToPlay.this,Match1.class);
        startActivity(a);
    }

    public void ChangeToGame2(){

        Intent a = new Intent(HowToPlay.this,Push1.class);
        startActivity(a);
    }

    public void ChangeToGame3(){

        Intent a = new Intent(HowToPlay.this,Seek.class);
        startActivity(a);
    }




}
