package com.android.tourguide;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void manage(View view)
    {
        Intent intent=new Intent(this,Manage.class);
        startActivity(intent);
    }
    public void sign(View view)
    {
     Intent intent=new Intent(this,student_sign.class);
        startActivity(intent);
    }
    public void login(View view)
    {
        Intent intent=new Intent(this,Student.class);
        startActivity(intent);
    }
}
