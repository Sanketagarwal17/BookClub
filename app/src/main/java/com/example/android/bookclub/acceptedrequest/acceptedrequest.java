package com.example.android.bookclub.acceptedrequest;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.android.bookclub.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class acceptedrequest extends AppCompatActivity {

    ArrayList<com.example.android.bookclub.acceptedrequest.Acceptedrequestmodel> arrayList;
    FirebaseDatabase database;
    DatabaseReference databaseReference;
    ChildEventListener childEventListener;
    FirebaseUser firebaseUser;
    FirebaseAuth firebaseAuth;
    Acceptedrequestmodel acceptedrequestmodel;
    Acceptedrequestadapter acceptedrequestadapter;
    RecyclerView acceptedrequestrecycler;

    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceptedrequest);
  firebaseAuth=FirebaseAuth.getInstance();
        firebaseUser= firebaseAuth.getCurrentUser();

        database=FirebaseDatabase.getInstance();





        databaseReference=database.getReference().child("Book Request");

        arrayList=new ArrayList<>();
        final RecyclerView recyclerView=findViewById(R.id.acceptedrequestrecycler);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL,false));

        acceptedrequestadapter=new Acceptedrequestadapter(this,arrayList);



        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                arrayList.clear();
                for(DataSnapshot ds:dataSnapshot.getChildren())
                {

                    String admissionno=ds.child("admissionno").getValue().toString();
                    String bookname=ds.child("bookname").getValue().toString();
                    String author=ds.child("author").getValue().toString();
                    String price=ds.child("price").getValue().toString();


                    acceptedrequestmodel=new Acceptedrequestmodel(admissionno,bookname,author,price);
                    arrayList.add(acceptedrequestmodel);
                }
                recyclerView.setAdapter(acceptedrequestadapter);
            }






            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(acceptedrequest.this,databaseError.getMessage(),Toast.LENGTH_LONG).show();
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
