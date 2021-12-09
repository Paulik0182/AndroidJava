package com.android.androidandjava;

import android.util.Log;

public class EntityConstructor {

    private static final String TAG = "@@@EntityConstructor";

    private String title;
    private String detail;

    EntityConstructor(String title, String detail) {
        this.title = title;
        this.detail = detail;
    }

    public String getTitle() {
        Log.d ( TAG, "getTitle" );
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        Log.d ( TAG, "getDetail" );
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
