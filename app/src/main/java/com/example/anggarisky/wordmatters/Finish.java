package com.example.anggarisky.wordmatters;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Finish extends AppCompatActivity {

    private Button backToChoose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        backToChoose = findViewById(R.id.backToChoose);

        backToChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Finish","to choose");
                Intent a = new Intent(Finish.this,Choosing.class);
                startActivity(a);
            }

        });

    }


}
