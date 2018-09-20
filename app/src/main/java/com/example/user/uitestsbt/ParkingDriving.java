package com.example.user.uitestsbt;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.opencsv.CSVWriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ParkingDriving extends AppCompatActivity {
    private CheckBox mCheckBox;
    private Button mSearchButton;
    private TextView mCardPlaceholder;
    private EditText mSTSTextBox;
    private EditText mWUTextBox;
    private Boolean alreadyCreated = false;
    private final Context context = this;
    Intent getID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_driving);

        mCheckBox = (CheckBox) findViewById(R.id.checkBoxSave);
        mSearchButton = (Button) findViewById(R.id.searchButton);
        mCardPlaceholder = (TextView) findViewById(R.id.cardTempPH);
        mSTSTextBox = (EditText) findViewById(R.id.stsEditText);
        mWUTextBox = (EditText) findViewById(R.id.wuEditText);
        getID = getIntent();
        final Intent search = new Intent(ParkingDriving.this, PenaltiesActivity.class);
        uploadSaved();

        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String[]> tmp = new ArrayList<>();
                if (mCheckBox.isChecked()) {
                    try {
                        String content = getID.getStringExtra("accId") + "," + mWUTextBox.getText().toString() + "," + mSTSTextBox.getText().toString();
                        File file = new File(context.getFilesDir() + "savedSettings" + ".csv");
                        // if file doesnt exists, then create it
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        else
                        {
                            CSVParse fileParser = new CSVParse(context, new FileReader(file));
                            tmp = fileParser.getParseResults();
                            //content+="\n";
                            int counter = 0;
                            String subResult = "";
                            for (String[] line: tmp) {
                                String lineTmp = "\n";
                                for (int i = 0; i < line.length-1; i++){
                                    lineTmp += line[i] + ",";
                                }
                                lineTmp+= line[line.length-1];

                                if (!content.equals(lineTmp)){
                                    subResult += lineTmp;
                                }
                            }
                            content += subResult;
                        }

                        FileWriter fw = new FileWriter(file.getAbsoluteFile());
                        BufferedWriter bw = new BufferedWriter(fw);

                        bw.write(content);
                        bw.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

//                    CSVWriter writer = new CSVWriter(new FileWriter(csv, true));
//
//                    String [] record = "3,David,Feezor,USA,40".split(",");
//
//                    writer.writeNext(record);
//
//                    writer.close();
                }
                search.putExtra("wuParams", mWUTextBox.getText().toString());
                search.putExtra("stsParams", mSTSTextBox.getText().toString());
                startActivity(search);
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        uploadSaved();


    }
    private void uploadSaved() {
        File savedSettings = new File(context.getFilesDir() +"savedSettings.csv");
        if (savedSettings.exists() && alreadyCreated == false) {
            try {

                CSVParse savedSettingsParser = new CSVParse(this, new FileReader(savedSettings));
                ArrayList<String[]> tmp = savedSettingsParser.getParseResults();
                for(String[] searchParams: tmp){
                    if(searchParams[0] == getID.getStringExtra("accId")) {
                        addTextView(searchParams);
                    }
                }
                alreadyCreated = true;

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    private void addTextView(String[] param) {
        LinearLayout main = (LinearLayout) findViewById(R.id.subLayout);
        TextView valueTV = new TextView(ParkingDriving.this);
        //valueTV.setWidth();
        String tmp = "";
        for (int i = 1; i < param.length; i++)
            tmp += param[i];
        valueTV.setText(tmp);

        main.addView(valueTV);
     //   textViewAdded = true;
    }

    private void addElement(){
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewGroup parent = (ViewGroup)findViewById(R.id.subLayout);
        inflater.inflate(R.layout.saved_settings_layout, parent);
    }
}
