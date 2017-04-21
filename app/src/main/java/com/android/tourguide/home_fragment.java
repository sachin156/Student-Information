package com.android.tourguide;


import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.BaseBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;
import android.widget.TextView;


public class home_fragment extends Fragment
{
    studentbaseAdapter studentAdapter;
    String username;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_student_home,
                container, false);
        studentAdapter = new studentbaseAdapter(getActivity());
        studentAdapter = studentAdapter.open();
        if (username != null) {
            Cursor _cursor = studentAdapter.getSinlgeEntry(username);
            String id = _cursor.getString(0);
            String fees = _cursor.getString(2);
            String School = _cursor.getString(3);
            String Session = _cursor.getString(4);
            String phone = _cursor.getString(5);
            String result = id + fees + School + Session + phone;
            TextView textView = (TextView) view.findViewById(R.id.home);
            textView.setText(result);
        }
        return view;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        username = getArguments().getString("key");
    }
}
