package com.example.user.uitestsbt;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.TabLayout;

public class MainMenuEmulActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu_emul_activity);
//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        viewPager = (ViewPager) findViewById(R.id.viewpager);
        MainMenuEmulViewPagerAdapter adapter = new MainMenuEmulViewPagerAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(adapter);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
}
