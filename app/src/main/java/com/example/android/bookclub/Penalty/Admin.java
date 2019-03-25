package com.example.android.bookclub.Penalty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.android.bookclub.R;

public class Admin extends AppCompatActivity {

    RecyclerView recyclerView;
    /*              SAME AS ALL BOOKS ACTIVITTY
                   */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
    }
}
