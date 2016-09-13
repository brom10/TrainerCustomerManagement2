package com.begnerdranch.android.trainercustomermanagement;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.UUID;

public class NewSessionActivity extends AppCompatActivity {
    private static final String EXTRA_SESSION_ID = "com.begnerdranch.android.trainercustomermanagement.session_id";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_session);
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.logged_in_container_session);
        if (fragment == null) {
            fragment = new LoggedInFragment();
            fm.beginTransaction().add(R.id.logged_in_container_session, fragment).commit();
        }

        FragmentManager fm2 = getSupportFragmentManager();
        Fragment bottomFragment = fm2.findFragmentById(R.id.main_fragment_container_session);
        if (bottomFragment == null) {
            bottomFragment = new SessionFragment();
            fm2.beginTransaction().add(R.id.main_fragment_container_session, bottomFragment).commit();
        }
    }

    public static Intent newIntent(Context packageContext, UUID sessionId) {
        Intent intent = new Intent(packageContext, NewSessionActivity.class);
        intent.putExtra(EXTRA_SESSION_ID, sessionId);
        return intent;
    }

}


