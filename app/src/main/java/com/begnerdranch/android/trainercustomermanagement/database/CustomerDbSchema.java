package com.begnerdranch.android.trainercustomermanagement.database;

public class CustomerDbSchema {
    public static final class CustomerTable {
        public static final String NAME = "customers";

        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String FIRSTNAME = "firstname";
            public static final String LASTNAME = "lastname";
            public static final String PHONE = "phone";
            public static final String ADDRESS = "address";
            public static final String CREDITCARD = "creditcard";
        }
    }
}
