package com.drakewempe.tipcalc;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/*
Drake Wempe
April 2015
Assignment 1
Tip Calculator

User can input a price and percentage and the app will instantly display the tip
and the total with the tip included.
*/




public class MainActivity extends ActionBarActivity {
    public static final String MY_PREFERENCES = "preferences.xml";
    //final EditText priceField,tipField;
    //final TextView tipResult,plusPrice,totalResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Connect all TextViews to java code
        final TextView tipResult,plusPrice,totalResult;
        tipResult = (TextView)findViewById(R.id.tip);
        plusPrice = (TextView)findViewById(R.id.plusPrice);
        totalResult = (TextView)findViewById(R.id.total);

        //Connect all EditTexts to java code
        final EditText priceField,tipField;
        tipField = (EditText)findViewById(R.id.numberFieldTipPercent);
        priceField = (EditText) findViewById(R.id.numberFieldEnterPrice);

        //Create text changed listener for tipField and priceField
        //This is so we can edit the tip and total amounts while the user types
        tipField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //nuthin
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //nuthin
            }

            @Override
            public void afterTextChanged(Editable s) {
                updateResults(priceField,tipField,tipResult,plusPrice,totalResult);
            }
        });
        priceField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //nuthin
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //nuthin
            }

            @Override
            public void afterTextChanged(Editable s) {
                updateResults(priceField,tipField,tipResult,plusPrice,totalResult);
            }
        });

        //SharedPreferences.Editor settingsEditor = getSharedPreferences(MY_PREFERENCES,MODE_PRIVATE).edit();
        //String tipFromPreferences = settingsEditor.getClass();

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        String tipFromPreferences = sp.getString("listPref","20");
        Log.v("debug", tipFromPreferences);
        //tipField.setText(tipFromPreferences);



    }
    //This function is called when the price or tip percentage has changed
    //It will update the tip to give and the total price depending on the changed values
    public void updateResults(EditText price_field, EditText tip_field, TextView tip, TextView plusPrice, TextView total){
        double price_double,tip_double,total_double, plusTotal_double;

        //attempt to convert string to double
        String price_string = price_field.getText().toString();
        try {
            price_double = new Double(price_string);
        }catch (Exception e){
            //if it cannot be converted, continue as 0.0
            price_double = 0.0;
        }
        //attempt to convert string to double
        String tip_string = tip_field.getText().toString();
        try {
            tip_double = new Double(tip_string);
        }catch (Exception e) {
            //if it cannot be converted, continue as 0.0
            tip_double = 0.0;
        }

        //Calculate total and tip
        tip_double = tip_double * .01;
        tip_double = tip_double * price_double;

        NumberFormat two_decimals = new DecimalFormat("0.00");

        tip.setText("$" + two_decimals.format(tip_double));
        plusPrice.setText("+ " + two_decimals.format(price_double));
        total.setText("$" + two_decimals.format(price_double + tip_double));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent settingsIntent = new Intent(this, MySettingsActivity.class);
            startActivity(settingsIntent);
            return true;

        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onResume(){
        super.onResume();
        final EditText priceField,tipField;
        final TextView tipResult,plusPrice,totalResult;
        tipField = (EditText)findViewById(R.id.numberFieldTipPercent);
        priceField = (EditText)findViewById(R.id.numberFieldEnterPrice);
        tipResult = (TextView)findViewById(R.id.tip);
        plusPrice = (TextView)findViewById(R.id.plusPrice);
        totalResult = (TextView)findViewById(R.id.total);



        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        String tipFromPreferences = sp.getString("listPref","20");
        Log.v("debug", tipFromPreferences);
        tipField.setText(tipFromPreferences);
        updateResults(priceField,tipField,tipResult,plusPrice,totalResult);

    }
}
