package com.example.android.tasbeeh;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by hossam on 5/6/2017.
 */

public class PrayerAdapter extends FragmentPagerAdapter {

    /**
     * Context of the app
     */
    private Context mContext;

    /**
     * Create a new {@link PrayerAdapter} object.
     *
     * @param context is the context of the app
     * @param fm      is the fragment manager that will keep each fragment's state in the adapter
     *                across swipes.
     */
    public PrayerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new SabahFragment();
        } else if (position == 1) {
            return new MasaaFragment();
        } else {
            return new PrayerFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        if (position == 0) {
            return mContext.getString(R.string.sabah_tasbeeh);
        } else if (position == 1) {
            return mContext.getString(R.string.masaa_tasbeeh);
        } else {
            return mContext.getString(R.string.prayer_tasbeeh);
        }
    }
}


