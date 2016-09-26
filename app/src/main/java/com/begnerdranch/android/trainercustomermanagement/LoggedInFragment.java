package com.begnerdranch.android.trainercustomermanagement;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.UUID;

public class LoggedInFragment extends Fragment{
    private Button mLogOutButton;
    public static final String LOGGING_OUT = "LogingOut";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_customer_list, menu);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.logged_in, container, false);

        return v;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.log_out_button_menu:
                FragmentManager manager = getFragmentManager();
                LoggingOutFragment dialog = new LoggingOutFragment();
                dialog.show(manager, LOGGING_OUT);
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                return true;
            case R.id.menu_item_new_customer:
                Customer customer = new Customer();
                CustomerList.get(getActivity()).addCustomer(customer);
                Intent i = CustomerActivity.newIntent(getActivity(), customer.getId());
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

}
