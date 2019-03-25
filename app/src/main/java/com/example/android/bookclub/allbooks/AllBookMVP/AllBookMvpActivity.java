package com.example.android.bookclub.allbooks.AllBookMVP;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.bookclub.DetailsofEachBook.Details;
import com.example.android.bookclub.R;
import com.example.android.bookclub.allbooks.allbooksmodel;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class AllBookMvpActivity extends AppCompatActivity implements AllBookview {
AllBookPresenter allBookPresenter;
    FirebaseDatabase database;
    DatabaseReference databaseReference;
    ChildEventListener childEventListener;
    FirebaseUser firebaseUser;
    ListView listView;
    ArrayList<AllBookModel> arrayList;
    ArrayAdapter<AllBookModel> arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_book_mvp);
        database=FirebaseDatabase.getInstance();
        databaseReference=database.getReference().child("Book name");
      listView=findViewById(R.id.allbookslistview);
        arrayList=new ArrayList<>();
         final ArrayAdapter<AllBookModel> arrayAdapter=new ArrayAdapter<AllBookModel>(this,R.layout.book_recyclerview,arrayList);

    }


    @Override
    public void showerror() {

    }

    @Override
    public void loading() {

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

                    AllBookModel allBookModel=new AllBookModel(name,author,price);
                    arrayList.add(allBookModel);
                }
                listView.setAdapter(arrayAdapter);
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

    @Override
    public void internetproblem() {

        Toast.makeText(this,"NO Internet",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onclickstartnewactivity() {

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i=new  Intent(AllBookMvpActivity.this,Details.class);
                i.putExtra("Book id mvp","1");
                startActivity(i);

            }
        });








    }

    @Override
    public void joinadaptertolistview() {
listView.setAdapter(arrayAdapter);
    }

    @Override
    public void search() {



        /*will made after meeting*/


    }
}
