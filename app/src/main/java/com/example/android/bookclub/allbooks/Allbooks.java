package com.example.android.bookclub.allbooks;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.android.bookclub.DetailsofEachBook.Details;
import com.example.android.bookclub.Main.MainActivity;
import com.example.android.bookclub.R;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Allbooks extends AppCompatActivity {

    ArrayList<allbooksmodel> arrayList;
    FirebaseDatabase database;
    DatabaseReference databaseReference;
    ChildEventListener childEventListener;
    FirebaseUser firebaseUser;
    allbooksmodel allbooksmodel;
    allbooksadapter allbooksadaptera;
    RecyclerView allbookrecycler;
    EditText search;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allbooks);
        allbookrecycler=(RecyclerView)findViewById(R.id.allbookrecycler);
        database=FirebaseDatabase.getInstance();
        databaseReference=database.getReference().child("Book name");

        SharedPreferences sharedPreferences = getSharedPreferences("sharedadmission",Context.MODE_PRIVATE);
        String sharedAdmisNo = sharedPreferences.getString("admision","1");
        Toast.makeText(this, sharedAdmisNo, Toast.LENGTH_SHORT).show();

        arrayList=new ArrayList<>();
        final RecyclerView recyclerView=findViewById(R.id.allbookrecycler);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL,false));

        allbooksadaptera=new allbooksadapter(this,arrayList);

        search=findViewById(R.id.search);


        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                    filter(s.toString());
            }

            private void filter(String so) {
                ArrayList<allbooksmodel> filterdNames = new ArrayList<>();

                //looping through existing elements
                for (allbooksmodel se : arrayList) {
                    //if the existing elements contains the search input
                    if (se.getName().toLowerCase().contains(so.toLowerCase())) {
                        //adding the element to filtered list
                        filterdNames.add(se);
                    }
                }

                //calling a method of the adapter class and passing the filtered list
                allbooksadaptera.filterList(filterdNames);




            }
        });











        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                arrayList.clear();
                for(DataSnapshot ds:dataSnapshot.getChildren())
                {
                    String name=ds.child("name").getValue().toString();
                    String author=ds.child("author").getValue().toString();
                    String price=ds.child("price").getValue().toString();

                    allbooksmodel=new allbooksmodel(name,author,price);
                    arrayList.add(allbooksmodel);
                }
                recyclerView.setAdapter(allbooksadaptera);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

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
