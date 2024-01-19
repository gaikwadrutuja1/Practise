package com.agribyte.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


        import static android.content.ContentValues.TAG;



        import android.os.Bundle;
        import android.os.PersistableBundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

        import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;
        import androidx.appcompat.app.AppCompatActivity;

        import com.google.android.gms.maps.CameraUpdateFactory;
        import com.google.android.gms.maps.GoogleMap;
        import com.google.android.gms.maps.OnMapReadyCallback;
        import com.google.android.gms.maps.SupportMapFragment;
        import com.google.android.gms.maps.model.LatLng;
        import com.google.android.gms.maps.model.MarkerOptions;
        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.auth.FirebaseUser;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;

import fragments.HomeFragment;


public class AddItem extends BottombarActivity implements OnMapReadyCallback, GoogleMap.OnMapLongClickListener {
    private GoogleMap mMap;
    FirebaseAuth mAuth = FirebaseAuth.getInstance();


    EditText pname,description,address,quantity;
    Button post;
    LatLng finallatLng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView(R.layout.add_item);
        pname=findViewById ( R.id.productName );
        description=findViewById ( R.id.productDesc );
        post=findViewById ( R.id.post );
        address=findViewById ( R.id.add );
        quantity=findViewById ( R.id.quantity );


        post.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                ItemDetails itemDetails =new ItemDetails ();
                if(finallatLng !=null) {
                    FirebaseAuth autho=FirebaseAuth.getInstance();
                    FirebaseUser user= autho.getCurrentUser();

                    itemDetails.setUserId( user.getUid () );
                    String strproductname=pname.getText ().toString ();
                    String straddress=address.getText ().toString ();
                    String strproductdesc=description.getText ().toString ();
                    String quan = quantity.getText().toString();

                    itemDetails.setProductDesc( strproductname );
                    itemDetails.setAddress ( straddress );
                    itemDetails.setProductName ( strproductname );
                    itemDetails.setQuantity (quan);
                    itemDetails.setLatitude ( finallatLng.latitude );
                    itemDetails.setLongitude ( finallatLng.longitude );

                    DatabaseReference mdatabase= FirebaseDatabase.getInstance().getReference();
                    String uid=mdatabase.push ().getKey ();
                    mdatabase.child( "Locationdetails" ).child( uid ).setValue( itemDetails );
//
//                    Intent i = new Intent(AddItem.this, HomeFragment.class);
//                    startActivity(i);

                }
                else{
                    Toast.makeText ( AddItem.this,"Select location first",Toast.LENGTH_SHORT ).show ();


                }


            }
        } );




        // Initialize FusedLocationProviderClient


        // Set up click listener for the button




// Obtain the SupportMapFragment and get notified when the map is ready to beused.
        SupportMapFragment mapFragment = (SupportMapFragment)
                getSupportFragmentManager()
                        .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnMapLongClickListener( AddItem.this);
// Add a marker in Sydney and move the camera
        LatLng Barshi = new LatLng(18.2334, 75.6941);
        mMap.addMarker(new MarkerOptions().position(Barshi).title("Marker in Barshi"));
        mMap.moveCamera( CameraUpdateFactory.newLatLng(Barshi));
    }

    @Override
    public void onMapLongClick(@NonNull LatLng latLng) {
        finallatLng=latLng;
        mMap.addMarker(new MarkerOptions().position(latLng).title("Marker"));

        // Show a Toast message with the latitude and longitude
        String message = "Latitude: " + latLng.latitude + ", Longitude: " + latLng.longitude;
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}





