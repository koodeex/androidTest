package com.example.user.uitestsbt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class OneStuffActivity extends AppCompatActivity {
    TextView mTextButton;
    Intent getID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_stuff);
        getID = getIntent();
        mTextButton = (TextView)findViewById(R.id.nextStep);
       // mTextButton.setOnClickListener((View.OnClickListener) this);
    }
    public void onClick(View view) {
        Intent goToService = new Intent(OneStuffActivity.this, ChooseYourDestiny.class);
        goToService.putExtra("accId", getID.getStringExtra("accId"));
        startActivity(goToService);
    }
}
