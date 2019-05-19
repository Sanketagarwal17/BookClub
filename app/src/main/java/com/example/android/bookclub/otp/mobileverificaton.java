package com.example.android.bookclub.otp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.bookclub.Main.MainActivity;
import com.example.android.bookclub.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;



/* SHA KEY UNABLE TO FOUND
*/

public class mobileverificaton extends AppCompatActivity {
EditText mobileno,otp;
Button submit;
    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallback;
    FirebaseAuth mauth;
    private String verificationCode;









    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobileverificaton);

        mobileno=findViewById(R.id.numberverify);
        otp=findViewById(R.id.otpverify);

        submit=findViewById(R.id.submitverify);
        StartFirebaseLogin();

        findViewById(R.id.generateotp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String number=mobileno.getText().toString().trim();

                PhoneAuthProvider.getInstance().verifyPhoneNumber(
                        "+91"+number,                     // Phone number to verify
                        60,                           // Timeout duration
                        TimeUnit.SECONDS,                // Unit of timeout
                        mobileverificaton.this,        // Activity (for callback binding)
                        mCallback);
            }
        });



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String otpn=otp.getText().toString().trim();

                PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationCode, otpn);
                SigninWithPhone(credential);


            }

            private void SigninWithPhone(PhoneAuthCredential credential) {
                mauth.signInWithCredential(credential)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    startActivity(new Intent(mobileverificaton.this,MainActivity.class));
                                    finish();
                                } else {
                                    Toast.makeText(mobileverificaton.this,"Incorrect OTP",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });



            }
        });



    }


    private void StartFirebaseLogin() {

        mauth = FirebaseAuth.getInstance();
        mCallback = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            @Override
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                Toast.makeText(mobileverificaton.this,"verification completed",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
                Toast.makeText(mobileverificaton.this,e.getMessage(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);
                verificationCode = s;
                Toast.makeText(mobileverificaton.this,"Code sent",Toast.LENGTH_SHORT).show();
            }
        };
    }


}
