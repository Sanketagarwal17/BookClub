package com.example.android.bookclub.Authentication;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signup extends AppCompatActivity {

    EditText username,admissionno,pone,email,pass;
    Button submit;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase=FirebaseDatabase.getInstance();


        username = findViewById(R.id.username);
        admissionno = findViewById(R.id.useradmission);
        pone = findViewById(R.id.userphone);
        email = findViewById(R.id.useremail);
        submit = findViewById(R.id.makaccount);
        pass = findViewById(R.id.userpass);
        String namei = username.getText().toString().trim();
        String admis = admissionno.getText().toString().trim();
        String ph = pone.getText().toString().trim();
        String ema = email.getText().toString().trim();
        String passwo = pass.getText().toString().trim();



  /* new node for staus*/
        ChildEventListener childEventListener;
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        final String email123 = user.getEmail();


        DatabaseReference databaseReference=firebaseDatabase.getReference().child("Status");

        databaseReference.child(email123).child("statusvalue").setValue(0).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

            }
        });

/*       complete here       */
         firebaseUser= FirebaseAuth.getInstance().getCurrentUser();
         databaseReference=firebaseDatabase.getReference("profiledetails");

        final DatabaseReference finalDatabaseReference = databaseReference;
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namei = username.getText().toString().trim();
                String admis = admissionno.getText().toString().trim();
                String ph = pone.getText().toString().trim();
                String ema = email.getText().toString().trim();
                String passwo = pass.getText().toString().trim();
                Signupmodel sign=new Signupmodel(namei,admis,ph,ema,passwo);
                finalDatabaseReference.child(admis).setValue(sign).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful())
                            Toast.makeText(signup.this,"Uploaded on FireBase",Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(signup.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                    }
                });


                final ProgressDialog progressDialog = new ProgressDialog(signup.this);
                progressDialog.setMessage("Loading");
                progressDialog.show();


                firebaseAuth.createUserWithEmailAndPassword(ema, passwo).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()) {
                            finish();
                            Toast.makeText(signup.this, "Successfully registered", Toast.LENGTH_SHORT).show();
                            email.setText("");
                            pass.setText("");
                            startActivity(new Intent(signup.this, login.class));
                        } else
                            Toast.makeText(signup.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });









    }








}
