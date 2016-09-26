package com.begnerdranch.android.trainercustomermanagement.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.begnerdranch.android.trainercustomermanagement.Customer;
import com.begnerdranch.android.trainercustomermanagement.database.CustomerDbSchema.CustomerTable;

import java.util.UUID;

public class CustomerCursorWrapper extends CursorWrapper {
    public CustomerCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Customer getCustomer() {
        String uuidString = getString(getColumnIndex(CustomerTable.Cols.UUID));
        String firstname = getString(getColumnIndex(CustomerTable.Cols.FIRSTNAME));
        String lastname = getString(getColumnIndex(CustomerTable.Cols.LASTNAME));
        String phone = getString(getColumnIndex(CustomerTable.Cols.PHONE));
        String address = getString(getColumnIndex(CustomerTable.Cols.ADDRESS));
        String creditcard = getString(getColumnIndex(CustomerTable.Cols.CREDITCARD));

        Customer customer = new Customer(UUID.fromString(uuidString));
        customer.setFirstName(firstname);
        customer.setLastName(lastname);
        customer.setPhone(phone);
        customer.setAddress(address);
        customer.setCreditCardNum(creditcard);

        return customer;
    }
}
