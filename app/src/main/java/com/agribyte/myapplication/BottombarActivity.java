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

import fragments.HomeFragment;


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
           Intent i = new Intent ( BottombarActivity.this, AddItem.class );
            startActivity ( i );
         }
      } );
//loadfragment(new HomeFragment());
   }

   @Override
   protected void onResume() {
      super.onResume ();

   }

   @Override
   public boolean onNavigationItemSelected(@NonNull MenuItem item) {
      int itemId = item.getItemId();

      if (itemId == R.id.home) {
         Toast.makeText(BottombarActivity.this, "Home clicked", Toast.LENGTH_SHORT).show();
         loadfragment(new HomeFragment());
         return true;
      } else if (itemId == R.id.product) {
         Toast.makeText(BottombarActivity.this, "Food item clicked", Toast.LENGTH_SHORT).show();
         loadfragment(new productFragment());

         return true;
      } else if (itemId == R.id.profile) {
         Toast.makeText(BottombarActivity.this, "Profile Clicked", Toast.LENGTH_SHORT).show();
         loadfragment(new profileFragment());

         return true;
      } else if (itemId == R.id.aboutUs) {
         Toast.makeText(BottombarActivity.this, "About clicked", Toast.LENGTH_SHORT).show();
         loadfragment(new aboutFragment());

         return true;
      }

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




