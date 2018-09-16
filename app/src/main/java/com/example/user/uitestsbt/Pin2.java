package com.example.user.uitestsbt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Pin2 extends AppCompatActivity {
    private Button mOneButton2;
    private Button mTwoButton2;
    private Button mThreeButton2;
    private Button mFourButton2;
    private Button mFiveButton2;
    private Button mSixButton2;
    private Button mSevenButton2;
    private Button mEightButton2;
    private Button mNineButton2;
    private TextView mPin2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin);

//        mOneButton2 = (Button) findViewById(R.id.oneBut2);
//        mTwoButton2 = (Button) findViewById(R.id.twoBut2);
//        mThreeButton2 = (Button) findViewById(R.id.threeBut2);
//        mFourButton2 = (Button) findViewById(R.id.fourBut2);
//        mFiveButton2 = (Button) findViewById(R.id.fiveBut2);
//        mSixButton2 = (Button) findViewById(R.id.sixBut2);
//        mSevenButton2 = (Button) findViewById(R.id.sevenBut2);
//        mEightButton2 = (Button) findViewById(R.id.eightBut2);
//        mNineButton2 = (Button) findViewById(R.id.nineBut2);
//        mPin2 = (TextView) findViewById(R.id.pinText2);

        mOneButton2 = (Button) findViewById(R.id.oneBut);
        mTwoButton2 = (Button) findViewById(R.id.twoBut);
        mThreeButton2 = (Button) findViewById(R.id.threeBut);
        mFourButton2 = (Button) findViewById(R.id.fourBut);
        mFiveButton2 = (Button) findViewById(R.id.fiveBut);
        mSixButton2 = (Button) findViewById(R.id.sixBut);
        mSevenButton2 = (Button) findViewById(R.id.sevenBut);
        mEightButton2 = (Button) findViewById(R.id.eightBut);
        mNineButton2 = (Button) findViewById(R.id.nineBut);
        mPin2 = (TextView) findViewById(R.id.pinText);




        mOneButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = mPin2.getText().toString();
                result += (String) mOneButton2.getText();
                mPin2.setText(result);
            }
        });

        mTwoButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPin2.setText(mPin2.getText().toString() + (String) mTwoButton2.getText());
            }
        });

        mThreeButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPin2.setText(mPin2.getText().toString() + (String) mThreeButton2.getText());
            }
        });

        mFourButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPin2.setText(mPin2.getText().toString() + (String) mFourButton2.getText());
            }
        });

        mFiveButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPin2.setText(mPin2.getText().toString() + (String) mFiveButton2.getText());
            }
        });

        mSixButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPin2.setText(mPin2.getText().toString() + (String) mSixButton2.getText());
            }
        });

        mSevenButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPin2.setText(mPin2.getText().toString() + (String) mSevenButton2.getText());
            }
        });

        mEightButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPin2.setText(mPin2.getText().toString() + (String) mEightButton2.getText());
            }
        });

        mNineButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPin2.setText(mPin2.getText().toString() + (String) mNineButton2.getText());
            }
        });

        mPin2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length() > 4) {
                    Intent preloaderFake = new Intent(Pin2.this, PreloaderFake.class);
                    startActivity(preloaderFake);
                }



            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}
