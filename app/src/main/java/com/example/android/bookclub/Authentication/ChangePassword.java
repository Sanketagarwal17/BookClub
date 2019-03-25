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
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ChangePassword extends AppCompatActivity {
    private FirebaseUser user;
    EditText oldpass,newpass,confirmnewpas;
    Button change;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        oldpass=findViewById(R.id.oldpass);
        newpass=findViewById(R.id.newpass);
        confirmnewpas=findViewById(R.id.confirmnewpass);
        change=findViewById(R.id.change);






        user = FirebaseAuth.getInstance().getCurrentUser();
        final String email = user.getEmail();

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String oldpass1=oldpass.getText().toString();
                final String newpass1=newpass.getText().toString();
                AuthCredential credential = EmailAuthProvider.getCredential(email,oldpass1);

                user.reauthenticate(credential).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            user.updatePassword(newpass1).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(!task.isSuccessful()){
                                        Toast.makeText(ChangePassword.this, "Something went wrong. Please try again later", Toast.LENGTH_LONG).show();
                                    }else {
                                        Toast.makeText(ChangePassword.this, "Password Successfully Modified", Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                        }else {
                            Toast.makeText(ChangePassword.this, "Authentication Failed", Toast.LENGTH_LONG).show();
                        }
                    }
                });






















            }
        });


    }
}









