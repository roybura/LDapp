package com.example.anggarisky.wordmatters;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class NextPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_page);

    }

    public void btnClick(View v){

        Toast toast = Toast.makeText(getApplicationContext(), "NEXT", Toast.LENGTH_SHORT);
        toast.show();

        Intent intent = new Intent(this,Seek.class);
        startActivity(intent);


    }


}
