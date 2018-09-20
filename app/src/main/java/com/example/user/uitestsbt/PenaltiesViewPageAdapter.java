package com.example.user.uitestsbt;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;


class PenaltiesViewPageAdapter  extends FragmentPagerAdapter {
    ArrayList<String[]> searchPaidResults;
    ArrayList<String[]> searchUnpaidResults;
        private String title[] = {"К оплате", "Погашенные"};
        private Context context;
        public PenaltiesViewPageAdapter  (FragmentManager manager, Context context, ArrayList<String[]> searchPaidResults, ArrayList<String[]> searchUnpaidResults) {

            super(manager);
            this.context = context;
            this.searchPaidResults = searchPaidResults;
            this.searchUnpaidResults= searchUnpaidResults;
        }

        @Override
        public Fragment getItem(int position) {
            Fragment frgmt = null;

            switch (position) {
                case 0:
                    return PenaltiesUnpaidTabFragment.getInstance(position, searchUnpaidResults, context);
                case 1:
                    return PenaltiesPaidTabFragment.getInstance(position, searchPaidResults, context);
                default:
                    return null;
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


