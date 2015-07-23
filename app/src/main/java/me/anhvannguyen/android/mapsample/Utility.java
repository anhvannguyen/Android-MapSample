package me.anhvannguyen.android.mapsample;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

/**
 * Created by anhvannguyen on 7/22/15.
 */
public final class Utility {
    public static final int FLYBY_DURATION = 10000;

    public static final LatLng UNITED_STATES_COORD = new LatLng(39.320401, -98.521445);
    public static final LatLng LONDON_UK_COORD = new LatLng(51.504800, -0.127320);
    public static final LatLng TOYKO_JAPAN_COORD = new LatLng(35.6895,139.6917);
    public static final LatLng SAN_JOSE_USA_COORD = new LatLng(37.329782, -121.891569);

    public static final LatLng FRYS_CAMPBELL = new LatLng(37.295598,-121.939573);
    public static final LatLng FRYS_FREMONT = new LatLng(37.517147,-121.943564);
    public static final LatLng FRYS_PALO_ALTO = new LatLng(37.424605,-122.136941);
    public static final LatLng FRYS_SAN_JOSE = new LatLng(37.381411,-121.908975);
    public static final LatLng FRYS_SUNNYVALE = new LatLng(37.382093,-122.001715);

    public static final LatLng GOOGLEPLEX_COORD = new LatLng(37.411413,-122.0708163);


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

    public static final CameraPosition GOOGLEPLEX_CAMERA = CameraPosition.builder()
            .target(GOOGLEPLEX_COORD)
            .zoom(16.0f)
            .bearing(90)
            .tilt(45)
            .build();

    public static ArrayList<MarkerOptions> getFrysMarker() {
        ArrayList<MarkerOptions> frysMarkerList = new ArrayList<MarkerOptions>();

        MarkerOptions frysCampbell = new MarkerOptions()
                .position(FRYS_CAMPBELL)
                .title("Fry's Campbell")
                .snippet("600 E. Hamilton Ave.\n" +
                        "Campbell, CA 95008");
        MarkerOptions frysFremont = new MarkerOptions()
                .position(FRYS_FREMONT)
                .title("Fry's Fremont")
                .snippet("43800 Osgood Rd.\n" +
                        "Fremont, CA 94539");
        MarkerOptions frysPaloAlto = new MarkerOptions()
                .position(FRYS_PALO_ALTO)
                .title("Fry's Palo Alto")
                .snippet("340 Portage Ave.\n" +
                        "Palo Alto, CA 94306");
        MarkerOptions frysSanJose = new MarkerOptions()
                .position(FRYS_SAN_JOSE)
                .title("Fry's San Jose")
                .snippet("550 E. Brokaw Rd.\n" +
                        "San Jose, CA 95112");
        MarkerOptions frysSunnyvale = new MarkerOptions()
                .position(FRYS_SUNNYVALE)
                .title("Fry's Sunnyvale")
                .snippet("1077 East Arques Ave.\n" +
                        "Sunnyvale, CA 94085");

        frysMarkerList.add(frysCampbell);
        frysMarkerList.add(frysFremont);
        frysMarkerList.add(frysPaloAlto);
        frysMarkerList.add(frysSanJose);
        frysMarkerList.add(frysSunnyvale);

        return frysMarkerList;
    }

    public static MarkerOptions getGooglePlexMarker() {
        return new MarkerOptions()
                .position(GOOGLEPLEX_COORD)
                .title("Googleplex")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));
    }
}
