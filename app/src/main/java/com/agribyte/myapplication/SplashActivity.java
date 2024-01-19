package com.agribyte.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                FirebaseAuth autho=FirebaseAuth.getInstance();
               FirebaseUser user= autho.getCurrentUser();
//               if(user!=null){
//                   Intent i = new Intent(getApplicationContext(), BottombarActivity.class) ;
//                   startActivity(i);
//                   SplashActivity.this.finish();
//               }else{
//                   Intent i = new Intent(getApplicationContext(), LoginActivity.class) ;
//                   startActivity(i);
//                   SplashActivity.this.finish();
//               }

            }
        },5000);


    }
}