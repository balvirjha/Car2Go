package com.car2go.balvier.car2go.service.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Balvier on 9/23/2017.
 */

public class Placemark implements Parcelable
{

    @SerializedName("address")
    @Expose
    public String address;
    @SerializedName("coordinates")
    @Expose
    public List<Float> coordinates = null;
    @SerializedName("engineType")
    @Expose
    public String engineType;
    @SerializedName("exterior")
    @Expose
    public String exterior;
    @SerializedName("fuel")
    @Expose
    public Integer fuel;
    @SerializedName("interior")
    @Expose
    public String interior;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("vin")
    @Expose
    public String vin;
    public final static Parcelable.Creator<Placemark> CREATOR = new Creator<Placemark>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Placemark createFromParcel(Parcel in) {
            Placemark instance = new Placemark();
            instance.address = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.coordinates, (java.lang.Float.class.getClassLoader()));
            instance.engineType = ((String) in.readValue((String.class.getClassLoader())));
            instance.exterior = ((String) in.readValue((String.class.getClassLoader())));
            instance.fuel = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.interior = ((String) in.readValue((String.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.vin = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Placemark[] newArray(int size) {
            return (new Placemark[size]);
        }

    }
            ;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Float> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Float> coordinates) {
        this.coordinates = coordinates;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getExterior() {
        return exterior;
    }

    public void setExterior(String exterior) {
        this.exterior = exterior;
    }

    public Integer getFuel() {
        return fuel;
    }

    public void setFuel(Integer fuel) {
        this.fuel = fuel;
    }

    public String getInterior() {
        return interior;
    }

    public void setInterior(String interior) {
        this.interior = interior;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(address);
        dest.writeList(coordinates);
        dest.writeValue(engineType);
        dest.writeValue(exterior);
        dest.writeValue(fuel);
        dest.writeValue(interior);
        dest.writeValue(name);
        dest.writeValue(vin);
    }

    public int describeContents() {
        return 0;
    }

}