
package com.example.week4weekend.model.weather;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Wind implements Parcelable
{

    @SerializedName("speed")
    @Expose
    private Float speed;
    @SerializedName("deg")
    @Expose
    private Integer deg;
    @SerializedName("gust")
    @Expose
    private Float gust;
    public final static Creator<Wind> CREATOR = new Creator<Wind>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Wind createFromParcel(Parcel in) {
            return new Wind(in);
        }

        public Wind[] newArray(int size) {
            return (new Wind[size]);
        }

    }
    ;

    protected Wind(Parcel in) {
        this.speed = ((Float) in.readValue((Float.class.getClassLoader())));
        this.deg = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.gust = ((Float) in.readValue((Float.class.getClassLoader())));
    }

    public Wind() {
    }

    public Float getSpeed() {
        return speed;
    }

    public void setSpeed(Float speed) {
        this.speed = speed;
    }

    public Integer getDeg() {
        return deg;
    }

    public void setDeg(Integer deg) {
        this.deg = deg;
    }

    public Float getGust() {
        return gust;
    }

    public void setGust(Float gust) {
        this.gust = gust;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(speed);
        dest.writeValue(deg);
        dest.writeValue(gust);
    }

    public int describeContents() {
        return  0;
    }

}
