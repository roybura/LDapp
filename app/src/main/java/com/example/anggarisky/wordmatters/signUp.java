package com.example.anggarisky.wordmatters;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class signUp extends AppCompatActivity {

    EditText user,pass;
    Button reg;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();

        user = (EditText) findViewById(R.id.Username);
        pass = (EditText) findViewById(R.id.password);

        Button reg = (Button) findViewById(R.id.reg);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regisUser();
            }
        });
    }

    private  void regisUser(){
        String emailA = user.getText().toString().trim();
        String email = emailA+"@gmail.com";
        String passw = pass.getText().toString().trim();

        if(email.isEmpty()){
            user.setError("กรุณาใส่อีเมลล์");
            user.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            user.setError("กรุณาใส่อีเมลล์ที่ถูกต้อง");
            user.requestFocus();
            return;
        }

        if(passw.isEmpty()){
            pass.setError("กรุณาใส่รหัสผ่าน");
            pass.requestFocus();
            return;
        }

        if(passw.length()<6){
            pass.setError("รหัสต้องมากกว่า 6 ");
            pass.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email,passw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){

                    Intent i = new Intent(signUp.this,LoginSignUp.class);
                    startActivity(i);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                    Toast.makeText(getApplicationContext(),"บันทึก",Toast.LENGTH_SHORT).show();
                }else{
                    if(task.getException() instanceof FirebaseAuthUserCollisionException){
                        Toast.makeText(getApplicationContext(),"คุณทำการสมัครไปแล้ว",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }



}
