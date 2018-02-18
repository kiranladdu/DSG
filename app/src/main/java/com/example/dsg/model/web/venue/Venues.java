package com.example.dsg.model.web.venue;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Venues implements Parcelable {

    @SerializedName("venues") List<Venue> mVenues;

    public List<Venue> getmVenues() {
        return mVenues;
    }

    public void setmVenues(List<Venue> mVenues) {
        this.mVenues = mVenues;
    }

    @Override public String toString() {
        return "Venues{" +
                "mVenues=" + mVenues +
                '}';
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Venues venues = (Venues) o;

        return mVenues != null ? mVenues.equals(venues.mVenues) : venues.mVenues == null;
    }

    @Override public int hashCode() {
        return mVenues != null ? mVenues.hashCode() : 0;
    }


    @Override public int describeContents() {
        return 0;
    }

    @Override public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.mVenues);
    }

    public Venues() {
    }

    protected Venues(Parcel in) {
        this.mVenues = in.createTypedArrayList(Venue.CREATOR);
    }

    public static final Creator<Venues> CREATOR = new Creator<Venues>() {
        @Override public Venues createFromParcel(Parcel source) {
            return new Venues(source);
        }

        @Override public Venues[] newArray(int size) {
            return new Venues[size];
        }
    };
}
