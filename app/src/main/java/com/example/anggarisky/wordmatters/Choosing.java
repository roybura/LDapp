package com.example.anggarisky.wordmatters;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class Choosing extends AppCompatActivity {

    Button play;
    Button learn;
    String userId;
    private int status ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosing);

        userId = FirebaseAuth.getInstance().getCurrentUser().getUid();

//        Bundle bundle = getIntent().getExtras(); // get id
//        userId = bundle.getString("userId"); // set id

        play = findViewById(R.id.playGo);
        learn = findViewById(R.id.learnGo);
        status = 1;

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Choosing.this,HowToPlay.class);
                a.putExtra("statusGame",status);
                startActivity(a);
            }
        });

        learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Choosing.this,Teach_1.class);
                startActivity(a);

            }
        });

    }




}
