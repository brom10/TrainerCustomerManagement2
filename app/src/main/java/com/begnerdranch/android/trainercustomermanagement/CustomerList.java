package com.begnerdranch.android.trainercustomermanagement;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Benjamin_2 on 9/12/2016.
 */
public class CustomerList {
    private static CustomerList sCustomerList;
    private List<Customer> mCustomers;

    public static CustomerList get(Context context) {
        if (sCustomerList == null) {
            sCustomerList = new CustomerList(context);
        }
        return sCustomerList;
    }
    private CustomerList(Context context) {
        mCustomers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Customer customer = new Customer();
            customer.setAddress("1234" + i + " Smith St");
            customer.setFirstName("John " + i);
            customer.setLastName("Doe " + i);
            customer.setCreditCardNum("123485479652524" + i);
            customer.setPhone("(813)-1234-123" + i);
            mCustomers.add(customer);
        }
    }

    public List<Customer> getCustomers() {
        return mCustomers;
    }

    public Customer getCustomer(UUID id) {
        for (Customer customer: mCustomers) {
            if (customer.getId().equals(id)) {
                return customer;
            }
        }
        return null;
    }
}
