
package com.example.dsg.model.web.venue;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Contact implements Parcelable {

    @SerializedName("phone") private String phone;
    @SerializedName("twitter") private String twitter;
    @SerializedName("facebook") private String facebook;
    @SerializedName("facebookName") private String facebookName;

    public Contact() {
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getFacebookName() {
        return facebookName;
    }

    public void setFacebookName(String facebookName) {
        this.facebookName = facebookName;
    }

    @Override public String toString() {
        return "Contact{" +
                "phone='" + phone + '\'' +
                ", twitter='" + twitter + '\'' +
                ", facebook='" + facebook + '\'' +
                ", facebookName='" + facebookName + '\'' +
                '}';
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (phone != null ? !phone.equals(contact.phone) : contact.phone != null) return false;
        if (twitter != null ? !twitter.equals(contact.twitter) : contact.twitter != null)
            return false;
        if (facebook != null ? !facebook.equals(contact.facebook) : contact.facebook != null)
            return false;
        return facebookName != null ? facebookName.equals(contact.facebookName) : contact.facebookName == null;
    }

    @Override public int hashCode() {
        int result = phone != null ? phone.hashCode() : 0;
        result = 31 * result + (twitter != null ? twitter.hashCode() : 0);
        result = 31 * result + (facebook != null ? facebook.hashCode() : 0);
        result = 31 * result + (facebookName != null ? facebookName.hashCode() : 0);
        return result;
    }


    @Override public int describeContents() {
        return 0;
    }

    @Override public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.phone);
        dest.writeString(this.twitter);
        dest.writeString(this.facebook);
        dest.writeString(this.facebookName);
    }

    protected Contact(Parcel in) {
        this.phone = in.readString();
        this.twitter = in.readString();
        this.facebook = in.readString();
        this.facebookName = in.readString();
    }

    public static final Creator<Contact> CREATOR = new Creator<Contact>() {
        @Override public Contact createFromParcel(Parcel source) {
            return new Contact(source);
        }

        @Override public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };
}
