package me.anhvannguyen.android.mapsample;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

/**
 * Created by anhvannguyen on 7/25/15.
 */
public class PopupAdapter implements GoogleMap.InfoWindowAdapter {
    private View mPopup = null;
    private LayoutInflater mInflater = null;

    PopupAdapter(LayoutInflater inflater) {
        mInflater = inflater;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        if (mPopup == null) {
            mPopup = mInflater.inflate(R.layout.marker_popup, null);
        }

        TextView titleTextView = (TextView) mPopup.findViewById(R.id.popup_title);
        titleTextView.setText(marker.getTitle());

        TextView snippetTextView = (TextView) mPopup.findViewById(R.id.popup_snippet);
        snippetTextView.setText(marker.getSnippet());

        return mPopup;
    }
}
