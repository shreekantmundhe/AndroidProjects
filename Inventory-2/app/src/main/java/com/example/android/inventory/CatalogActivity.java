/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.inventory;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.android.inventory.data.InventoryContract;
import com.example.android.inventory.data.InventoryDbHelper;

/**
 * Displays list of pets that were entered and stored in the app.
 */
public class CatalogActivity extends AppCompatActivity {

    private InventoryDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        mDbHelper = new InventoryDbHelper(this);
        insertPet();
    }

    @Override
    protected void onStart() {
        super.onStart();
        displayDatabaseInfo();
    }
    private void displayDatabaseInfo() {

        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String[] projection = {
                InventoryContract.InventoryEntry._ID,
                InventoryContract.InventoryEntry.COLUMN_PRODUCT_NAME,
                InventoryContract.InventoryEntry.COLUMN_PRICE,
                InventoryContract.InventoryEntry.COLUMN_QUANTITY,
                InventoryContract.InventoryEntry.COLUMN_SUPPLIER_PHONE_NUMBER,
                InventoryContract.InventoryEntry.COLUMN_SUPPLIER_NAME
                };

        Cursor cursor = db.query(InventoryContract.InventoryEntry.TABLE_NAME, projection, null, null, null, null, null);

        TextView displayView = (TextView) findViewById(R.id.text_view_pet);
        try {
            displayView.setText("The Inventory table contains : " + cursor.getCount() + " Products.\n\n");
            displayView.append(InventoryContract.InventoryEntry._ID + " - " + InventoryContract.InventoryEntry.COLUMN_PRODUCT_NAME + " - " + InventoryContract.InventoryEntry.COLUMN_PRICE + " - " + InventoryContract.InventoryEntry.COLUMN_QUANTITY + " - " + InventoryContract.InventoryEntry.COLUMN_SUPPLIER_NAME + " - " + InventoryContract.InventoryEntry.COLUMN_SUPPLIER_PHONE_NUMBER +    "\n");

            int idColumnIndex = cursor.getColumnIndex(InventoryContract.InventoryEntry._ID);
            int nameColumnIndex = cursor.getColumnIndex(InventoryContract.InventoryEntry.COLUMN_PRODUCT_NAME);
            int priceColumnIndex = cursor.getColumnIndex(InventoryContract.InventoryEntry.COLUMN_PRICE);
            int quantityColumnIndex = cursor.getColumnIndex(InventoryContract.InventoryEntry.COLUMN_QUANTITY);
            int supplierNameColumnIndex = cursor.getColumnIndex(InventoryContract.InventoryEntry.COLUMN_SUPPLIER_NAME);
            int supplierPhoneNumberColumnIndex = cursor.getColumnIndex(InventoryContract.InventoryEntry.COLUMN_SUPPLIER_PHONE_NUMBER);

            while(cursor.moveToNext()) {
                int currentID = cursor.getInt(idColumnIndex);
                String productName = cursor.getString(nameColumnIndex);
                String productQuantity = cursor.getString(quantityColumnIndex);
                String productPrice = cursor.getString(priceColumnIndex);
                String supplierName = cursor.getString(supplierNameColumnIndex);
                String supplierPhone = cursor.getString(supplierPhoneNumberColumnIndex);

                displayView.append("\n" + currentID + " - " + productName + " - " + productQuantity + " - " + supplierName + " - " + supplierPhone + " - " + productPrice);
            }
        } finally {
            // Always close the cursor when you're done reading from it. This releases all its
            // resources and makes it invalid.
            cursor.close();
        }
    }

    private void insertPet() {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
            values.put(InventoryContract.InventoryEntry.COLUMN_PRODUCT_NAME, "Computer");
            values.put(InventoryContract.InventoryEntry.COLUMN_PRICE, 100);
            values.put(InventoryContract.InventoryEntry.COLUMN_QUANTITY, 1);
        values.put(InventoryContract.InventoryEntry.COLUMN_SUPPLIER_PHONE_NUMBER, 123);
            values.put(InventoryContract.InventoryEntry.COLUMN_SUPPLIER_NAME, "BABA");

            long newRowId = db.insert(InventoryContract.InventoryEntry.TABLE_NAME, null, values);
        }
}
