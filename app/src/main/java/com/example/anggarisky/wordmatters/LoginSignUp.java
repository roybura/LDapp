package com.example.anggarisky.wordmatters;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class LoginSignUp extends AppCompatActivity {


    FirebaseAuth mAuth;
    FirebaseDatabase database = FirebaseDatabase.getInstance();

    EditText user,pass;
    TextView signup;
    Button login;
    String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_sign_up);

        mAuth = FirebaseAuth.getInstance();

        login = (Button) findViewById(R.id.loginn);
        signup = (TextView) findViewById(R.id.signup);
        user = (EditText) findViewById(R.id.Username);
        pass = (EditText) findViewById(R.id.password);
//        mDatabase = FirebaseDatabase.getInstance().getReference();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginSignUp.this,signUp.class);
                startActivity(i);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Userlogin();
            }
        });
    }

    private void Userlogin(){

        String emailA = user.getText().toString().trim();
        String email = emailA+"@gmail.com";
        String passw = pass.getText().toString().trim();
        String teacher = "teacherlogin";

        if(email.isEmpty()){
            user.setError("กรุณาใส่อีเมลล์");
            user.requestFocus();
            return;
        }

        if(emailA.equals(teacher) && passw.isEmpty()){ //check teacher login
            Intent a = new Intent(LoginSignUp.this,TeacherMode.class);
            startActivity(a);
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
        Log.d("before signin"," 1 " );
        mAuth.signInWithEmailAndPassword(email,passw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                userId = FirebaseAuth.getInstance().getCurrentUser().getUid();

                Log.d("before signin"," 2 " + task);

                if(task.isSuccessful()){

                    Log.d("before signin"," 3 " );
                    Intent i = new Intent(LoginSignUp.this,Choosing.class);
//                    i.putExtra("userId",userId);
                    Log.d("show id user"," " + userId);

                    startActivity(i);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                }else{
                    Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });

    }



}
