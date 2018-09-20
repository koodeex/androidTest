package com.example.user.uitestsbt;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PenaltiesPaidTabFragment extends Fragment{
    int position;
    private TextView textView;
    private List<Button> mButtonsList;
    private static Context context;
    private static ArrayList<String[]> paidPenaltiesList;
    private static ArrayList<String> resultPenalties = new ArrayList<>();
    private static boolean listIsEmpty = false;

    public static Fragment getInstance(int position, ArrayList<String[]> paidPenaltiesListtmp, Context context) {
        Bundle bundle = new Bundle();
        bundle.putInt("pos", position);
        PenaltiesPaidTabFragment penaltiesPaidTabFragment = new PenaltiesPaidTabFragment();
        setPenaltiesPaidTabFragment(paidPenaltiesListtmp);
        if (paidPenaltiesList.size() == 0) listIsEmpty = true;
        else {
            for (String[] penalty: paidPenaltiesList) {
                String tmp = "";
                for (int i = 0; i < penalty.length - 1; i++)
                {
                    tmp += (penalty[i] + " ");
                }
                resultPenalties.add(tmp);
            }
            listIsEmpty = false;
        }
        setContext(context);
        penaltiesPaidTabFragment.setArguments(bundle);

        return penaltiesPaidTabFragment;
    }

    public static void setPenaltiesPaidTabFragment(ArrayList<String[]> paidPenaltiesListGot) {
        paidPenaltiesList = paidPenaltiesListGot;
    }
    public static void setContext(Context contextGot) {
        context = contextGot;
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

    try {
        View v = inflater.inflate(R.layout.penalty_paid_fragment_tab, container, false);
        perform(v);

        return v;
    }
    catch (NullPointerException e) {
        return inflater.inflate(R.layout.fragment_tab, container, false);

    }

    }
    ListView lv;

    public void perform(View v) {
        if (resultPenalties.size() == 0) throw new NullPointerException("Empty List");
        lv = (ListView)v.findViewById(R.id.penaltiesPaidList);
        String[] temp = new String[resultPenalties.size()];

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, resultPenalties.toArray(temp));
        lv.setAdapter(adapter);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (listIsEmpty) {

            textView = (TextView) view.findViewById(R.id.textView);
//        // mButtonsList = (List<Button>) view.f
            textView.setText("Your list is empty");
        }

    }

}
