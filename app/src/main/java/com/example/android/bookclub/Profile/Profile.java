package com.example.android.bookclub.Profile;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.bookclub.R;
import com.example.android.bookclub.allbooks.allbooksadapter;
import com.example.android.bookclub.allbooks.allbooksmodel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Profile extends AppCompatActivity {



  TextView pname,padmm,pphone,pemail;
    FirebaseDatabase database;
    DatabaseReference databaseReference;
    ChildEventListener childEventListener;
    FirebaseUser firebaseUser;
    ProfileModel profileModel;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
   pname=findViewById(R.id.profilename);
   padmm=findViewById(R.id.profileadmiss);
   pphone=findViewById(R.id.profilephone);
   pemail=findViewById(R.id.profileemail);

        database=FirebaseDatabase.getInstance();
        databaseReference=database.getReference().child("profiledetails");

         DatabaseReference pushref=databaseReference.push();
         final String pushkey=((DatabaseReference) pushref).getKey();
        firebaseUser= FirebaseAuth.getInstance().getCurrentUser();
         final String uid=firebaseUser.getUid();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                for(DataSnapshot ds:dataSnapshot.getChildren()) {
                        if(ds.getKey().equals('1')) {


                            String name1 = ds.child("username").getValue().toString();
                            String email1 = ds.child("email").getValue().toString();
                            String admission1 = ds.child("admissionno").getValue().toString();
                            String phone1 = ds.child("phoneno").getValue().toString();


                            profileModel = new ProfileModel(name1, admission1, phone1, email1);


                            pname.setText(name1);
                            padmm.setText(admission1);
                            pphone.setText(phone1);
                            pemail.setText(email1);

                        }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Profile.this,databaseError.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
        childEventListener=new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s)
            {

            }
            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {            }
            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {            }
            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {          }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {            }
        };
        databaseReference.addChildEventListener(childEventListener);








    }
}
