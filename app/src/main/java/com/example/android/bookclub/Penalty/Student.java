package com.example.android.bookclub.Penalty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.bookclub.R;

import java.util.Calendar;

public class Student extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);




        Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        // display the current date
        final String CurrentDate = mYear + "/" + mMonth + "/" + mDay;

        String datefromfirebase;






    }
}
