package com.example.user.uitestsbt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class ParkingDriving extends AppCompatActivity {
    private CheckBox mCheckBox;
    private Button mSearchButton;
    private TextView mCardPlaceholder;
    private EditText mSTSTextBox;
    private EditText mWUTextBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_driving);

        mCheckBox = (CheckBox)findViewById(R.id.checkBoxSave);
        mSearchButton = (Button) findViewById(R.id.searchButton);
        mCardPlaceholder = (TextView)findViewById(R.id.cardTempPH);
        mSTSTextBox = (EditText)findViewById(R.id.stsEditText);
        mWUTextBox = (EditText)findViewById(R.id.wuEditText);

        final Intent search = new Intent (ParkingDriving.this, PenaltiesActivity.class);


        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                search.putExtra("wuParams", mWUTextBox.getText().toString());
                search.putExtra("stsParams", mSTSTextBox.getText().toString());
                startActivity(search);
            }
        });


    }

}
