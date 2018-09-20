package com.example.user.uitestsbt;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PenaltiesActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar toolbar;
    private String wu;
    private String sts;
    ArrayList<String[]> searchPaidResults = new ArrayList<>();
    ArrayList<String[]> searchUnpaidResults = new ArrayList<>();
    private InputStreamReader csvfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penalties);

        final Intent searchParams = getIntent();
        wu = searchParams.getStringExtra("wuParams");
        sts = searchParams.getStringExtra("stsParams");

        //String csvfileString = this.getApplicationInfo().dataDir +  File.separatorChar + "PenaltiesActivity.csv";
        AssetManager csvfileString = getAssets();
        try {
            csvfile = new InputStreamReader(csvfileString.open("penalties.csv"));
        }
        catch (IOException e){
            e.printStackTrace();
            System.err.println("No PenaltiesActivity file");
        }

        CSVParse penaltyParser = new CSVParse(this, csvfile);
        boolean stsNotEmpty = false;
        boolean wuNotEmpty = false;

        if (wu != null)
            wuNotEmpty = !wu.isEmpty();
        if (sts != null)
            stsNotEmpty = !sts.isEmpty();

        boolean bothNotEmpty = wuNotEmpty && stsNotEmpty;
        ArrayList<String[]> tmp = penaltyParser.getParseResults();
        for (String[] penalty: tmp) {
            boolean csvWU = false;
            boolean csvSTS = false;
            if (penalty[0] != null)
                csvWU = !penalty[0].isEmpty();
            if (penalty[1] != null)
                csvSTS = !penalty[1].isEmpty();
            boolean csvBoth = csvWU && csvSTS;
            if (bothNotEmpty && csvBoth && penalty[0].equals(wu) && penalty[1].equals(sts)){
                if (Boolean.parseBoolean(penalty[3]))
                    searchPaidResults.add(penalty);
                else
                    searchUnpaidResults.add(penalty);
            }
            else if ( csvWU && wuNotEmpty && penalty[0].equals(wu)) {
                if (Boolean.parseBoolean(penalty[3]))
                    searchPaidResults.add(penalty);
                else
                    searchUnpaidResults.add(penalty);
            }
            else if (csvSTS && stsNotEmpty && penalty[1].equals(sts)) {
                if (Boolean.parseBoolean(penalty[3]))
                    searchPaidResults.add(penalty);
                else
                    searchUnpaidResults.add(penalty);
            }
        }
        System.out.println(searchPaidResults.size());

        toolbar = (Toolbar) findViewById(R.id.toolbar_penalties);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager_penalties);
        PenaltiesViewPageAdapter adapter = new PenaltiesViewPageAdapter(getSupportFragmentManager(), this, searchPaidResults, searchUnpaidResults);
        viewPager.setAdapter(adapter);

        tabLayout = (TabLayout) findViewById(R.id.tabs_penalties);
        tabLayout.setupWithViewPager(viewPager);
    }
}
