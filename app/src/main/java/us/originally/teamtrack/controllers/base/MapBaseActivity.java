package us.originally.teamtrack.controllers.base;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.LatLng;
import com.lorem_ipsum.activities.BaseActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;
import us.originally.teamtrack.R;

/**
 * Created by VietHoa on 09/09/15.
 */
public abstract class MapBaseActivity extends BaseActivity {
    protected GoogleMap map;

    @InjectView(R.id.mapview)
    protected MapView mapView;

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        mapView.onPause();
        super.onPause();
    }

    @Override
    public void onDestroy() {
        mapView.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    protected abstract void setContentView();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView();

        ButterKnife.inject(this);
        initialiseMap(savedInstanceState);
    }

    protected void initialiseMap(Bundle savedInstanceState) {
        mapView.onCreate(savedInstanceState);

        // Gets to GoogleMap from the MapView and does initialization stuff
        map = mapView.getMap();
        map.getUiSettings().setMyLocationButtonEnabled(false);
        map.setMyLocationEnabled(true);

        // Needs to call MapsInitializer before doing any CameraUpdateFactory calls
        MapsInitializer.initialize(this);
    }

    protected void takeLocationWithCamera(double lat, double lng) {
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(lat, lng), 15);
        map.animateCamera(cameraUpdate);
    }


}