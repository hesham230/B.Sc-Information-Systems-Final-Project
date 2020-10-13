package com.example.emran2020;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Main41Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main41 );
    }

    public void ShowDetails145(View view) {

        Intent my = new Intent ( Main41Activity.this, Main43Activity.class );
        startActivity ( my );

    }

    public void UpdateDetails145(View view) {

        Intent my = new Intent ( Main41Activity.this, Main44Activity.class );
        startActivity ( my );


    }
}
