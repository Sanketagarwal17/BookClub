package com.example.android.bookclub.Authentication;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.bookclub.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetPassword extends AppCompatActivity {
EditText email;
Button click;
FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        email=findViewById(R.id.forgetpasswordemail);
        click=findViewById(R.id.click);
        firebaseAuth=FirebaseAuth.getInstance();

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String emailaddress=email.getText().toString().trim();
                firebaseAuth.sendPasswordResetEmail(emailaddress).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(ForgetPassword.this, "Please check your mail", Toast.LENGTH_LONG).show();

                        }
                        else
                        {
                            Toast.makeText(ForgetPassword.this,"Error Please try again later",Toast.LENGTH_LONG).show();
                        }

                    }
                });






            }
        });

    }










}
