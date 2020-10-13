package com.example.emran2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Main42Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main42 );
    }

    public void Show5005(View view) {
        Intent my = new Intent ( Main42Activity.this, Main45Activity.class );
        startActivity ( my );
    }

    public void search591(View view) {


            Intent my = new Intent ( Main42Activity.this, Main47Activity.class );
            startActivity ( my );

        }
    }