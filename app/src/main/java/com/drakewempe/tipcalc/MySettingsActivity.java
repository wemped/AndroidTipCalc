package com.drakewempe.tipcalc;

import android.content.SharedPreferences;
import android.preference.ListPreference;
import android.preference.PreferenceActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;



public class MySettingsActivity extends PreferenceActivity {

    private RadioGroup tipPercentGroup;
    private RadioButton fifteenRadio, twentyRadio, twentyFiveRadio,thirtyRadio;
    private ListPreference tipList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.pref_general);

        tipList.setOnPreferenceChangeListener();

       /* tipPercentGroup = (RadioGroup)findViewById(R.id.defaultTipRadioGroup);
        fifteenRadio = (RadioButton)findViewById(R.id.defaultTip15);
        twentyRadio = (RadioButton)findViewById(R.id.defaultTip20);
        twentyFiveRadio = (RadioButton)findViewById(R.id.defaultTip25);
        thirtyRadio = (RadioButton)findViewById(R.id.defaultTip30);



        tipPercentGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.defaultTip15){

                }
            }
        });*/
    }

    /*private ListPreference appPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_settings);

        RadioGroup defaultTipGroup = (RadioGroup)findViewById(R.id.defaultTipRadioGroup);

        addPreferencesFromResource(R.xml.pref_general);
        appPreferences = (ListPreference)getPreferenceScreen().findPreference("percentList");
    }

    protected void onResume(){
        super.onResume();

    }

    protected void onPause(){
        super.onPause();
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

    }
    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my_settings, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}
