package com.example.assignment1worldclock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


public class MainActivity extends AppCompatActivity {

    TextView sydneyTime;
    TextView shanghaiTime;
    TextView torontoTime;
    TextView londonTime;
    TextView newDelhiTime;
    TextView istanbulTime;
    TextView parisTime;
    Button refresh;
    Switch switch1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sydneyTime = findViewById(R.id.sydneyTime);
        shanghaiTime = findViewById(R.id.shanghaiTime);
        torontoTime = findViewById(R.id.torontoTime);
        londonTime = findViewById(R.id.londonTime);
        parisTime = findViewById(R.id.parisTime);
        istanbulTime = findViewById(R.id.istanbulTime);
        newDelhiTime = findViewById(R.id.newDelhiTime);



        refresh12Time("Australia/Sydney", sydneyTime);
        refresh12Time("Asia/Shanghai", shanghaiTime);
        refresh12Time("America/Toronto", torontoTime);
        refresh12Time("Europe/London", londonTime);
        refresh12Time("Europe/Amsterdam", newDelhiTime);
        refresh12Time("Europe/Istanbul", istanbulTime);
        refresh12Time("Europe/Istanbul", parisTime);
        switch1 = findViewById(R.id.switch1);
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    refresh24Time("Australia/Sydney", sydneyTime);
                    refresh24Time("Asia/Shanghai", shanghaiTime);
                    refresh24Time("Europe/London", londonTime);
                    refresh24Time("Europe/Amsterdam", newDelhiTime);
                    refresh24Time("America/Toronto", torontoTime);
                    refresh24Time("Europe/Istanbul", istanbulTime);
                    refresh24Time("Europe/Paris", parisTime);
                    switch1.setText("24HR");
                } else {
                    refresh12Time("Australia/Sydney", sydneyTime);
                    refresh12Time("Asia/Shanghai", shanghaiTime);
                    refresh12Time("America/Toronto", torontoTime);
                    refresh12Time("Europe/London", londonTime);
                    refresh12Time("Europe/Amsterdam", newDelhiTime);
                    refresh12Time("Europe/Istanbul", istanbulTime);
                    refresh12Time("Europe/Paris", parisTime);
                    switch1.setText("12HR");
                }
            }
        });

        refresh = findViewById(R.id.refresh);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refresh12Time("Australia/Sydney", sydneyTime);
                refresh12Time("Asia/Shanghai", shanghaiTime);
                refresh12Time("America/Toronto", torontoTime);
                refresh12Time("Europe/London", londonTime);
                refresh12Time("Europe/Amsterdam", newDelhiTime);
                refresh12Time("Europe/Istanbul", istanbulTime);
                refresh12Time("Europe/Paris", parisTime);
            }
        });
    }

    public void refresh12Time(String tz, TextView city) {
        Date date = new Date();
        TimeZone timezone = TimeZone.getTimeZone(tz);
        SimpleDateFormat dateFormat = new SimpleDateFormat("h:mm a"); //12 hr format
        dateFormat.setTimeZone(timezone);
        String finalTime = dateFormat.format(date);
        city.setText(finalTime);
    }

    public void refresh24Time(String tz, TextView city) {
        Date date = new Date();
        TimeZone timezone = TimeZone.getTimeZone(tz);
        SimpleDateFormat dateFormat = new SimpleDateFormat("H:mm a"); //24 hr format
        dateFormat.setTimeZone(timezone);
        String finalTime = dateFormat.format(date);
        city.setText(finalTime);
    }
}


