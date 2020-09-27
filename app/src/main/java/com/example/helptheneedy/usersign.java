package com.example.helptheneedy;

import androidx.appcompat.app.AppCompatActivity;

//import android.content.Intent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

//import java.util.ArrayList;
//import java.util.List;

public class usersign extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private Spinner spin;
    private Button signUp;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usersign);

        spin = (Spinner) findViewById(R.id.spin);
        signUp = (Button) findViewById(R.id.signupButton);
        login  = (Button) findViewById(R.id.loginButton);

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

    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}