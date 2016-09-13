package com.begnerdranch.android.trainercustomermanagement;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.UUID;

/**
 * Created by Benjamin on 9/12/2016.
 */
public class CustomerFragment extends Fragment {
    private Customer mCustomer = new Customer();
    private RecyclerView mRecyclerView;
    private Button mNewSessionButton;
    private UUID id;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.customer_view, container, false);

        mNewSessionButton = (Button) v.findViewById(R.id.add_new_session_button);
        mNewSessionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = UUID.randomUUID();
                Intent intent = NewSessionActivity.newIntent(getActivity(), id);
                startActivity(intent);
            }
        });


        return v;

    }
}
