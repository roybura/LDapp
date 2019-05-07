package com.example.anggarisky.wordmatters;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Seek extends AppCompatActivity {


    public int topicStatus ;
    public boolean topic01 = false ;
    public boolean topic02 = false ;
    public boolean topic11 = false ;
    public boolean topic12 = false ;
    public boolean topic21 = false ;
    public boolean topic22 = false ;
    public boolean topic31 = false ;
    public boolean topic32 = false ;
    public boolean topic41 = false ;
    public boolean topic42 = false ;
    public boolean topic51 = false ;
    public boolean topic52 = false ;
    public boolean topic61 = false ;
    public boolean topic62 = false ;
    public boolean topic71 = false ;
    public boolean topic72 = false ;

    public Long timer;
    public Long endTime;
    public Long timeUse;

    FirebaseDatabase database = FirebaseDatabase.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek);

        timer = System.currentTimeMillis();

        topicStatus = 0;


    }

    public void check01(View view){

        Button btn01 = findViewById(R.id.b01);

        if(topicStatus == 0){
            topic01 = true ;
            btn01.setVisibility(View.INVISIBLE);
            checkTopic();
        }
    }

    public void check02(View view){

        Button btn02 = findViewById(R.id.b02);

        if(topicStatus == 0){
            topic02 = true ;
            btn02.setVisibility(View.INVISIBLE);
            checkTopic();
        }
    }

    public void check11(View view){

        Button btn11 = findViewById(R.id.b11);

        if(topicStatus == 1){
            topic11 = true ;
            btn11.setVisibility(View.INVISIBLE);
            checkTopic();
        }
    }

    public void check12(View view){

        Button btn12 = findViewById(R.id.b12);

        if(topicStatus == 1){
            topic12 = true ;
            btn12.setVisibility(View.INVISIBLE);
            checkTopic();
        }
    }

    public void check21(View view){

        Button btn21 = findViewById(R.id.b21);

        if(topicStatus == 2){
            topic21 = true ;
            btn21.setVisibility(View.INVISIBLE);
            checkTopic();
        }
    }

    public void check22(View view){

        Button btn22 = findViewById(R.id.b22);

        if(topicStatus == 2){
            topic22 = true ;
            btn22.setVisibility(View.INVISIBLE);
            checkTopic();
        }
    }

    public void check31(View view){

        Button btn31 = findViewById(R.id.b31);

        if(topicStatus == 3){
            topic31 = true ;
            btn31.setVisibility(View.INVISIBLE);
            checkTopic();
        }
    }

    public void check32(View view){

        Button btn32 = findViewById(R.id.b32);

        if(topicStatus == 3){
            topic32 = true ;
            btn32.setVisibility(View.INVISIBLE);
            checkTopic();
        }
    }

    public void check41(View view){

        Button btn41 = findViewById(R.id.b41);

        if(topicStatus == 4){
            topic41 = true ;
            btn41.setVisibility(View.INVISIBLE);
            checkTopic();
        }
    }

    public void check42(View view){

        Button btn42 = findViewById(R.id.b42);

        if(topicStatus == 4){
            topic42 = true ;
            btn42.setVisibility(View.INVISIBLE);
            checkTopic();
        }
    }

    public void check51(View view){

        Button btn51 = findViewById(R.id.b51);

        if(topicStatus == 5){
            topic51 = true;
            btn51.setVisibility(View.INVISIBLE);
            checkTopic();
        }
    }

    public void check52(View view){

        Button btn52 = findViewById(R.id.b52);

        if(topicStatus == 5){
            topic52 = true ;
            btn52.setVisibility(View.INVISIBLE);
            checkTopic();
        }
    }

    public void check61(View view){

        Button btn61 = findViewById(R.id.b61);

        if(topicStatus == 6){
            topic61 = true ;
            btn61.setVisibility(View.INVISIBLE);
            checkTopic();
        }
    }

    public void check62(View view){

        Button btn62 = findViewById(R.id.b62);

        if(topicStatus == 6){
            topic62 = true ;
            btn62.setVisibility(View.INVISIBLE);
            checkTopic();
        }
    }

    public void check71(View view){

        Button btn71 = findViewById(R.id.b71);

        if(topicStatus == 7){
            topic71 = true ;
            btn71.setVisibility(View.INVISIBLE);
            checkTopic();
        }
    }

    public void check72(View view){

        Button btn72 = findViewById(R.id.b72);

        if(topicStatus == 7){
            topic72 = true ;
            btn72.setVisibility(View.INVISIBLE);
            checkTopic();
        }
    }



    public void checkTopic(){
        TextView topic = findViewById(R.id.topic);
        if(topicStatus == 0){
            if(topic01 & topic02){
                topicStatus = 1;
                topic.setText("แม่กด");
            }
        }if(topicStatus == 1){
            if(topic11 & topic12){
                topicStatus = 2;
                topic.setText("แม่กบ");
            }
        }if(topicStatus == 2){
            if(topic21 & topic22){
                topicStatus = 3;
                topic.setText("แม่กง");
            }
        }if(topicStatus == 3){
            if(topic31 & topic32){
                topicStatus = 4;
                topic.setText("แม่กน");
            }
        }if(topicStatus == 4){
            if(topic41 & topic42){
                topicStatus = 5;
                topic.setText("แม่กม");
            }
        }if(topicStatus == 5){
            if(topic51 & topic52){
                topicStatus = 6;
                topic.setText("แม่เกย");
            }
        }if(topicStatus == 6){
            if(topic61 & topic62){
                topicStatus = 7;
                topic.setText("แม่เกอว");
            }
        }if(topicStatus == 7){
            if(topic71 & topic72){
                topicStatus = 8;
                Intent intent = new Intent(this,Finish.class);

                endTime = System.currentTimeMillis();
                timeUse = (endTime - timer)/1000; //sec

                String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();

                DatabaseReference myRef = database.getReference(userId).child("score3");
                myRef.push().setValue(timeUse);

                startActivity(intent);
            }
        }
    }






}
