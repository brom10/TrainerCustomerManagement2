package com.begnerdranch.android.trainercustomermanagement;

import android.content.Intent;
import android.graphics.Bitmap;
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

import java.io.File;
import java.util.List;

public class CustomerListFragment extends Fragment{
    private RecyclerView mRecyclerView;
    private CustomerAdapter mCustomerAdapter;

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

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
        if (mCustomerAdapter == null) {
            mCustomerAdapter = new CustomerAdapter(customers);
            mRecyclerView.setAdapter(mCustomerAdapter);
        }
        else {
            mCustomerAdapter.setCustomers(customers);
            mCustomerAdapter.notifyDataSetChanged();
        }
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

        public void setCustomers(List<Customer> customers) {
            mCustomers = customers;
        }
    }

    private class CustomerHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView mFirstTextView;
        public ImageView mImageView;
        private Customer mCustomer;
        private File mPhotoFile;

        @Override
        public void onClick(View v) {
            Intent intent = CustomerActivity.newIntent(getActivity(), mCustomer.getId());
            startActivity(intent);
        }

        public CustomerHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            mFirstTextView = (TextView) itemView.findViewById(R.id.name_text_view);
            mImageView = (ImageView) itemView.findViewById(R.id.profile_pic_list);
        }

        public void bindCustomer(Customer customer) {
            mCustomer = customer;
            mPhotoFile = CustomerList.get(getActivity()).getPhotoFile(mCustomer);
            mFirstTextView.setText(customer.getFirstName() + customer.getLastName());
            if (mPhotoFile != null && mPhotoFile.exists()) {
                Bitmap bitmap = PictureUtils.getSmallerScaledBitmap(
                        mPhotoFile.getPath(), getActivity());
                mImageView.setImageBitmap(bitmap);
            }
        }
    }
}
