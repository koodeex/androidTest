package com.example.user.uitestsbt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ChooseYourDestiny extends AppCompatActivity {
    TextView mFirstOption;
    TextView mSecondOption;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_your_destiny);
        mFirstOption = (TextView)findViewById(R.id.firstOption);
        mSecondOption = (TextView) findViewById(R.id.secondOption);




    }
    public void onClick1(View view) {
        Intent parkingDriving = new Intent(ChooseYourDestiny.this, ParkingDriving.class);
        startActivity(parkingDriving);
    }

    public void onClick2(View view) {

    }
}
