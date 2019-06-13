package com.example.week2day3_hw;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    TextView tvFName;
    TextView tvLName;
    TextView tvStreet;
    TextView tvCity;
    TextView tvState;
    TextView tvZip;

    String allInfo;  // will get the string that holds ALL the person's information
    String[] array;  // will split the allInfo string and place into array
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        tvFName = findViewById(R.id.tvFName);
        tvLName = findViewById(R.id.tvLName);
        tvStreet = findViewById(R.id.tvStreet);
        tvCity = findViewById(R.id.tvCity);
        tvState = findViewById(R.id.tvState);
        tvZip = findViewById(R.id.tvZip);

        // access the sharedPreferences we saved from MainActivity
        sharedPreferences = getSharedPreferences("shared_pref", MODE_PRIVATE);
        allInfo = sharedPreferences.getString("user_info", "NO NAME IN SHARED PREF");
        array = allInfo.split(",");

        // if our array does hold information, set the appropriate elements to their respective textviews
        if(array.length != 0) {
            tvFName.setText(array[0]);
            tvLName.setText(array[1]);
            tvStreet.setText(array[2]);
            tvCity.setText(array[3]);
            tvState.setText(array[4]);
            tvZip.setText(array[5]);
        }
    }
}
