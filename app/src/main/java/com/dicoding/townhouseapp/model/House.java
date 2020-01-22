package com.dicoding.townhouseapp.model;

import android.os.Parcel;
import android.os.Parcelable;

public class House implements Parcelable {
    private String name;
    private String size;
    private String description;
    private String price;
    private int photo;

    protected House(Parcel in) {
        name = in.readString();
        size = in.readString();
        description = in.readString();
        price = in.readString();
        photo = in.readInt();
    }

    public static final Creator<House> CREATOR = new Creator<House>() {
        @Override
        public House createFromParcel(Parcel in) {
            return new House(in);
        }

        @Override
        public House[] newArray(int size) {
            return new House[size];
        }
    };

    public House() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.size);
        dest.writeString(this.description);
        dest.writeString(this.price);
        dest.writeInt(this.photo);
    }
}
