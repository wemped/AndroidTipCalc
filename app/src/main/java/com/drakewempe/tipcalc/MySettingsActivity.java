package com.drakewempe.tipcalc;

import android.content.SharedPreferences;
import android.preference.ListPreference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;



public class MySettingsActivity extends PreferenceActivity implements SharedPreferences.OnSharedPreferenceChangeListener{

    private RadioGroup tipPercentGroup;
    private RadioButton fifteenRadio, twentyRadio, twentyFiveRadio,thirtyRadio;
    private ListPreference tipList;
    public static final String my_prefs = "pref_general";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.pref_general);

        tipList = (ListPreference)getPreferenceScreen().findPreference("listPref");
        //tipList.setSummary(tipList.getEntry().toString());


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
    */
    protected void onResume(){
        super.onResume();
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        sp.registerOnSharedPreferenceChangeListener(this);
        //getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    protected void onPause(){
        super.onPause();
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        sp.unregisterOnSharedPreferenceChangeListener(this);
        //getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (key.equals("listPref")){
            //SharedPreferences.Editor editor = getEditor();
            //String newSumm = tipList.getValue();
            tipList.setSummary(tipList.getValue());
            
            //tipList.setSummary("WEEEE");
           // Log.v("testing", tipList.getValue());
            //Log.v("testing", tipList.getEntry().toString());

        }
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
