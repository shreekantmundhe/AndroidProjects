package com.example.android.pets.data;

import android.provider.BaseColumns;

/**
 * Created by shrikantm on 10/05/2018.
 */

public final class InventoryContract {

    private InventoryContract() {}
    public static final class InventoryEntry implements BaseColumns {

        public final static String TABLE_NAME = "Inventory";
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_PRODUCT_NAME ="product name";
        public final static String COLUMN_PRICE = "price";
        public final static String COLUMN_QUANTITY = "quantity";
        public final static String COLUMN_SUPPLIER_NAME = "supplier name";
        public final static String COLUMN_SUPPLIER_PHONE_NUMBER = "supplier phone number";
    }

}
