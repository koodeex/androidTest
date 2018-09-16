package com.example.user.uitestsbt;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

class ViewPagerAdapter extends FragmentPagerAdapter {

    private String title[] = {"One", "Two", "Three", "Four", "Five"};
    private Context context;
    public ViewPagerAdapter(FragmentManager manager, Context context) {

        super(manager);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frgmt = null;

        switch (position) {
            case 1:
                return TargetFragment.getInstance(position, context);
            default:
                return TabFragment.getInstance(position);
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
