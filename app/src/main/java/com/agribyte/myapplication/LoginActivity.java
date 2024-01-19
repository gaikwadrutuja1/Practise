package com.agribyte.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
   FirebaseAuth mAuth = FirebaseAuth.getInstance();
    EditText edtusername, edtpassword;
    Button loginbtn;
    TextView createnewaccount;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login );
        edtusername = findViewById( R.id.username );
        edtpassword = findViewById( R.id.password );
        loginbtn = findViewById( R.id.loginbtn );
        createnewaccount=findViewById( R.id.createnewaccount );
        loginbtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=edtusername.getText().toString();
                String password=edtpassword.getText().toString();
                signInWithEmail(username,password);
            }
        } );
createnewaccount.setOnClickListener( new View.OnClickListener() {
    @Override
    public void onClick(View view) {
//        Intent i=new Intent(LoginActivity.this,SignupActivity.class);
//        startActivity( i );

    }
} );
    }
    public void signInWithEmail(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
// Sign in success, update UI with the signed-in user's

                            String uid = mAuth.getCurrentUser().getUid();
                            Toast.makeText(LoginActivity.this, "Login Successfully ."+uid,
                                    Toast.LENGTH_SHORT).show();
//                            Intent i=new Intent(LoginActivity.this,BottombarActivity.class);
//                            startActivity( i );
//                            finish();
// Do something with the user
                        } else {
// If sign in fails, display a message to the user.
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
