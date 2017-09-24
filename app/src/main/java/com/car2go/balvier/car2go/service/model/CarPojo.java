package com.car2go.balvier.car2go.service.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Balvier on 9/23/2017.
 */

public class CarPojo implements Parcelable {

    @SerializedName("placemarks")
    @Expose
    private List<Placemark> placemarks = null;
    public final static Parcelable.Creator<CarPojo> CREATOR = new Creator<CarPojo>() {


        @SuppressWarnings({
                "unchecked"
        })
        public CarPojo createFromParcel(Parcel in) {
            CarPojo instance = new CarPojo();
            in.readList(instance.placemarks, (Placemark.class.getClassLoader()));
            return instance;
        }

        public CarPojo[] newArray(int size) {
            return (new CarPojo[size]);
        }

    };

    public List<Placemark> getPlacemarks() {
        return placemarks;
    }

    public void setPlacemarks(List<Placemark> placemarks) {
        this.placemarks = placemarks;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(placemarks);
    }

    public int describeContents() {
        return 0;
    }

}


