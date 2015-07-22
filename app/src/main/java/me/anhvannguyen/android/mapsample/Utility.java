package me.anhvannguyen.android.mapsample;

import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by anhvannguyen on 7/22/15.
 */
public final class Utility {
    public static final LatLng UNITED_STATES_COORD = new LatLng(39.320401, -98.521445);
    public static final LatLng LONDON_UK_COORD = new LatLng(51.504800, -0.127320);
    public static final LatLng TOYKO_JAPAN_COORD = new LatLng(35.6895,139.6917);
    public static final LatLng SAN_JOSE_USA_COORD = new LatLng(37.329782, -121.891569);


    public static final CameraPosition SAN_JOSE_CAMERA = CameraPosition.builder()
            .target(SAN_JOSE_USA_COORD)
            .zoom(17)
            .bearing(0)
            .tilt(45)
            .build();

    public static final CameraPosition LONDON_CAMERA = CameraPosition.builder()
            .target(LONDON_UK_COORD)
            .zoom(17)
            .bearing(90)
            .tilt(45)
            .build();


    public static final CameraPosition TOKYO_CAMERA = CameraPosition.builder()
            .target(TOYKO_JAPAN_COORD)
            .zoom(17)
            .bearing(90)
            .tilt(45)
            .build();

}
