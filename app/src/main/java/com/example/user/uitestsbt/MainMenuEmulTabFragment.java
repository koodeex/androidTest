package com.example.user.uitestsbt;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainMenuEmulTabFragment extends Fragment {

    int position;
    private TextView textView;
    private List<Button> mButtonsList;

    public static Fragment getInstance(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("pos", position);
        MainMenuEmulTabFragment mainMenuEmulTabFragment = new MainMenuEmulTabFragment();
        mainMenuEmulTabFragment.setArguments(bundle);
        return mainMenuEmulTabFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt("pos");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tab, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        textView = (TextView) view.findViewById(R.id.textView);
       // mButtonsList = (List<Button>) view.f
        textView.setText("Fragment " + (position + 1));

    }
}
