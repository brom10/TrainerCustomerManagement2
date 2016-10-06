package com.begnerdranch.android.trainercustomermanagement;

import com.begnerdranch.android.trainercustomermanagement.database.CustomerCursorWrapper;
import com.begnerdranch.android.trainercustomermanagement.database.CustomerDbSchema.CustomerTable;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import com.begnerdranch.android.trainercustomermanagement.database.CustomerBaseHelper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CustomerList {
    private static CustomerList sCustomerList;

    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static CustomerList get(Context context) {
        if (sCustomerList == null) {
            sCustomerList = new CustomerList(context);
        }
        return sCustomerList;
    }

    public File getPhotoFile(Customer customer) {
        File externalFilesDir = mContext.getExternalFilesDir(Environment.DIRECTORY_PICTURES);

        if (externalFilesDir == null) {
            return null;
        }
        return new File (externalFilesDir, customer.getPhotoFilename());
    }

    public void addCustomer(Customer c) {
        ContentValues values = getContentValues(c);
        mDatabase.insert(CustomerTable.NAME, null, values);
    }
    private CustomerList(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new CustomerBaseHelper(mContext).getWritableDatabase();
    }

    public List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();

        CustomerCursorWrapper cursor = queryCustomers(null, null);

        try {
            cursor.moveToFirst();
            while(!cursor.isAfterLast()) {
                customers.add(cursor.getCustomer());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }

        return customers;
    }

    public Customer getCustomer(UUID id) {
        CustomerCursorWrapper cursor = queryCustomers(
                CustomerTable.Cols.UUID + " = ?",
                new String[] {id.toString()}
        );

        try {
            if (cursor.getCount() == 0) {
                return null;
            }
            cursor.moveToFirst();
            return cursor.getCustomer();
        }finally {
            cursor.close();
        }
    }

    public void updateCustomer(Customer customer) {
        String uuidString = customer.getId().toString();
        ContentValues values = getContentValues(customer);

        mDatabase.update(CustomerTable.NAME, values,
                CustomerTable.Cols.UUID + " = ?",
                new String[] {uuidString});
    }

    private CustomerCursorWrapper queryCustomers(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                CustomerTable.NAME,
                null,
                whereClause,
                whereArgs,
                null,
                null,
                null);
        return new CustomerCursorWrapper(cursor);
    }

    private static ContentValues getContentValues(Customer customer) {
        ContentValues values = new ContentValues();
        values.put(CustomerTable.Cols.UUID, customer.getId().toString());
        values.put(CustomerTable.Cols.FIRSTNAME, customer.getFirstName());
        values.put(CustomerTable.Cols.LASTNAME, customer.getLastName());
        values.put(CustomerTable.Cols.PHONE, customer.getPhone());
        values.put(CustomerTable.Cols.ADDRESS, customer.getAddress());
        values.put(CustomerTable.Cols.CREDITCARD, customer.getCreditCardNum());

        return values;
    }
}
