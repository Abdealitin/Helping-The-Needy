package com.example.helptheneedy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseUser mUser;
    private TextView emailField;
    private TextView password;
    private Button btnsign;
    private Button btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                mUser = firebaseAuth.getCurrentUser();
                if(mUser != null){
                    Toast.makeText(MainActivity.this, "Signed In", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this, "Not Signed In", Toast.LENGTH_LONG).show();
                }
            }
        };

        emailField =(TextView) findViewById(R.id.editTextTextEmailAddress);
        password =(TextView) findViewById(R.id.editTextTextPassword);
        btnsign =(Button)findViewById(R.id.signpage);
        btnsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
        btnlogin =(Button)findViewById(R.id.button);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(emailField.getText().toString()) && !TextUtils.isEmpty(password.getText().toString())){

                    String email = emailField.getText().toString();
                    String pwd = password.getText().toString();
                    login(email, pwd);
                    openActivity1();
                }else{

                }
                openActivity1();
            }
        });
    }

    private void login(String email, String pwd) {
        System.out.println("Hello");
    }

    public void openActivity2(){
        Intent intent = new Intent(this,usersign.class);
        startActivity(intent);
    }
    public void openActivity1(){
        Intent intent = new Intent(this,homePage.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }
}