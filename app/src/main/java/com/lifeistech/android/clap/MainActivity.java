package com.lifeistech.android.clap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemSelectedListener {
    ImageButton button;
    Clap clapInstance;
    Spinner spinner;

    int repeat=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (ImageButton) findViewById(R.id.imgBtn);
        spinner = (Spinner) findViewById(R.id.spinner);

        String[] strArray = new String[5];
        String s = "";
        for (int i = 0; i < strArray.length; i++) {
            if (i < 3) {
                s += "パン";
                strArray[i]=s+"ッ！";
            }else{
                strArray[i]=i+"回";
            }
        }

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(arrayAdapter);
        clapInstance = new Clap(this.getApplicationContext());

        button.setOnClickListener(this);

        spinner.setOnItemSelectedListener(this);

    }
    @Override
    public void onClick(View v) {
        clapInstance.repeatPlay(repeat);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        repeat=position+1;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
