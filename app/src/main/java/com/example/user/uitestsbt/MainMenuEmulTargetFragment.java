package com.example.user.uitestsbt;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainMenuEmulTargetFragment extends Fragment {

    int position;
    private TextView textView;
    private List<Button> mButtonsList;
    static Context context;
    static String[] fakeButtonsText ;

    public static Fragment getInstance(int position, Context context) {
        Bundle bundle = new Bundle();
        bundle.putInt("pos", position);
        MainMenuEmulTargetFragment targFragment = new MainMenuEmulTargetFragment();
        setContext(context);
        targFragment.setArguments(bundle);
        return targFragment;
    }
//    public MainMenuEmulTargetFragment(Context context) {
//        this.context = context;
//        fakeButtonsText = context.getResources().getStringArray(R.array.fakeButtons);
//    }

    public static void setContext(Context contextGot){
        context = contextGot;
        fakeButtonsText = context.getResources().getStringArray(R.array.fakeButtons);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt("pos");
        context = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fake_buttons, container, false);
        perform(v);

        return v;
    }
    ListView lv;

    public void perform(View v) {
        lv = (ListView)v.findViewById(R.id.fakeButtonList);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, fakeButtonsText);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (lv.getItemAtPosition(i).toString().equals("SBER real button")) {
                    Intent DoubleChoiceActivity = new Intent(context, com.example.user.uitestsbt.DoubleChoiceActivity.class);
                    startActivity(DoubleChoiceActivity);
                }
            }
        });
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


//        textView = (TextView) view.findViewById(R.id.textView);
//        // mButtonsList = (List<Button>) view.f
//        textView.setText("Fragment " + (position + 1));

    }
}