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
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.android.inventory.data.InventoryContract;
import com.example.android.inventory.data.InventoryDbHelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.android.volley.Request.*;

/**
 * Displays list of pets that were entered and stored in the app.
 */
public class CatalogActivity extends AppCompatActivity {

    private InventoryDbHelper mDbHelper;
    private RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        mRequestQueue = Volley.newRequestQueue(this);
        fetchJsonResponse();
        //mDbHelper = new InventoryDbHelper(this);
        //insertPet();
    }

    @Override
    protected void onStart() {
        super.onStart();
        //displayDatabaseInfo();
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

    private void fetchJsonResponse() {
        // Pass second argument as "null" for GET requests

        Map<String, String> params = new HashMap();
        params.put("Alias", "sports.betway.com");
        params.put("ClientTypeId", "1");
        String url = "https://sports.betway.com/api/configuration/v2/ValidateEntryPoint";

        JSONObject parameters = new JSONObject(params);

        JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST, "https://sports.betway.com/api/configuration/v2/ValidateEntryPoint", parameters,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            TextView t = (TextView) findViewById(R.id.text_view_pet);

                            String result = "Your IP Address is " + response.getString("TerritoryId");
                            t.setText(result);
                            //Toast.makeText(CatalogActivity.this, result, Toast.LENGTH_SHORT).show();
                            Toast.makeText(CatalogActivity.this, result, Toast.LENGTH_SHORT).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e("Error: ", error.getMessage());
            }
        });

//        StringRequest req = new StringRequest(Request.Method.POST, url,
//                new Response.Listener<String>()
//                {
//                    @Override
//                    public void onResponse(String response)
//                    {
//                        Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
//                    }
//                },
//                new Response.ErrorListener()
//                {
//                    @Override
//                    public void onErrorResponse(VolleyError error)
//                    {
//                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
//                    }
//                })
//        {
//            @Override
//            protected Map<String, String> getParams()
//            {
//                Map<String, String> params = new HashMap<String, String>();
//                params.put("Alias", "sports.betway.com");
//                params.put("ClientTypeId", "1");
//                return params;
//            }
//        };

		/* Add your Requests to the RequestQueue to execute */
        mRequestQueue.add(req);
    }
}
