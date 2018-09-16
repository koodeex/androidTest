package com.example.user.uitestsbt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button mLoginButton;
    private EditText mLoginField;
    private Button mArrowPlaceholder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Intent intent = getIntent();
        final Intent edgeActivity = new Intent(MainActivity.this, EdgeActivity.class);
        Boolean value = intent.getBooleanExtra("jet", false);

        mLoginButton =(Button) findViewById(R.id.loginButton);
        mArrowPlaceholder= (Button) findViewById(R.id.nextStep);
        mLoginField = (EditText) findViewById(R.id.loginField);

        if (value == true) {
            mLoginButton.setVisibility(View.INVISIBLE);
            mLoginField.setVisibility(View.VISIBLE);
            mArrowPlaceholder.setVisibility(View.VISIBLE);

        }
        else {
            mLoginField.setVisibility(View.INVISIBLE);
            mLoginButton.setVisibility(View.VISIBLE);
            mArrowPlaceholder.setVisibility(View.INVISIBLE);
        }
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                mLoginField.setVisibility(View.VISIBLE);
//
//                mLoginButton.setVisibility(View.INVISIBLE);
                startActivity(edgeActivity);
            }
        });



        mLoginField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length() > 5) {
                    mArrowPlaceholder.setClickable(true);
                }
                else mArrowPlaceholder.setClickable(false);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mArrowPlaceholder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pin = new Intent(MainActivity.this, Pin.class);
               // Boolean value = intent.getBooleanExtra("jet", false);
                startActivity(pin);
            }
        });
    }
}
