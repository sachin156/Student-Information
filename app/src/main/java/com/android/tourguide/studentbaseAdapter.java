package com.android.tourguide;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import static android.R.attr.dashGap;
import static android.R.attr.id;
import static android.R.attr.name;
import static android.R.string.no;

/**
 * Created by sachin vadlakonda on 4/16/2017.
 */

public class studentbaseAdapter {

    public static final String DATABASE_NAME = "login.db";
    public static final int DATABASE_VERSION = 1;
    public static  final String TABLE_NAME="LOGIN";
    public static  final String TABLE_DETAILS="SIGN";
    public static final int NAME_COLUMN = 1;
    // TODO: Create public field for each column in your table.
    // SQL Statement to create a new database.
    public static final String DATABASE_CREATE = "create table "+TABLE_NAME+
            "( " +"ID"+" INTEGER PRIMARY KEY AUTOINCREMENT,"+ "USERNAME  text,FEES text,SCHOOL text,YEAR text,PHONE text);";

    public static final String DATABASE_SIGN = "create table "+TABLE_DETAILS+
            "( " +"ID"+" integer primary key autoincrement,"+ "USERNAME  text,PASSWORD text); ";
    // Variable to hold the database instance
    public SQLiteDatabase db;
    // Context of the application using the database.
    private final Context context;
    // Database open/upgrade helper
    private helper dbHelper;

    public studentbaseAdapter(Context _context)
    {
        context=_context;
        dbHelper = new helper(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public  studentbaseAdapter open() throws SQLException
    {
        db = dbHelper.getWritableDatabase();
        return this;
    }
    public void insertEntry( String userName, String password)
    {
        db=dbHelper.getWritableDatabase();
        ContentValues newValues = new ContentValues();
        // Assign values for each row.
//        newValues.put("ID", id);
        newValues.put("USERNAME",userName);
        newValues.put("PASSWORD",password);
        // Insert the row into your table
        db.insert(TABLE_DETAILS, null, newValues);
        ///Toast.makeText(context, "Reminder Is Successfully Saved", Toast.LENGTH_LONG).show();
    }
    public void insertdetails( String id,String userName,String fees,String phone,String school,String year)
    {
        db=dbHelper.getWritableDatabase();
        ContentValues newValues = new ContentValues();
        // Assign values for each row.
        int _id=Integer.parseInt(id);
        newValues.put("ID",_id);
        newValues.put("USERNAME",userName);
        newValues.put("FEES",fees);
        newValues.put("SCHOOL",school);
        newValues.put("YEAR",year);
        newValues.put("PHONE",phone);
        // Insert the row into your table
        db.insert("LOGIN", null, newValues);
        ///Toast.makeText(context, "Reminder Is Successfully Saved", Toast.LENGTH_LONG).show();
    }
    public void close()
    {
        db.close();
    }

    public String getpassword(String username)
    {
        db = dbHelper.getReadableDatabase();
        Cursor cursor=db.query(TABLE_DETAILS,null, "USERNAME=?", new String[]{username}, null, null, null);
        if(cursor.getCount()<1) // UserName Not Exist
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String password= cursor.getString(cursor.getColumnIndex("PASSWORD"));
        return password;
    }
    public Cursor getSinlgeEntry(String username)
    {
        db = dbHelper.getReadableDatabase();
        String query="SELECT * FROM LOGIN WHERE ID="+id;
//        Cursor cursor=db.query(TABLE_NAME,null, "ID=?", new String[]{String.valueOf(id)}, null, null, null);
        Cursor cursor=db.rawQuery(query,null);
//        if(cursor.getCount()<1) // UserName Not Exist
//        {
//            cursor.close();
//            return "NOT EXIST";
//        }
        cursor.moveToFirst();
//        String fees= cursor.getString(cursor.getColumnIndex("FEES"));
        return cursor;
    }

}

