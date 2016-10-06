package com.begnerdranch.android.trainercustomermanagement;

import android.widget.ImageView;

import java.util.UUID;

public class Customer {
    private String mFirstName = null;
    private String mLastName = null;
    private String mPhone = null;
    private String mAddress = null;
    private String mCreditCardNum = null;
    private ImageView mProfilePic = null;
    private UUID id;

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {

        return id;
    }

    public Customer() {
        this(UUID.randomUUID());
    }

    public Customer(UUID newID) {
        id = newID;
    }

    public String getPhotoFilename() {
        return "IMG_" + getId().toString() + ".jpg";
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
