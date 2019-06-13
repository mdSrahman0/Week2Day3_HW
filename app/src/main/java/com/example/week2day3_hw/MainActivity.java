/**
Md Rahman
Create an activity with an edittext for each item listed below.
On a button click, save the values of the items listed below to shared preferences.
 Then open another activity and display each item saved in the MainActivity to SEPARATE textviews.
Hint: this is week 1 day 3 homework, just refactored to use shared preferences :)
First Name
Last Name
Street Address
City
Zip
*/

package com.example.week2day3_hw;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // name of each EditText, where the user will input their information
    private EditText etFName, etLName, etStreet, etCity, etState, etZip;

    // a button that, once clicked, will display the user's information
    private Button btSave;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // link each EditText to it's appropriate ID
        etFName = findViewById(R.id.etFName);
        etLName = findViewById(R.id.etLName);
        etStreet = findViewById(R.id.etStreet);
        etCity = findViewById(R.id.etCity);
        etState = findViewById(R.id.etState);
        etZip = findViewById(R.id.etZip);
        btSave = findViewById(R.id.btSave);

        sharedPreferences = getSharedPreferences("shared_pref", MODE_PRIVATE);
    }

    public void onClick(View view) {
        String fName = etFName.getText().toString();
        String lName = etLName.getText().toString();
        String street = etStreet.getText().toString();
        String city = etCity.getText().toString();
        String state = etState.getText().toString();
        String zip = etZip.getText().toString();

        // a string to hold all the user's input we just got
        String allInfo = fName + " , " + lName + " , " + street + " , " + city + " , "
                + state + " , " + zip;

        storeToSharedPref(allInfo);  // call the method to store sharedPref object and the info
    }

    public void storeToSharedPref(String allInfo){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("user_info", allInfo);
        // save the changes
        editor.apply();
        startActivity(new Intent(this, DisplayActivity.class));
    }
}
