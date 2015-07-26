package me.anhvannguyen.android.mapsample.model;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by anhvannguyen on 7/25/15.
 */
public class Store {
    String mTitle;
    String mSnippet;
    String mImagePath;
    double mLat;
    double mLong;

    public Store(String title, String snippet, String imagePath, double lat, double lng) {
        mTitle = title;
        mSnippet = snippet;
        mImagePath = imagePath;
        mLat = lat;
        mLong = lng;
    }

    public Store(String title, String snippet, String imagePath, LatLng latlng) {
        mTitle = title;
        mSnippet = snippet;
        mImagePath = imagePath;
        mLat = latlng.latitude;
        mLong = latlng.longitude;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getSnippet() {
        return mSnippet;
    }

    public void setSnippet(String snippet) {
        mSnippet = snippet;
    }

    public String getImagePath() {
        return mImagePath;
    }

    public void setImagePath(String imagePath) {
        mImagePath = imagePath;
    }

    public double getLat() {
        return mLat;
    }

    public void setLat(double lat) {
        mLat = lat;
    }

    public double getLong() {
        return mLong;
    }

    public void setLong(double aLong) {
        mLong = aLong;
    }

    public LatLng getLatLng() {
        return new LatLng(mLat, mLong);
    }
}
