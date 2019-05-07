package com.example.anggarisky.wordmatters;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Teach_1 extends AppCompatActivity {

    TextView title,bb,ex,tx1,tx2,tx3;
    Button iv11,iv12,iv13,iv14,iv15,iv16,iv17,iv18,iv21,iv22,iv23,iv24,iv25,iv26,iv27,iv28;
    ImageView view1,view2,view3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teach_1);

        final ImageView view1 = (ImageView) findViewById(R.id.imageView1);
        final ImageView view2 = (ImageView) findViewById(R.id.imageView2);
        final ImageView view3 = (ImageView) findViewById(R.id.imageView3);

        final TextView title = (TextView) findViewById(R.id.Title);
        final TextView bb = (TextView) findViewById(R.id.bb);
        TextView ex = (TextView) findViewById(R.id.ex);
        TextView tx1 = (TextView) findViewById(R.id.text1);
        TextView tx2 = (TextView) findViewById(R.id.text2);
        TextView tx3 = (TextView) findViewById(R.id.text3);
        Button iv11 = (Button) findViewById(R.id.iv11);
        Button iv12 = (Button) findViewById(R.id.iv12);
        Button iv13 = ( Button) findViewById(R.id.iv13);
        Button iv14 = ( Button) findViewById(R.id.iv14);
        Button iv15 = ( Button) findViewById(R.id.iv15);
        Button iv16 = ( Button) findViewById(R.id.iv16);
        Button iv17 = ( Button) findViewById(R.id.iv17);
        Button iv18 = ( Button) findViewById(R.id.iv18);
        Button iv21 = ( Button) findViewById(R.id.iv21);
        Button iv22 = ( Button) findViewById(R.id.iv22);
        Button iv23 = ( Button) findViewById(R.id.iv23);
        Button iv24 = ( Button) findViewById(R.id.iv24);
        Button iv25 = ( Button) findViewById(R.id.iv25);
        Button iv26 = ( Button) findViewById(R.id.iv26);
        Button iv27 = ( Button) findViewById(R.id.iv27);
        Button iv28 = ( Button) findViewById(R.id.iv28);


        iv11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bb.setText("ด.เด็ก");
                view1.setImageResource(R.drawable.b1);


            }
        });

        iv12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bb.setText("จ.จาน");
                view1.setImageResource(R.drawable.b2);

            }
        });
        iv13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bb.setText("ช.ช้าง");
                view1.setImageResource(R.drawable.b3);

            }
        });

        iv14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bb.setText("ซ.โซ่");
                view1.setImageResource(R.drawable.b33);

            }
        });

        iv15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bb.setText("ฎ.ชฎา");
                view1.setImageResource(R.drawable.bb);

            }
        });



    }
}
