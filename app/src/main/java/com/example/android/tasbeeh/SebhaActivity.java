package com.example.android.tasbeeh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SebhaActivity extends AppCompatActivity {

    TextView counterView;
    PrayerCounter prayerCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sebha);

        prayerCounter = new PrayerCounter("", 0);


        counterView = (TextView) findViewById(R.id.counter_text_view);
        Button increseCounter = (Button) findViewById(R.id.counter);
        Button reset = (Button) findViewById(R.id.reset);

        increseCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prayerCounter.count();
                counterView.setText(String.valueOf(prayerCounter.getCounter()));
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prayerCounter.reset();
                counterView.setText(String.valueOf(prayerCounter.getCounter()));
            }
        });

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current counter numbers
        savedInstanceState.putInt(counterView.getText().toString(), prayerCounter.getCounter());
        //savedInstanceState.putInt(STATE_LEVEL, mCurrentLevel);


        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }


}
