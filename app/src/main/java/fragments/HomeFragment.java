package fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.agribyte.myapplication.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;


public class HomeFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;
    View view;
    public void MapFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view = inflater.inflate ( R.layout.homescreen, container, false );


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager ()
                .findFragmentById ( R.id.map );
        if ( mapFragment == null ) {
            mapFragment = SupportMapFragment.newInstance ();
            getChildFragmentManager ().beginTransaction ().replace ( R.id.map, mapFragment ).commit ();
        }
        mapFragment.getMapAsync ( this );


        return view;


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
//        MarkerOptions markerOptions = new MarkerOptions ()
//                .position ( new LatLng ( 18.234384356181025, 75.68811859935522 ) )  // Example coordinates
//                .title ( "Bhagvanta Temple ,Barshi." );

 //       Marker marker = googleMap.addMarker ( markerOptions );

        // Set a custom info window adapter to handle the click event
        googleMap.setOnInfoWindowClickListener ( new GoogleMap.OnInfoWindowClickListener () {
            @Override
            public void onInfoWindowClick(Marker marker) {


                // Retrieve the tag value
//                String tagValue = (String) marker.getTag();
//                Toast.makeText (getActivity (), tagValue, Toast.LENGTH_SHORT ).show ();
//                Intent intent = new Intent(getActivity(), PlaceDetailsActivity.class);
//                intent.putExtra("markerTag", tagValue);
//                startActivity(intent);
            }
        } );
     //   getdata ( "Locationdetails" );
    }


    // Add a marker in a specific location and move the camera
//        LatLng location = new LatLng (37.7749, -122.4194); // Replace with the desired coordinates
//        mMap.addMarker(new MarkerOptions ().position(location).title("Marker Title"));
//        mMap.moveCamera( CameraUpdateFactory.newLatLng(location));
//        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location, 12.0f));

//    public void getdata(String url) {
//        System.out.println ( "-------------" + url );
//
//        try {
//
//            ArrayList<Locationdetails> requestlist = new ArrayList<> ();
//           // pb.setVisibility ( View.VISIBLE );
//            //
//            FirebaseDatabase mFirebaseInstance = FirebaseDatabase.getInstance ();
//            DatabaseReference mFirebaseDatabase = mFirebaseInstance.getReference ( url );
//            mFirebaseDatabase.keepSynced ( true );
//            mFirebaseDatabase.addListenerForSingleValueEvent ( new ValueEventListener () {
//                @Override
//                public void onDataChange(DataSnapshot dataSnapshot) {
//                   // System.out.println ( "is req----------------" + dataSnapshot.toString () );
//
//                    for (DataSnapshot locationobj : dataSnapshot.getChildren ()) {
//                        System.out.println ( "is key key----------------" + locationobj.getKey () );
//
//                        HashMap<String, Object> yourData = (HashMap<String, Object>) locationobj.getValue ();
//
//                        Locationdetails sendSportReq = new Locationdetails ();
//
//                        double lati= (double) yourData.get ( "latitude");
//                        double longitude= (double) yourData.get ( "longitude");
//                        String lname= (String) yourData.get ( "loctionname");
//
//
//                        LatLng location = new LatLng(lati, longitude); // Replace with the desired coordinates
//                        Marker marker = mMap.addMarker(new MarkerOptions().position(location).title(lname));
//
//// Set a tag for the marker
//                        String tagValue = locationobj.getKey (); // Replace with your desired tag value
//                        marker.setTag(tagValue);
//
//                    }
//
//
//
//                }
//
//                @Override
//                public void onCancelled(DatabaseError error) {
//
//
//                }
//            } );
//        } catch (Exception e) {
//            e.printStackTrace ();
//        }
//    }
}


