package com.begnerdranch.android.trainercustomermanagement;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.logged_in_container);
        if (fragment == null) {
            fragment = new LoggedInFragment();
            fm.beginTransaction().add(R.id.logged_in_container, fragment).commit();
        }

        FragmentManager fm2 = getSupportFragmentManager();

        Fragment bottomFragment = fm2.findFragmentById(R.id.main_fragment_container);
        if (bottomFragment == null) {
            bottomFragment = new CustomerListFragment();
            fm2.beginTransaction().add(R.id.main_fragment_container, bottomFragment).commit();
        }
    }
}
