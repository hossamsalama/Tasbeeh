package com.example.android.tasbeeh;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set style for custo app toolbar
        TextView toolbarText = (TextView) findViewById(R.id.toolbar_title);
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/mj-king-1.ttf");
        toolbarText.setTypeface(custom_font);


        Button sebha = (Button) findViewById(R.id.sebha);
        sebha.setTypeface(custom_font);

        sebha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sebhaIntent = new Intent(MainActivity.this, SebhaActivity.class);
                startActivity(sebhaIntent);
            }
        });


        Button share = (Button) findViewById(R.id.share);
        share.setTypeface(custom_font);

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "http://colorhunt.co/c/205D67");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });

        Button setting = (Button) findViewById(R.id.setting);
        setting.setTypeface(custom_font);

        Button zekrCounter = (Button) findViewById(R.id.zekr_counter);
        zekrCounter.setTypeface(custom_font);

        zekrCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent azkarCounterIntent = new Intent(MainActivity.this, AzkarActivity.class);
                startActivity(azkarCounterIntent);
            }
        });
    }
}
