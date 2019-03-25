package com.example.android.bookclub.Profile;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.android.bookclub.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Editprofile extends AppCompatActivity {

    FirebaseUser user;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    EditText editname,editadmissionno,editphoneno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofile);
 firebaseAuth=FirebaseAuth.getInstance();
        user = firebaseAuth.getCurrentUser();
        final String email = user.getEmail();
    editname=findViewById(R.id.editname);
    editadmissionno=findViewById(R.id.editadmissionno);
    editphoneno=findViewById(R.id.editphoneno);



        final String newname=editname.getText().toString().trim();
        final String newadmissionno=editadmissionno.getText().toString();
        final String newphoneno=editphoneno.getText().toString();


        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference("Book name");


findViewById(R.id.done).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        databaseReference.child("profiledetails").child(email).addListenerForSingleValueEvent
                (new ValueEventListener()
                { @Override public void onDataChange(DataSnapshot dataSnapshot) {
                    try { databaseReference.child(email).child("username").setValue(newname);
                        databaseReference.child(email).child("admissionno").setValue(newadmissionno);
                        databaseReference.child(email).child("phoneno").setValue(newphoneno);
                    }
                    catch (Exception e)
                    { e.printStackTrace(); }
                }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }


                });





    }
});






}
}