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
package com.example.android.pets;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.android.pets.data.InventoryContract;
import com.example.android.pets.data.InventoryDbHelper;

public class EditorActivity extends AppCompatActivity {

    private EditText nameEditText;

    private EditText priceEditText;

    private EditText quantityEditText;

    private EditText supplierNameEditText;

    private EditText supplierPhoneNumberEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        // Find all relevant views that we will need to read user input from
        nameEditText = (EditText) findViewById(R.id.edit_pet_name);
        priceEditText = (EditText) findViewById(R.id.edit_pet_breed);
        quantityEditText = (EditText) findViewById(R.id.edit_pet_weight);
        supplierNameEditText = (EditText) findViewById(R.id.edit_pet_weight);
        supplierPhoneNumberEditText = (EditText) findViewById(R.id.edit_pet_weight);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_editor.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.menu_editor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Respond to a click on the "Save" menu option
            case R.id.action_save:
                // Do nothing for now
                insertPet();
                finish();
                return true;
            // Respond to a click on the "Delete" menu option
            case R.id.action_delete:
                // Do nothing for now
                return true;
            // Respond to a click on the "Up" arrow button in the app bar
            case android.R.id.home:
                // Navigate back to parent activity (CatalogActivity)
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void insertPet() {
       String nameString =  mNameEditText.getText().toString().trim();
        String breedString =  mBreedEditText.getText().toString().trim();
        String weightString =  mWeightEditText.getText().toString().trim();
        int weight = Integer.parseInt(weightString);

        InventoryDbHelper mDbHelper = new InventoryDbHelper(this);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a ContentValues object where column names are the keys,
        // and Toto's pet attributes are the values.
        ContentValues values = new ContentValues();
        values.put(InventoryContract.InventoryEntry.COLUMN_PET_NAME, nameString);
        values.put(InventoryContract.InventoryEntry.COLUMN_PET_BREED, breedString);
        values.put(InventoryContract.InventoryEntry.COLUMN_PET_GENDER, mGender);
        values.put(InventoryContract.InventoryEntry.COLUMN_PET_WEIGHT, weight);
        long newRowId = db.insert(InventoryContract.InventoryEntry.TABLE_NAME, null, values);
        if(newRowId == -1) {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Succcess", Toast.LENGTH_SHORT).show();
        }
    }
}