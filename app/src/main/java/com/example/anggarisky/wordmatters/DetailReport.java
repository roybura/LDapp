package com.example.anggarisky.wordmatters;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DetailReport extends AppCompatActivity {

    Button backTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_report);

        backTo = findViewById(R.id.backToName);

        backTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DetailReport.this,TeacherMode.class);
                startActivity(i);
            }
        });


    }
}
