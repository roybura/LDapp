package com.example.anggarisky.wordmatters;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Push6 extends AppCompatActivity {

//    private int presCounter = 0;
//    private int maxPresCounter = 40;
    private String[] keys = {"บ", "ว", "ด", "ล"};
    private String textAnswer = "กราบ";
    public Long timer;
    TextView textScreen, textQuestion, textTitle;
    Animation smallbigforth;
    String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push6);

        Bundle bundle = getIntent().getExtras();
        timer = bundle.getLong("StartTime");
        userId = bundle.getString("userId");

        smallbigforth = AnimationUtils.loadAnimation(this, R.anim.smallbigforth);

        keys = shuffleArray(keys);

        for (String key : keys) {
            addView(((LinearLayout) findViewById(R.id.layoutParent)), key, ((EditText) findViewById(R.id.editText)));
        }

//        maxPresCounter = 3;
    }

    private String[] shuffleArray(String[] ar) {
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            String a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
        return ar;
    }


    private void addView(LinearLayout viewParent, final String text, final EditText editText) {
        LinearLayout.LayoutParams linearLayoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        linearLayoutParams.rightMargin = 30;

        final TextView textView = new TextView(this);

        textView.setLayoutParams(linearLayoutParams);
        textView.setBackground(this.getResources().getDrawable(R.drawable.bgpink));
        textView.setTextColor(this.getResources().getColor(R.color.colorPurple));
        textView.setGravity(Gravity.CENTER);
        textView.setText(text);
        textView.setClickable(true);
        textView.setFocusable(true);
        textView.setTextSize(40);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/FredokaOneRegular.ttf");

//        textQuestion = (TextView) findViewById(R.id.textQuestion);
        textScreen = (TextView) findViewById(R.id.textScreen);
        textTitle = (TextView) findViewById(R.id.textTitle);

//        textQuestion.setTypeface(typeface);
        textScreen.setTypeface(typeface);
        textTitle.setTypeface(typeface);
        editText.setTypeface(typeface);
        textView.setTypeface(typeface);

        textView.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {

                editText.setText(editText.getText().toString() + text);
                textView.animate().alpha(0).setDuration(300);
                doValidate();



//                if(presCounter < maxPresCounter) {
//                    if (presCounter == 0)
////                        editText.setText("");
//
//                        editText.setText(editText.getText().toString() + text);
////                        textView.startAnimation(smallbigforth);
//                    textView.animate().alpha(0).setDuration(300);
//                    presCounter++;
//
//                    doValidate();
//
//                }else{
//                    Toast.makeText(Push6.this, "Maximum press", Toast.LENGTH_SHORT).show();
//
//                }
            }
        });

        viewParent.addView(textView);

    }


    private void doValidate() {
//        presCounter = 0;

        EditText editText = findViewById(R.id.editText);
        LinearLayout linearLayout = findViewById(R.id.layoutParent);

        if(editText.getText().toString().equals(textAnswer)) {
            Toast.makeText(Push6.this, "Correct", Toast.LENGTH_SHORT).show();

            Intent a = new Intent(Push6.this,Push7.class);
            a.putExtra("userId",userId);
            a.putExtra("StartTime", timer);
            startActivity(a);



//            editText.setText("");
        } else {

            Toast.makeText(Push6.this, "Wrong", Toast.LENGTH_SHORT).show();
            editText.setText("กรา");
        }

//        keys = shuffleArray(keys);
        linearLayout.removeAllViews();
        for (String key : keys) {
            addView(linearLayout, key, editText);
        }

    }

}
