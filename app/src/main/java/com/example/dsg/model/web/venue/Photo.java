
package com.example.dsg.model.web.venue;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Photo implements Parcelable {

    @SerializedName("photoId") private String photoId;
    @SerializedName("createdAt") private Integer createdAt;
    @SerializedName("url") private String url;

    public Photo() {
    }

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }

    public Integer getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Integer createdAt) {
        this.createdAt = createdAt;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override public String toString() {
        return "Photo{" +
                "photoId='" + photoId + '\'' +
                ", createdAt=" + createdAt +
                ", url='" + url + '\'' +
                '}';
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Photo photo = (Photo) o;

        if (photoId != null ? !photoId.equals(photo.photoId) : photo.photoId != null) return false;
        if (createdAt != null ? !createdAt.equals(photo.createdAt) : photo.createdAt != null)
            return false;
        return url != null ? url.equals(photo.url) : photo.url == null;
    }

    @Override public int hashCode() {
        int result = photoId != null ? photoId.hashCode() : 0;
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }


    @Override public int describeContents() {
        return 0;
    }

    @Override public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.photoId);
        dest.writeValue(this.createdAt);
        dest.writeString(this.url);
    }

    protected Photo(Parcel in) {
        this.photoId = in.readString();
        this.createdAt = (Integer) in.readValue(Integer.class.getClassLoader());
        this.url = in.readString();
    }

    public static final Creator<Photo> CREATOR = new Creator<Photo>() {
        @Override public Photo createFromParcel(Parcel source) {
            return new Photo(source);
        }

        @Override public Photo[] newArray(int size) {
            return new Photo[size];
        }
    };
}
