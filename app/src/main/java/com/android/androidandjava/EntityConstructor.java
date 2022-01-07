package com.android.androidandjava;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class EntityConstructor implements Parcelable {

    private static final String TAG = "@@@EntityConstructor";

    private String uid;// id - обязателен для EntityDiffUtils
    private String title;
    private String detail;

//    EntityConstructor(String title, String detail) {
//        this.title = title;
//        this.detail = detail;
//    }

    EntityConstructor(String uid, String title, String detail) {
        this.uid = uid;
        this.title = title;
        this.detail = detail;
    }

    public static final Creator<EntityConstructor> CREATOR = new Creator<EntityConstructor> () {
        @Override
        public EntityConstructor createFromParcel(Parcel in) {
            return new EntityConstructor ( in );
        }

        @Override
        public EntityConstructor[] newArray(int size) {
            return new EntityConstructor[size];
        }
    };

    protected EntityConstructor(Parcel in) {
        title = in.readString ();
        detail = in.readString ();
    }

    public String getUid() {
        return uid;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString ( title );
        dest.writeString ( detail );
    }
}
