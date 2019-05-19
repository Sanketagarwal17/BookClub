package com.example.android.bookclub.Authentication;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.bookclub.Main.MainActivity;
import com.example.android.bookclub.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {

    EditText username, password;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.login_email);
        password = findViewById(R.id.login_password);
        firebaseAuth = FirebaseAuth.getInstance();



        firebaseUser=firebaseAuth.getCurrentUser();
     /*   if(firebaseUser!=null)
       {
            finish();
            startActivity(new Intent(login.this,MainActivity.class));
        }
     */





    }

    public void login(View view) {
        String user = username.getText().toString().trim();
        String pass = password.getText().toString().trim();

        if(user==null || pass==null)
        {
            Toast.makeText(this,"These fields cannot be left empty ",Toast.LENGTH_LONG).show();
            // username.requestFocus();
            // password.requestFocus();
        }
        else {
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Loading");
            progressDialog.show();

            firebaseAuth.signInWithEmailAndPassword(user, pass)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progressDialog.dismiss();
                            if (task.isSuccessful()) {
                                finish();
                                Toast.makeText(login.this, "Logged In", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(login.this, MainActivity.class));
                            } else
                                Toast.makeText(login.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    }



    public void signup(View view) {
        finish();
        startActivity(new Intent(login.this, signup.class));
    }

    public void forgetPassword(View v)
    {
        startActivity(new Intent(login.this,ForgetPassword.class));
    }
}
