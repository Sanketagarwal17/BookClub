package com.example.android.bookclub.ReturnBook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.android.bookclub.R;

import java.util.Calendar;

public class ReturnBook extends AppCompatActivity {
    DatePicker datePicker;

    EditText admission,bookid;
    Button returnbutton;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_return_book);
        admission=findViewById(R.id.returnbookadmission);
        bookid=findViewById(R.id.returnbookid);
        returnbutton=findViewById(R.id.returnbutton);


        datePicker=findViewById(R.id.datepicker);
        Calendar calendar=Calendar.getInstance();
        datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                String returndate="" + dayOfMonth + '-' + monthOfYear + '-' + year;
            }
        });


        /* further work will be done after meeting*/

        /*update in book details to increase its quantity by 1*/
        /*update in issue book to yes*/
        /*update in penalty if any */
        /*update in student profile issued books*/





    }
}
