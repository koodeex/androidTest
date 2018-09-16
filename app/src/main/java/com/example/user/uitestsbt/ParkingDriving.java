package com.example.user.uitestsbt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class ParkingDriving extends AppCompatActivity {
    private CheckBox mCheckBox;
    private Button mSearchButton;
    private TextView mCardPlaceholder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_driving);

        mCheckBox = (CheckBox)findViewById(R.id.checkBoxSave);
        mSearchButton = (Button) findViewById(R.id.searchButton);
        mCardPlaceholder = (TextView)findViewById(R.id.cardTempPH);


    }

}
