package me.anhvannguyen.android.mapsample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;


public class MainActivity extends ActionBarActivity implements OnMapReadyCallback {
    private Button mMapButton;
    private Button mSatelliteButton;
    private Button mHybridButton;
    private GoogleMap mGoogleMap;
    private boolean mMapReady = false;
    private MapFragment mMapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMapButton = (Button) findViewById(R.id.button_map);
        mMapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mMapReady) {
                    mGoogleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                }
            }
        });

        mSatelliteButton = (Button) findViewById(R.id.button_satellite);
        mSatelliteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mMapReady) {
                    mGoogleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                }
            }
        });

        mHybridButton = (Button) findViewById(R.id.button_hybrid);
        mHybridButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mMapReady) {
                    mGoogleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                }
            }
        });

        mMapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mMapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMapReady = true;
        mGoogleMap = googleMap;
        // Set the lat/long coordinates for the United States
        LatLng unitedStates = new LatLng(39.320401, -98.521445);
        // Set up the camera position
        CameraPosition target = CameraPosition.builder()
                .target(unitedStates)
                .zoom(3)
                .build();
        // Set up the initial map view type
        mGoogleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        // Move the camera to the camera position
        mGoogleMap.moveCamera(CameraUpdateFactory.newCameraPosition(target));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
