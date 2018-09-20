package com.example.user.uitestsbt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Pin extends AppCompatActivity {
    private Button mOneButton;
    private Button mTwoButton;
    private Button mThreeButton;
    private Button mFourButton;
    private Button mFiveButton;
    private Button mSixButton;
    private Button mSevenButton;
    private Button mEightButton;
    private Button mNineButton;
    private TextView mPin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin);

        mOneButton = (Button) findViewById(R.id.oneBut);
        mTwoButton = (Button) findViewById(R.id.twoBut);
        mThreeButton = (Button) findViewById(R.id.threeBut);
        mFourButton = (Button) findViewById(R.id.fourBut);
        mFiveButton = (Button) findViewById(R.id.fiveBut);
        mSixButton = (Button) findViewById(R.id.sixBut);
        mSevenButton = (Button) findViewById(R.id.sevenBut);
        mEightButton = (Button) findViewById(R.id.eightBut);
        mNineButton = (Button) findViewById(R.id.nineBut);
        mPin = (TextView) findViewById(R.id.pinText);
        final Intent getID = getIntent();


        mOneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = mPin.getText().toString();
                result += (String)mOneButton.getText();
                mPin.setText(result);
            }
        });

        mTwoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPin.setText(mPin.getText().toString() + (String) mTwoButton.getText());
            }
        });

        mThreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPin.setText(mPin.getText().toString() + (String) mThreeButton.getText());
            }
        });

        mFourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPin.setText(mPin.getText().toString() + (String) mFourButton.getText());
            }
        });

        mFiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPin.setText(mPin.getText().toString() + (String) mFiveButton.getText());
            }
        });

        mSixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPin.setText(mPin.getText().toString() + (String) mSixButton.getText());
            }
        });

        mSevenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPin.setText(mPin.getText().toString() + (String) mSevenButton.getText());
            }
        });

        mEightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPin.setText(mPin.getText().toString() + (String) mEightButton.getText());
            }
        });

        mNineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPin.setText(mPin.getText().toString() + (String) mNineButton.getText());
            }
        });

        mPin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length() > 4) {
                    Intent pin2 = new Intent(Pin.this, Pin2.class);
                    pin2.putExtra("accId", getID.getStringExtra("accId"));
                    startActivity(pin2);
                }



            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}
