package com.example.helptheneedy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

//import android.content.Intent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

//import java.util.ArrayList;
//import java.util.List;

public class usersign extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseUser mUser;
    private Spinner spin;
    private Button signUp;
    private Button login;
    private TextView email;
    private TextView password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usersign);
        mAuth = FirebaseAuth.getInstance();

        spin = (Spinner) findViewById(R.id.spin);
        signUp = (Button) findViewById(R.id.signupButton);
        login  = (Button) findViewById(R.id.loginButton);
        email = (TextView) findViewById(R.id.editTextTextEmailAddress2);
        password = (TextView) findViewById(R.id.editTextTextPassword2);

       /* List<String> cities = new ArrayList<String>();
        cities.add("Bhopal");
        cities.add("Indore");
        cities.add("Ujjain");*/

        spin.setOnItemSelectedListener(this);

        //ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cities);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.cities, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(usersign.this, "Registered Succeessfully!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(usersign.this, homePage.class);
                startActivity(intent);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(usersign.this,MainActivity.class);
                startActivity(intent);
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailString = email.getText().toString();
                String pwd = password.getText().toString();

                if(!emailString.equals("") && !pwd.equals("")){
                    mAuth.createUserWithEmailAndPassword(emailString,pwd).addOnCompleteListener(usersign.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(usersign.this, "Failed to create Account!", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(usersign.this, "Account Created", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }


            }
        });

    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}