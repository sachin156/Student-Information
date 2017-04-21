package com.android.tourguide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Student_schedule extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_schedule);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new schedule_fragment())
                .commit();
    }
}
