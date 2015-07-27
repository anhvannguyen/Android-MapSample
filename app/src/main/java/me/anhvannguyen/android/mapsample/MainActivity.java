package me.anhvannguyen.android.mapsample;

import android.content.Intent;
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
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.HashMap;

import me.anhvannguyen.android.mapsample.model.Store;


public class MainActivity extends ActionBarActivity implements OnMapReadyCallback {
    private Button mSanJoseFlyToButton;
    private GoogleMap mGoogleMap;
    private boolean mMapReady = false;
    private boolean initMap = false;
    private MapFragment mMapFragment;
    private HashMap<String, Store> frysList = new HashMap<String, Store>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSanJoseFlyToButton = (Button) findViewById(R.id.bayarea_flyto_button);
        mSanJoseFlyToButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mMapReady) {
                    flyTo(Utility.BAY_AREA_CAMERA);
                }
            }
        });

        mMapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);

        if (savedInstanceState == null) {
            initMap = true;
        }
        mMapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMapReady = true;
        mGoogleMap = googleMap;
        if (initMap) {
            // Set the lat/long coordinates for the United States
            LatLng unitedStates = Utility.UNITED_STATES_COORD;
            // Set up the camera position
            CameraPosition target = CameraPosition.builder()
                    .target(unitedStates)
                    .zoom(3)
                    .build();
            // Move the camera to the camera position
            mGoogleMap.moveCamera(CameraUpdateFactory.newCameraPosition(target));
        }

        mGoogleMap.getUiSettings().setZoomControlsEnabled(true);
        updateMapType();

        addMarkers(mGoogleMap);
        mGoogleMap.setInfoWindowAdapter(new PopupAdapter(MainActivity.this, getLayoutInflater(), frysList));
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateMapType();
    }

    private void updateMapType() {
        int mapType = Utility.getMapPreference(MainActivity.this);
        setMapType(mapType);
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
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void flyTo(CameraPosition target)
    {
        mGoogleMap.animateCamera(CameraUpdateFactory.newCameraPosition(target), Utility.FLYBY_DURATION, null);
    }

    private void addMarkers(GoogleMap googleMap) {
        ArrayList<Store> frys = Utility.generateFrysList();

        for (Store fry : frys) {
            frysList.put(addMarkerForModel(googleMap, fry).getId(), fry);
        }
    }

    private Marker addMarkerForModel(GoogleMap googleMap, Store store) {
        LatLng position = store.getLatLng();

        return googleMap.addMarker(new MarkerOptions()
                .position(position)
                .title(store.getTitle())
                .snippet(store.getSnippet()));
    }

    private void setMapType(int mapType) {
        if (mGoogleMap != null) {
            switch (mapType) {
                case GoogleMap.MAP_TYPE_NORMAL:
                    mGoogleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                    break;
                case GoogleMap.MAP_TYPE_SATELLITE:
                    mGoogleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                    break;
                case GoogleMap.MAP_TYPE_HYBRID:
                    mGoogleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                    break;
                default:
                    mGoogleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            }
        }
    }
}
