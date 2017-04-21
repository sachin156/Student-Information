package com.android.tourguide;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Student extends AppCompatActivity {

    EditText editTextname,editTextpassword;
    studentbaseAdapter studentAdapter;

    FragmentManager fragmentManager = getFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        studentAdapter=new studentbaseAdapter(this);
        studentAdapter=studentAdapter.open();
    }
    public void enter(View view)
    {
        // get the Refferences of views

          editTextname=(EditText)findViewById(R.id.editname);
        editTextpassword=(EditText)findViewById(R.id.password);
        Button button=(Button)findViewById(R.id.enter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get The User name and Password
                String username=editTextname.getText().toString();
                String password=editTextpassword.getText().toString();
                String storedPassword=studentAdapter.getpassword(username);
                // fetch the Password form database for respective user name
//                int _id=Integer.parseInt(id);
//                Cursor _cursor=studentAdapter.getSinlgeEntry(_id);
//                String username=_cursor.getString(1);
//                String _fees=_cursor.getString(2);
//                String result=username+_fees;
//                TextView textView=(TextView)findViewById(R.id.text);
//                textView.setText(result);
//                _cursor.close();

                if(password.equals(storedPassword))
                {
                    Toast.makeText(Student.this, "Congrats: Login Successfull", Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(Student.this,Student_display.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(Student.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();
                }
                String key="key";
;               Bundle bundle=new Bundle();
                bundle.putString(key,username);
                home_fragment fragment_home=new home_fragment();
                fragment_home.setArguments(bundle);

                fragmentManager.beginTransaction().add(R.id.container,fragment_home).commit();
            }
        });
}
    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();

        studentAdapter.close();
    }
}
