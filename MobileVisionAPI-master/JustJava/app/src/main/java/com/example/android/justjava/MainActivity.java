/**
 * IMPORTANT: Make sure you are using the correct package name. 
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/
package com.example.android.justjava;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedCream = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCream.isChecked();

        CheckBox chocolate = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolate.isChecked();
        calculatePrice(hasWhippedCream, hasChocolate);
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quanity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));

    }

    public void addQuantity(View view) {
        if (quantity < 99){
            display(++quantity);
        } else {
            Toast.makeText(this, "Should not order more than 100 cups at time",
                    Toast.LENGTH_LONG).show();
        }

    }

    public void substractQuantity(View view) {
        if (quantity > 0){
            display(--quantity);
        } else {
            Toast.makeText(this, "Should not order less than 0",
                    Toast.LENGTH_LONG).show();
        }
    }

    private void calculatePrice(boolean addWhippedCream, boolean addChocolate) {
        int perCupPrice = 5;

        if (addChocolate) {
            perCupPrice = perCupPrice + 2;
        }

        if (addWhippedCream) {
            perCupPrice = perCupPrice + 1;
        }

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "first app");
        intent.putExtra(Intent.EXTRA_TEXT, "Shree" + perCupPrice * quantity);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        displayPrice(perCupPrice * quantity);
    }
}

