package com.example.locationtest;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;

    // Define the Google Maps URL
    String googleMapsUrl = "https://goo.gl/maps/UowJCb86PU93kRhi8";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(),"Button clicked",Toast.LENGTH_LONG).show();
                OpenGoogleMapandShowRout(googleMapsUrl);
            }
        });
    }

    private void OpenGoogleMapandShowRout(String googleMapURL){
        // Create an Intent with the ACTION_VIEW action and the Google Maps URL
        Uri gmmIntentUri = Uri.parse("google.navigation:q=" + googleMapURL);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);

        // Set the package for the Google Maps app (you can use "com.google.android.apps.maps" for Google Maps)
        mapIntent.setPackage("com.google.android.apps.maps");

        // Check if there's a Google Maps app installed on the device
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            // Open Google Maps with directions
            startActivity(mapIntent);
        } else {
            // If Google Maps app is not installed, you can handle it here (e.g., open a web browser)
            // For example, you can open the URL in a web browser:
            Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(googleMapURL));
            startActivity(webIntent);
        }
    }
}