package com.codepath.tipcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CalculatorActivity extends Activity {

    private TextView mTipTextView;
    private EditText mCheckAmount;
    private double mTipAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        mTipTextView = (TextView) findViewById(R.id.tvTipAmountIs);
        mTipAmount = .15;
        mCheckAmount = (EditText) findViewById(R.id.etTotal);
        mCheckAmount.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
                updateTipAmount();
            }
        });
    }

    private void updateTipAmount() {
        double d;
        try {
            d = Double.valueOf(mCheckAmount.getText().toString());
            mTipTextView.setText("Tip amount is: " + String.format("%.2f", d * mTipAmount));
        } catch (NumberFormatException e) {
            mTipTextView.setText("");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.calculator, menu);
        return true;
    }

    public void onTipAmountClicked(View v) {
        if (v.getId() == R.id.rbTenPercent) {
            mTipAmount = .1;
        } else if (v.getId() == R.id.rbFifteenPercent) {
            mTipAmount = .15;
        } else {
            mTipAmount = .2;
        }
        updateTipAmount();
    }

}
