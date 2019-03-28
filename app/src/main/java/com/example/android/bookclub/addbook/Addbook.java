package com.example.android.bookclub.addbook;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.android.bookclub.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class Addbook extends AppCompatActivity {

    EditText name,author,price,id,total;
    String namei,authori,pricei,idi,totali;
    Button addbook;
    ImageButton uploadimage;
    String doc_url="";
    Uri doc_data=null;
    int capture=1000;


    FirebaseUser firebaseUser;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
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
         uploadimage=findViewById(R.id.uploadimage1);




        firebaseUser= FirebaseAuth.getInstance().getCurrentUser();
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference("Book name");
        firebaseStorage = FirebaseStorage.getInstance();
        storageReference=firebaseStorage.getReference().child("bookimages/"+System.currentTimeMillis()+".jpg");

        addbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                namei=name.getText().toString().trim();
                authori=author.getText().toString().trim();
                pricei=price.getText().toString().trim();
                idi=id.getText().toString().trim();
                totali=total.getText().toString().trim();




                storageReference.putFile(doc_data).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot)
                    {
                        storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri)
                            {
                                Uri abc=uri;
                                doc_url=abc.toString();
                            }
                        });
                        }
                });





                Addbookmodel addbook=new Addbookmodel(namei,authori,pricei,idi,totali,doc_url);
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







        uploadimage.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent,capture);
            }
        });






    }






}
