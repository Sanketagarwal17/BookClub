package com.example.android.bookclub.addbook;

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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Addbook extends AppCompatActivity {

    EditText name,author,price,id,total;
    String namei,authori,pricei,idi,totali;
    Button addbook;


    FirebaseUser firebaseUser;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addbook);

        name=findViewById(R.id.namerequest);
        author=findViewById(R.id.author);
        price=findViewById(R.id.price);
        addbook=findViewById(R.id.addbook);
         id=findViewById(R.id.bookid);
         total=findViewById(R.id.total);




        firebaseUser= FirebaseAuth.getInstance().getCurrentUser();
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference("Book name");

        addbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                namei=name.getText().toString().trim();
                authori=author.getText().toString().trim();
                pricei=price.getText().toString().trim();
                idi=id.getText().toString().trim();
                totali=total.getText().toString().trim();


                Addbookmodel addbook=new Addbookmodel(namei,authori,pricei,idi,totali);
                databaseReference.child(idi).setValue(addbook).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful())
                            Toast.makeText(Addbook.this,"Uploaded on FireBase",Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(Addbook.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });





    }






}
