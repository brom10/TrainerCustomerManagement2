package com.begnerdranch.android.trainercustomermanagement.database;

import com.begnerdranch.android.trainercustomermanagement.database.CustomerDbSchema.CustomerTable;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CustomerBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "customerBase.db";

    public CustomerBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + CustomerDbSchema.CustomerTable.NAME + "(" +
        " _id integer primary key autoincrement, " +
        CustomerTable.Cols.UUID + ", " +
        CustomerTable.Cols.FIRSTNAME + ", " +
        CustomerTable.Cols.LASTNAME + ", " +
        CustomerTable.Cols.PHONE + ", " +
        CustomerTable.Cols.ADDRESS + ", " +
        CustomerTable.Cols.CREDITCARD + ")" );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
