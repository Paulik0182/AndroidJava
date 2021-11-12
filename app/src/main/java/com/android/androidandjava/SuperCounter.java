package com.android.androidandjava;

import android.os.Parcel;
import android.os.Parcelable;

public class SuperCounter implements Parcelable {

    public static final Creator<SuperCounter> CREATOR = new Creator<SuperCounter> () {
        @Override
        public SuperCounter createFromParcel(Parcel in) {
            return new SuperCounter ( in );
        }

        @Override
        public SuperCounter[] newArray(int size) {
            return new SuperCounter[size];
        }
    };
    private final String name;//
    private int counter = 0;//

    public SuperCounter(String name, int startCounter) {//конструктор
        this.name = name;
        counter = startCounter;
    }

    protected SuperCounter(Parcel in) {
        counter = in.readInt ();
        name = in.readString ();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt ( counter );
        dest.writeString ( name );
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public void increment() {
        counter++;
    }

    public void decrement() {
        counter--;
    }

    public int getCounter() {
        return counter;
    }

    public String getName() {
        return name;
    }
}
