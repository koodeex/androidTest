package com.example.user.uitestsbt;

import android.content.Context;
import android.os.Environment;
import android.widget.Toast;


import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVParse {
    private ArrayList<String[]> parseResults = new ArrayList<>();


    public CSVParse(Context context, InputStreamReader csv) {
        try{


            CSVReader reader = new CSVReader(csv);
            String [] nextLine;

            while ((nextLine = reader.readNext()) != null) {
                // nextLine[] is an array of values from the line
                for (int i = 0; i < nextLine.length; i++) {
                    System.out.println(nextLine[i].toString() + " ");
                }
                parseResults.add(nextLine);

            }

        }catch(Exception e){
            e.printStackTrace();
            Toast.makeText(context, "The specified file was not found", Toast.LENGTH_SHORT).show();
        }
    }

    public ArrayList<String[]> getParseResults() {
        return parseResults;
    }


}
