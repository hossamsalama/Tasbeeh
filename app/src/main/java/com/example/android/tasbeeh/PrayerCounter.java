package com.example.android.tasbeeh;

/**
 * Created by hossam on 5/6/2017.
 * PrayerCounter class has one state counter represent number of tasbeeh user has counted.
 */

public class PrayerCounter {

    private int counter;
    private String zekrName;

    public PrayerCounter(String zekr) {
        zekrName = zekr;
    }

    public PrayerCounter(String zekr, int zekrCounter) {
        zekrName = zekr;
        counter = zekrCounter;
    }

    public void count() {
        counter += 1;
    }

    public void countReverse() {
        counter -= 1;
    }

    public void reset() {
        counter = 0;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int c) {
        counter = c;
    }

    public String getZekrName() {
        return zekrName;
    }

    public void setZekrName(String customZekr) {
        zekrName = customZekr;
    }
}
