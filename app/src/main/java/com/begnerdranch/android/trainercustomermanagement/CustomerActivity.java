package com.begnerdranch.android.trainercustomermanagement;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import java.util.UUID;

/**
 * Created by Benjamin on 9/12/2016.
 */
public class CustomerActivity extends AppCompatActivity {
    public static final String EXTRA_CUSTOMER_ID = "com.begnerdranch.android.trainercustomermanagement.customer_id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_customer_layout);
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.logged_in_container_customer);
        if (fragment == null) {
            fragment = new LoggedInFragment();
            fm.beginTransaction().add(R.id.logged_in_container_customer, fragment).commit();
        }

        FragmentManager fm2 = getSupportFragmentManager();
        Fragment bottomFragment = fm2.findFragmentById(R.id.main_fragment_containe_customer);
        if (bottomFragment == null) {
            bottomFragment = new CustomerFragment();
            fm2.beginTransaction().add(R.id.main_fragment_containe_customer, bottomFragment).commit();
        }

    }

    public static Intent newIntent(Context packageContext, UUID customerId) {
        Intent intent = new Intent(packageContext, CustomerActivity.class);
        intent.putExtra(EXTRA_CUSTOMER_ID, customerId);
        return intent;
    }
}
