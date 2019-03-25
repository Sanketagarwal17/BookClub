package com.example.android.bookclub.IssueBook;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.bookclub.Authentication.signup;
import com.example.android.bookclub.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode;
import com.google.firebase.ml.vision.barcode.FirebaseVisionBarcodeDetectorOptions;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class IssueBook extends AppCompatActivity {
TextView currentdate;
Button issueabook;
String uniqueid,name,author,price,admissionno;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issue_book);
       currentdate=findViewById(R.id.Currentdate);
        issueabook=findViewById(R.id.issuebook);

        /*Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        final String formattedDate = df.format(c);

        c.add(Calendar.DATE,40);*/

        Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        // display the current date
        final String CurrentDate = mYear + "/" + mMonth + "/" + mDay;

        String dateInString = CurrentDate; // Start date
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        c = Calendar.getInstance();

        try {
            c.setTime(sdf.parse(dateInString));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        c.add(Calendar.DATE, 30);//insert the number of days you want to be added to the current date
        sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date resultdate = new Date(c.getTimeInMillis());
         final String Returndate = sdf.format(resultdate);

        //Display the Result in the Edit Text or Text View your Choice


        currentdate.setText(CurrentDate);
        final String uniqueid="1238",name="vdfcd",author="cdxcvfeasdf",price="6131",admissionno="1",returned="No";

        firebaseUser= FirebaseAuth.getInstance().getCurrentUser();
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference("Book Issued");



        issueabook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                        IssueBookAdapter issueBookAdapter=new IssueBookAdapter(uniqueid,name,author,price,CurrentDate,Returndate,returned);
                databaseReference.child(admissionno).setValue(issueBookAdapter).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful())
                            Toast.makeText(IssueBook.this,"Uploaded on FireBase",Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(IssueBook.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                    }
                });







            }


        });






    }
}
