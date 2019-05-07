package com.example.anggarisky.wordmatters;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TeacherMode extends AppCompatActivity {

    Button back;
    Button howto;
    TextView result;
    TextView how1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_mode);

        back = findViewById(R.id.back);
        result = findViewById(R.id.result);
        howto = findViewById(R.id.howto);
        how1 = findViewById(R.id.how);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(TeacherMode.this,LoginSignUp.class);
                startActivity(a);
            }
        });

        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(TeacherMode.this,DetailReport.class);
                startActivity(a);
            }
        });

        howto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(how1.getVisibility() == View.VISIBLE){
                    how1.setVisibility(View.INVISIBLE);
                }{
                    how1.setVisibility(View.VISIBLE);
                }
            }
        });




    }






}
