package com.example.android.tasbeeh;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by hossam on 5/6/2017.
 * TasbeehAdapter created to view our custom layout for item (one button and one text view)
 */

public class TasbeehAdapter extends ArrayAdapter<PrayerCounter> {

    private int mColorResourceId;

    public TasbeehAdapter(Activity context, ArrayList<PrayerCounter> counters, int colorResourceId) {
        super(context, 0, counters);
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link PrayerCounter} object located at this position in the list
        final PrayerCounter prayerCounter = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID zekr_name
        TextView zekrTextView = (TextView) listItemView.findViewById(R.id.zekr_name);
        // Get zekr name  from the current PrayerCounter object and
        // set this text on the name TextView
        zekrTextView.setText(prayerCounter.getZekrName());

        // Find the button in the list_item.xml layout with the ID zekr_number
        final TextView zekrNumber = (TextView) listItemView.findViewById(R.id.zekr_number);

        zekrNumber.setText(String.valueOf(prayerCounter.getCounter()));
        zekrTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (prayerCounter.getCounter() == 0) {
                    Toast.makeText(getContext(), "لقد أتممت عدد التسبيح لهذا الذكر", Toast.LENGTH_SHORT).show();
                } else {
                    prayerCounter.countReverse();
                    zekrNumber.setText(String.valueOf(prayerCounter.getCounter()));
                }
            }
        });

        /// Set the theme color for the list item
        View zekrContainer = listItemView.findViewById(R.id.zekr_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        zekrContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews)
        // so that it can be shown in the ListView
        return listItemView;
    }

}
