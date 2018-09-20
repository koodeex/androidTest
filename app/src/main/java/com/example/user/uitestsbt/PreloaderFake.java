package com.example.user.uitestsbt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PreloaderFake extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preloader_fake);
        try {
            Thread.sleep(10000);
            Intent subActivity = new Intent(PreloaderFake.this, MainMenuEmulActivity.class);
            startActivity(subActivity);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
