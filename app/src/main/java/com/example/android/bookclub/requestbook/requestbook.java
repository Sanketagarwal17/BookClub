package com.example.android.bookclub.requestbook;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.bookclub.R;
import com.example.android.bookclub.addbook.Addbookmodel;
import com.example.android.bookclub.allbooks.allbooksmodel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class requestbook extends AppCompatActivity {



        EditText bookname,author,price,requestadmission;
        String namei,authori,pricei,username,admisssiono,phoneno,email,admisssionu;
        Button requestbook;


        FirebaseUser firebaseUser;
        FirebaseDatabase firebaseDatabase;
        DatabaseReference databaseReference,databaseReference2;
        requetbookdatamodel requetbookdatamodel1;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_requestbook);

            bookname=findViewById(R.id.namerequest);
            author=findViewById(R.id.authorrequest);
            price=findViewById(R.id.pricerequest);
            requestbook=findViewById(R.id.request);
         requestadmission=findViewById(R.id.requestbookadmission);

            ChildEventListener childEventListener;

 final String admisssionu=requestadmission.getText().toString();
            firebaseUser= FirebaseAuth.getInstance().getCurrentUser();
            firebaseDatabase=FirebaseDatabase.getInstance();




            databaseReference2=firebaseDatabase.getReference("Book Request");



            requestbook.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    databaseReference=firebaseDatabase.getReference("profiledetails");
                    databaseReference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot
                        )
                        {  for (DataSnapshot ds : dataSnapshot.getChildren()) {

                            if(ds.getKey().equals(1)) {


                                final String username = ds.child("username").getValue().toString();
                                final String admissionno = ds.child("admissionno").getValue().toString();
                                final String phoneno = ds.child("phoneno").getValue().toString();
                                final String email = ds.child("email").getValue().toString();


                                Toast.makeText(requestbook.this,username,Toast.LENGTH_LONG).show();
                            }
                        }
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Toast.makeText(requestbook.this,"error",Toast.LENGTH_LONG).show();
                        }
                    });








                    namei=bookname.getText().toString().trim();
                    authori=author.getText().toString().trim();
                    pricei=price.getText().toString().trim();
                    admisssiono=requestadmission.getText().toString().trim();
                   String usernamei=username;
                   String phonenoi=phoneno;
                   String emaili=email;


                    requestbookmodel requestbookmodel1=new requestbookmodel(namei,authori,pricei,username,admisssiono,phoneno,email);
                    databaseReference2.child(namei).setValue(requestbookmodel1).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful())
                                Toast.makeText(requestbook.this,"Uploaded on FireBase",Toast.LENGTH_SHORT).show();
                            else
                                Toast.makeText(requestbook.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                        }
                    });
                }
            });





        }
}
