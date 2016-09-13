package com.begnerdranch.android.trainercustomermanagement;

import android.widget.ImageView;

import java.util.UUID;

/**
 * Created by Benjamin_2 on 9/12/2016.
 */
public class Customer {
    private String mFirstName;
    private String mLastName;
    private String mPhone;
    private String mAddress;
    private String mCreditCardNum;
    private ImageView mProfilePic;
    private UUID id;

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {

        return id;
    }

    public Customer() {
        id = UUID.randomUUID();
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public void setProfilePic(ImageView profilePic) {
        mProfilePic = profilePic;
    }

    public ImageView getProfilePic() {
        return mProfilePic;
    }

    public void setCreditCardNum(String creditCardNum) {
        mCreditCardNum = creditCardNum;
    }

    public String getCreditCardNum() {
        return mCreditCardNum;
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setPhone(String phone) {
        mPhone = phone;
    }

    public String getPhone() {
        return mPhone;
    }

    public String getFirstName() {
        return mFirstName;
    }
}
