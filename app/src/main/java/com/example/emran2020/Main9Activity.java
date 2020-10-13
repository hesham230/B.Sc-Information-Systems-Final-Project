package com.example.emran2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;

public class Main9Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main9 );

    }

    public void ShowAllPatients(View view) {
        Intent my =new Intent ( Main9Activity.this , Main8Activity.class );
        startActivity ( my );
    }


    public void AddPateints(View view) {
        Intent my =new Intent ( Main9Activity.this , Main12Activity.class );
        startActivity ( my );
    }

    public void DeletePatients(View view) {
        Intent my =new Intent ( Main9Activity.this , Main13Activity.class );
        startActivity ( my );
    }

    public void UpdatePatients(View view) {
        Intent my =new Intent ( Main9Activity.this , Main14Activity.class );
        startActivity ( my );
    }

    public void SearchPatients(View view){
        Intent my =new Intent ( Main9Activity.this , Main10Activity.class );
        startActivity ( my );

    }
}




