package com.agribyte.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;




public class BottombarActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
   BottomNavigationView bottomNavigationView;

   FloatingActionButton fab;


   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate ( savedInstanceState );
      setContentView ( R.layout.activity_bottombar );

      bottomNavigationView = findViewById ( R.id.bottomNavigationView );
      bottomNavigationView.setOnNavigationItemSelectedListener ( this );
      fab = findViewById ( R.id.add_fab );
      fab.setOnClickListener ( new View.OnClickListener () {
         @Override
         public void onClick(View view) {
//            Intent i = new Intent ( BottombarActivity.this, AddLocationActivity.class );
//            startActivity ( i );
         }
      } );

   }

   @Override
   protected void onResume() {
      super.onResume ();

   }

   @Override
   public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//      switch (item.getItemId ()) {
//         case R.id.home:
//            Toast.makeText ( BottombarActivity.this, "Home clicked", Toast.LENGTH_SHORT ).show ();
//            return true;
//
//
//         case R.id.ContactUs:
//
//            Toast.makeText ( BottombarActivity.this, "ContactUs clicked", Toast.LENGTH_SHORT ).show ();
//            return true;
//         case R.id.profile:
//            return true;
//         case R.id.aboutUs:
//            return true;
//      }

      return false;
   }

   public void loadfragment(Fragment fragment) {
      FragmentManager fm = getSupportFragmentManager ();
      fm.beginTransaction ().replace ( R.id.flFragment, fragment ).commit ();
   }

   @Override
   public void onPointerCaptureChanged(boolean hasCapture) {
      super.onPointerCaptureChanged ( hasCapture );
   }
}




