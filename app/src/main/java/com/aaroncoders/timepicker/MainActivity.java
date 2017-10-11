package com.aaroncoders.timepicker;

import java.util.Calendar;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        tv = (TextView) findViewById(R.id.textView);
    }

    public void show(View v){
        Calendar c = Calendar.getInstance();
        int hr = c.get(Calendar.HOUR_OF_DAY);
        final int min = c.get(Calendar.MINUTE);

        TimePickerDialog tpd = new TimePickerDialog(this, TimePickerDialog.THEME_DEVICE_DEFAULT_DARK, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                if(hourOfDay>12){
                    hourOfDay = hourOfDay-12;
                    tv.setText(hourOfDay+" : " + minute + " PM");
                }else {
                    tv.setText(hourOfDay + " : " + minute + " AM");
                }
            }
        },hr,min,true);
        tpd.show();
    }
}
