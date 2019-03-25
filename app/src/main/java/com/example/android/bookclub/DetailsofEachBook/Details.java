package com.example.android.bookclub.DetailsofEachBook;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.android.bookclub.R;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Details extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference databaseReference;
    ChildEventListener childEventListener;
    FirebaseUser firebaseUser;
    DetailsModel detailsModel;
    TextView name,author,price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        database=FirebaseDatabase.getInstance();
        databaseReference=database.getReference().child("Book name");



        final String key=getIntent().getExtras().getString("Bookid");



        name=findViewById(R.id.dname);
        author=findViewById(R.id.dauthor);
        price=findViewById(R.id.dprice);



        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for(DataSnapshot ds: dataSnapshot.getChildren()) {

                        if(ds.getKey().equals(key)) {


                            String bookname = ds.child("name").getValue().toString();
                            String authorname = ds.child("author").getValue().toString();
                            String bookprice = ds.child("price").getValue().toString();

                            detailsModel = new DetailsModel(bookname, authorname, bookprice);

                            name.setText(bookname);
                            author.setText(authorname);
                            price.setText(bookprice);
                        }

                    }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




    }















}
