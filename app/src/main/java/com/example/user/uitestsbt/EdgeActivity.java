package com.example.user.uitestsbt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EdgeActivity extends AppCompatActivity {
    private Button mcheckButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edge_activity);
        final boolean test = true;
        mcheckButton = (Button) findViewById(R.id.accChoose);

        mcheckButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(EdgeActivity.this, MainActivity.class);
                myIntent.putExtra("jet", test); //Optional parameters
                EdgeActivity.this.startActivity(myIntent);

            }
        });


    }
}
