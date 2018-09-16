package com.example.user.uitestsbt;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class DoubleChoiceActivity extends ListActivity {
    Button mBillingSearch;
    Button mPaperSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //   setContentView(R.layout.activity_double_choice);



        // storing string resources into Array
        String[] service_options = getResources().getStringArray(R.array.serviceOptionsList);

        // Binding resources Array to ListAdapter
        this.setListAdapter(new ArrayAdapter<String>(this, R.layout.listview_options, R.id.label, service_options));

        ListView lv = getListView();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        Intent oneStuffActivity = new Intent(DoubleChoiceActivity.this, OneStuffActivity.class);
                        startActivity(oneStuffActivity);
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    default:
                        break;
                }

            }
        });
    }
}
