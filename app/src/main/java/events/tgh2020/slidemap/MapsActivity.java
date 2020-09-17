package events.tgh2020.slidemap;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Calendar;

public class MapsActivity extends FragmentActivity implements GoogleMap.OnInfoWindowClickListener,OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng tokyo1 = new LatLng(35.642558, 139.71377);
        Marker self = mMap.addMarker(new MarkerOptions().position(tokyo1).title("ママ友１"));
        LatLng tokyo2 = new LatLng(35.642760, 139.71480);
        Marker friend1 = mMap.addMarker(new MarkerOptions().position(tokyo2).title("ママ友２"));
        LatLng tokyo3 = new LatLng(35.642962, 139.72383);
        Marker friend2 = mMap.addMarker(new MarkerOptions().position(tokyo3).title("ママ友３"));
        LatLng tokyo4 = new LatLng(35.643164, 139.71996);
        Marker friend3 = mMap.addMarker(new MarkerOptions().position(tokyo4).title("ママ友４"));
        LatLng tokyo5 = new LatLng(35.643366, 139.71089);
        Marker friend4 = mMap.addMarker(new MarkerOptions().position(tokyo5).title("ママ友５"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(tokyo1));
        mMap.setOnInfoWindowClickListener(this);
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        Intent intent = new Intent(this, CalendarActivity.class);
        startActivity(intent);


    }
}