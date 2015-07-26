package me.anhvannguyen.android.mapsample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

import me.anhvannguyen.android.mapsample.model.Store;

/**
 * Created by anhvannguyen on 7/25/15.
 */
public class PopupAdapter implements GoogleMap.InfoWindowAdapter {
    private View mPopup = null;
    private Context mContext = null;
    private LayoutInflater mInflater = null;
    private HashMap<String, Store> mStore = null;

    public PopupAdapter(LayoutInflater inflater) {
        mInflater = inflater;
    }

    public PopupAdapter(Context context, LayoutInflater inflater, HashMap<String, Store> store) {
        mContext = context;
        mInflater = inflater;
        mStore = store;
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

        ImageView popupImage = (ImageView) mPopup.findViewById(R.id.popup_imageview);
        Picasso.with(mContext)
                .load(mStore.get(marker.getId()).getImagePath())
                .placeholder(R.mipmap.ic_launcher)
                .resize(100, 100)
                .noFade()
                .into(popupImage);

        TextView titleTextView = (TextView) mPopup.findViewById(R.id.popup_title);
        titleTextView.setText(mStore.get(marker.getId()).getTitle());

        TextView snippetTextView = (TextView) mPopup.findViewById(R.id.popup_snippet);
        snippetTextView.setText(mStore.get(marker.getId()).getSnippet());

        return mPopup;
    }
}
