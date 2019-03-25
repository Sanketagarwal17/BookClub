package com.example.android.bookclub.Main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android.bookclub.Authentication.ChangePassword;
import com.example.android.bookclub.Authentication.login;
import com.example.android.bookclub.BarcodeScanner.BarcodeScannerActivity;
import com.example.android.bookclub.IssueBook.IssueBook;
import com.example.android.bookclub.Profile.Editprofile;
import com.example.android.bookclub.Profile.Profile;
import com.example.android.bookclub.R;
import com.example.android.bookclub.acceptedrequest.acceptedrequest;
import com.example.android.bookclub.addbook.Addbook;
import com.example.android.bookclub.allbooks.AllBookMVP.AllBookMvpActivity;
import com.example.android.bookclub.allbooks.Allbooks;
import com.example.android.bookclub.otp.mobileverificaton;
import com.example.android.bookclub.requestbook.requestbook;

public class MainActivity extends AppCompatActivity {

// ...

    Button issue,borrow,request,profile,allbooks,logout,addbook,allrequest,profile1,barcode,otp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        request=findViewById(R.id.requestbook);
        borrow = findViewById(R.id.borrowabook);
        addbook = findViewById(R.id.addbook);
        profile = findViewById(R.id.profile);
        allbooks=findViewById(R.id.allbooks);
        logout=findViewById(R.id.logout);
        allrequest=findViewById(R.id.allrequests);
        profile1=findViewById(R.id.profileshow);
        barcode=findViewById(R.id.barcodescanner);
       otp=findViewById(R.id.otpmobile);



        otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,mobileverificaton.class));
            }
        });


       findViewById(R.id.editprofile).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(MainActivity.this,Editprofile.class));
           }
       });


        findViewById(R.id.mvpcheck).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,AllBookMvpActivity.class));
            }
        });

        findViewById(R.id.changep).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ChangePassword.class));
            }
        });


        findViewById(R.id.Issuedbooks).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,IssueBook.class));
            }
        });


        barcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,BarcodeScannerActivity.class));
            }
        });



        profile1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Profile.class));
            }
        });


        allrequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(MainActivity.this,acceptedrequest.class));
            }
        });


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,login.class));
            }
        });

         request.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 startActivity(new Intent(MainActivity.this,requestbook.class));
             }
         });

        addbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Addbook.class));
            }
        });

  allbooks.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
         startActivity(new Intent(MainActivity.this,Allbooks.class));
      }
  });


    }













}
