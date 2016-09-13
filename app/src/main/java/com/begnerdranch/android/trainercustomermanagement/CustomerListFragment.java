package com.begnerdranch.android.trainercustomermanagement;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Benjamin on 9/12/2016.
 */
public class CustomerListFragment extends Fragment{
    private RecyclerView mRecyclerView;
    private CustomerAdapter mCustomerAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.customer_list_layout, container, false);

        mRecyclerView = (RecyclerView) v.findViewById(R.id.customer_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();
        return v;
    }

    private void updateUI() {
        CustomerList customerList = CustomerList.get(getActivity());
        List<Customer> customers = customerList.getCustomers();

        mCustomerAdapter = new CustomerAdapter(customers);
        mRecyclerView.setAdapter(mCustomerAdapter);
    }

    private class CustomerAdapter extends RecyclerView.Adapter<CustomerHolder> {
        private List<Customer> mCustomers;

        public CustomerAdapter(List<Customer> customers) {
            mCustomers = customers;
        }

        @Override
        public CustomerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.customer_list, parent, false);
            return new CustomerHolder(view);
        }

        @Override
        public void onBindViewHolder(CustomerHolder holder, int position) {
            Customer customer = mCustomers.get(position);
            holder.bindCustomer(customer);
        }

        @Override
        public int getItemCount() {
            return mCustomers.size();
        }
    }

    private class CustomerHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView mFirstTextView;
        private Customer mCustomer;

        @Override
        public void onClick(View v) {
            Intent intent = CustomerActivity.newIntent(getActivity(), null);
            startActivity(intent);
        }

        public CustomerHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            mFirstTextView = (TextView) itemView.findViewById(R.id.name_text_view);
        }

        public void bindCustomer(Customer customer) {
            mCustomer = customer;
            mFirstTextView.setText(customer.getFirstName() + customer.getLastName());
        }
    }
}
