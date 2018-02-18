package com.example.dsg.model.domain;

import android.os.Parcel;
import android.os.Parcelable;

public class VenueDisplaybleItem implements Parcelable {

    private String mId;
    private String mName;
    private String mUrl;
    private String mDisplayableAddress;
    private float mDistanceFromCurrentLocation;
    private String mPhotoUrl;
    private boolean mIsFavorite;

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    public String getmDisplayableAddress() {
        return mDisplayableAddress;
    }

    public void setmDisplayableAddress(String mDisplayableAddress) {
        this.mDisplayableAddress = mDisplayableAddress;
    }

    public float getmDistanceFromCurrentLocation() {
        return mDistanceFromCurrentLocation;
    }

    public void setmDistanceFromCurrentLocation(float mDistanceFromCurrentLocation) {
        this.mDistanceFromCurrentLocation = mDistanceFromCurrentLocation;
    }

    public String getmPhotoUrl() {
        return mPhotoUrl;
    }

    public void setmPhotoUrl(String mPhotoUrl) {
        this.mPhotoUrl = mPhotoUrl;
    }

    public boolean ismIsFavorite() {
        return mIsFavorite;
    }

    public void setmIsFavorite(boolean mIsFavorite) {
        this.mIsFavorite = mIsFavorite;
    }

    @Override public String toString() {
        return "VenueDisplaybleItem{" +
                "mId='" + mId + '\'' +
                ", mName='" + mName + '\'' +
                ", mUrl='" + mUrl + '\'' +
                ", mDisplayableAddress='" + mDisplayableAddress + '\'' +
                ", mDistanceFromCurrentLocation=" + mDistanceFromCurrentLocation +
                ", mPhotoUrl='" + mPhotoUrl + '\'' +
                ", mIsFavorite=" + mIsFavorite +
                '}';
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VenueDisplaybleItem that = (VenueDisplaybleItem) o;

        if (Double.compare(that.mDistanceFromCurrentLocation, mDistanceFromCurrentLocation) != 0)
            return false;
        if (mIsFavorite != that.mIsFavorite) return false;
        if (mId != null ? !mId.equals(that.mId) : that.mId != null) return false;
        if (mName != null ? !mName.equals(that.mName) : that.mName != null) return false;
        if (mUrl != null ? !mUrl.equals(that.mUrl) : that.mUrl != null) return false;
        if (mDisplayableAddress != null ? !mDisplayableAddress.equals(that.mDisplayableAddress) : that.mDisplayableAddress != null)
            return false;
        return mPhotoUrl != null ? mPhotoUrl.equals(that.mPhotoUrl) : that.mPhotoUrl == null;
    }

    @Override public int hashCode() {
        int result;
        long temp;
        result = mId != null ? mId.hashCode() : 0;
        result = 31 * result + (mName != null ? mName.hashCode() : 0);
        result = 31 * result + (mUrl != null ? mUrl.hashCode() : 0);
        result = 31 * result + (mDisplayableAddress != null ? mDisplayableAddress.hashCode() : 0);
        temp = Double.doubleToLongBits(mDistanceFromCurrentLocation);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (mPhotoUrl != null ? mPhotoUrl.hashCode() : 0);
        result = 31 * result + (mIsFavorite ? 1 : 0);
        return result;
    }

    public VenueDisplaybleItem() {
    }


    @Override public int describeContents() {
        return 0;
    }

    @Override public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mId);
        dest.writeString(this.mName);
        dest.writeString(this.mUrl);
        dest.writeString(this.mDisplayableAddress);
        dest.writeFloat(this.mDistanceFromCurrentLocation);
        dest.writeString(this.mPhotoUrl);
        dest.writeByte(this.mIsFavorite ? (byte) 1 : (byte) 0);
    }

    protected VenueDisplaybleItem(Parcel in) {
        this.mId = in.readString();
        this.mName = in.readString();
        this.mUrl = in.readString();
        this.mDisplayableAddress = in.readString();
        this.mDistanceFromCurrentLocation = in.readFloat();
        this.mPhotoUrl = in.readString();
        this.mIsFavorite = in.readByte() != 0;
    }

    public static final Creator<VenueDisplaybleItem> CREATOR = new Creator<VenueDisplaybleItem>() {
        @Override public VenueDisplaybleItem createFromParcel(Parcel source) {
            return new VenueDisplaybleItem(source);
        }

        @Override public VenueDisplaybleItem[] newArray(int size) {
            return new VenueDisplaybleItem[size];
        }
    };
}
