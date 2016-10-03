package com.begnerdranch.android.trainercustomermanagement;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.UUID;

/**
 * Created by Benjamin on 9/12/2016.
 */
public class CustomerFragment extends Fragment {
    private Customer mCustomer;
    private RecyclerView mRecyclerView;
    private Button mNewSessionButton;
    private Button mSaveButton;
    private UUID customerId;
    private EditText mFirstNameView;
    private EditText mLastNameView;
    private EditText mPhoneView;
    private EditText mAddressView;
    private EditText mCreditCardView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        customerId = (UUID) getActivity().getIntent().getSerializableExtra(CustomerActivity.EXTRA_CUSTOMER_ID);
        mCustomer = CustomerList.get(getActivity()).getCustomer(customerId);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.customer_view, container, false);

        mFirstNameView = (EditText) v.findViewById(R.id.first_name_edit_text);
        mLastNameView = (EditText) v.findViewById(R.id.last_name_edit_text);
        mPhoneView = (EditText) v.findViewById(R.id.phone_edit_text);
        mAddressView = (EditText) v.findViewById(R.id.address_edit_text);
        mCreditCardView = (EditText) v.findViewById(R.id.credit_exit_text);

        // checking that the customer actually has data to set on the edit text
        mFirstNameView.setText(mCustomer.getFirstName());
        mLastNameView.setText(mCustomer.getLastName());
        mPhoneView.setText(mCustomer.getPhone());
        mAddressView.setText(mCustomer.getAddress());
        mCreditCardView.setText(mCustomer.getCreditCardNum());

        mSaveButton = (Button) v.findViewById(R.id.save_button);
        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCustomer.setFirstName(mFirstNameView.getText().toString());
                mCustomer.setLastName(mLastNameView.getText().toString());
                mCustomer.setPhone(mPhoneView.getText().toString());
                mCustomer.setAddress(mAddressView.getText().toString());
                mCustomer.setCreditCardNum(mCreditCardView.getText().toString());

                CustomerList.get(getActivity()).updateCustomer(mCustomer);
            }
        });

        mNewSessionButton = (Button) v.findViewById(R.id.add_new_session_button);
        mNewSessionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = NewSessionActivity.newIntent(getActivity(), customerId);
                startActivity(intent);
            }
        });


        return v;
    }
}
