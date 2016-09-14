package edu.orangecoastcollege.cs273.fjuarez6.shippingcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private static NumberFormat currency = NumberFormat.getCurrencyInstance();

    private EditText weightEditText;
    private TextView baseAmountTextView;
    private TextView addedAmountTextView;
    private TextView totalAmountTextView;

    ShipItem itemPackage = new ShipItem();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightEditText = (EditText) findViewById(R.id.weightEditText);
        baseAmountTextView = (TextView) findViewById(R.id.baseAmountTextView);
        addedAmountTextView = (TextView) findViewById(R.id.addedAmountTextView);
        totalAmountTextView = (TextView) findViewById(R.id.totalAmountTextView);

        baseAmountTextView.setText(currency.format(itemPackage.getBaseCost()));
        updateView();

        weightEditText.addTextChangedListener(weighTextChangedListener);

    }

    TextWatcher weighTextChangedListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            try {
                double weight = Double.parseDouble(s.toString());
                itemPackage.setWeight(weight);

            }
            catch (NumberFormatException e) {

                weightEditText.setText("");

            }

           updateView();

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private void updateView(){

        addedAmountTextView.setText(currency.format(itemPackage.getAddedCost()));
        totalAmountTextView.setText(currency.format(itemPackage.getTotalCoast()));
    }
}
