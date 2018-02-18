
package com.example.dsg.model.web.venue;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Venue implements Parcelable {

    @SerializedName("id") private String id;
    @SerializedName("name") private String name;
    @SerializedName("verified") private Boolean verified;
    @SerializedName("url") private String url;
    @SerializedName("ratingColor") private String ratingColor;
    @SerializedName("ratingSignals") private Integer ratingSignals;
    @SerializedName("rating") private Double rating;
    @SerializedName("storeId") private String storeId;
    @SerializedName("location") private Location location;
    @SerializedName("contacts") private List<Contact> contacts = null;
    @SerializedName("photos") private List<Photo> photos = null;
    @SerializedName("canonicalUrl") private String canonicalUrl;
    @SerializedName("description") private String description;
    @SerializedName("shortUrl") private String shortUrl;
    @SerializedName("timeZone") private String timeZone;

    public Venue() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRatingColor() {
        return ratingColor;
    }

    public void setRatingColor(String ratingColor) {
        this.ratingColor = ratingColor;
    }

    public Integer getRatingSignals() {
        return ratingSignals;
    }

    public void setRatingSignals(Integer ratingSignals) {
        this.ratingSignals = ratingSignals;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public String getCanonicalUrl() {
        return canonicalUrl;
    }

    public void setCanonicalUrl(String canonicalUrl) {
        this.canonicalUrl = canonicalUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    @Override public String toString() {
        return "VenueDisplaybleItem{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", verified=" + verified +
                ", url='" + url + '\'' +
                ", ratingColor='" + ratingColor + '\'' +
                ", ratingSignals=" + ratingSignals +
                ", rating=" + rating +
                ", storeId='" + storeId + '\'' +
                ", location=" + location +
                ", contacts=" + contacts +
                ", photos=" + photos +
                ", canonicalUrl='" + canonicalUrl + '\'' +
                ", description='" + description + '\'' +
                ", shortUrl='" + shortUrl + '\'' +
                ", timeZone='" + timeZone + '\'' +
                '}';
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Venue venue = (Venue) o;

        if (id != null ? !id.equals(venue.id) : venue.id != null) return false;
        if (name != null ? !name.equals(venue.name) : venue.name != null) return false;
        if (verified != null ? !verified.equals(venue.verified) : venue.verified != null)
            return false;
        if (url != null ? !url.equals(venue.url) : venue.url != null) return false;
        if (ratingColor != null ? !ratingColor.equals(venue.ratingColor) : venue.ratingColor != null)
            return false;
        if (ratingSignals != null ? !ratingSignals.equals(venue.ratingSignals) : venue.ratingSignals != null)
            return false;
        if (rating != null ? !rating.equals(venue.rating) : venue.rating != null) return false;
        if (storeId != null ? !storeId.equals(venue.storeId) : venue.storeId != null) return false;
        if (location != null ? !location.equals(venue.location) : venue.location != null)
            return false;
        if (contacts != null ? !contacts.equals(venue.contacts) : venue.contacts != null)
            return false;
        if (photos != null ? !photos.equals(venue.photos) : venue.photos != null) return false;
        if (canonicalUrl != null ? !canonicalUrl.equals(venue.canonicalUrl) : venue.canonicalUrl != null)
            return false;
        if (description != null ? !description.equals(venue.description) : venue.description != null)
            return false;
        if (shortUrl != null ? !shortUrl.equals(venue.shortUrl) : venue.shortUrl != null)
            return false;
        return timeZone != null ? timeZone.equals(venue.timeZone) : venue.timeZone == null;
    }

    @Override public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (verified != null ? verified.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (ratingColor != null ? ratingColor.hashCode() : 0);
        result = 31 * result + (ratingSignals != null ? ratingSignals.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (storeId != null ? storeId.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (contacts != null ? contacts.hashCode() : 0);
        result = 31 * result + (photos != null ? photos.hashCode() : 0);
        result = 31 * result + (canonicalUrl != null ? canonicalUrl.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (shortUrl != null ? shortUrl.hashCode() : 0);
        result = 31 * result + (timeZone != null ? timeZone.hashCode() : 0);
        return result;
    }

    @Override public int describeContents() {
        return 0;
    }

    @Override public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeValue(this.verified);
        dest.writeString(this.url);
        dest.writeString(this.ratingColor);
        dest.writeValue(this.ratingSignals);
        dest.writeValue(this.rating);
        dest.writeString(this.storeId);
        dest.writeParcelable(this.location, flags);
        dest.writeList(this.contacts);
        dest.writeList(this.photos);
        dest.writeString(this.canonicalUrl);
        dest.writeString(this.description);
        dest.writeString(this.shortUrl);
        dest.writeString(this.timeZone);
    }

    protected Venue(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.verified = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.url = in.readString();
        this.ratingColor = in.readString();
        this.ratingSignals = (Integer) in.readValue(Integer.class.getClassLoader());
        this.rating = (Double) in.readValue(Double.class.getClassLoader());
        this.storeId = in.readString();
        this.location = in.readParcelable(Location.class.getClassLoader());
        this.contacts = new ArrayList<Contact>();
        in.readList(this.contacts, Contact.class.getClassLoader());
        this.photos = new ArrayList<Photo>();
        in.readList(this.photos, Photo.class.getClassLoader());
        this.canonicalUrl = in.readString();
        this.description = in.readString();
        this.shortUrl = in.readString();
        this.timeZone = in.readString();
    }

    public static final Creator<Venue> CREATOR = new Creator<Venue>() {
        @Override public Venue createFromParcel(Parcel source) {
            return new Venue(source);
        }

        @Override public Venue[] newArray(int size) {
            return new Venue[size];
        }
    };
}
