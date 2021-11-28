package com.android.androidandjava;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class DossierEntity implements Parcelable {

    public String name;
    public String surname;
    public String email;

    @NonNull
    @Override
    public String toString() {
        return name + " " + surname + ", " + email;
    }

    public DossierEntity(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public static final Creator<DossierEntity> CREATOR = new Creator<DossierEntity> () {
        @Override
        public DossierEntity createFromParcel(Parcel in) {
            return new DossierEntity ( in );
        }

        @Override
        public DossierEntity[] newArray(int size) {
            return new DossierEntity[size];
        }
    };

    protected DossierEntity(Parcel in) {
        name = in.readString ();
        surname = in.readString ();
        email = in.readString ();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString ( name );
        dest.writeString ( surname );
        dest.writeString ( email );
    }
}
