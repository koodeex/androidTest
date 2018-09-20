package com.example.user.uitestsbt;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

class MainMenuEmulViewPagerAdapter extends FragmentPagerAdapter {

    private String title[] = {"One", "Two", "Three", "Four", "Five"};
    private Context context;
    private  String ID;

    public MainMenuEmulViewPagerAdapter(FragmentManager manager, Context context, String ID) {

        super(manager);
        this.context = context;
        this.ID = ID;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frgmt = null;

        switch (position) {
            case 1:
                return MainMenuEmulTargetFragment.getInstance(position, context, ID);
            default:
                return MainMenuEmulTabFragment.getInstance(position);
        }


    }

    @Override
    public int getCount() {
        return title.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
