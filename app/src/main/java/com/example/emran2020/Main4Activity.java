package com.example.emran2020;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity  {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main4 );

    }


    public void staff(View view) {
        Intent my = new Intent ( Main4Activity.this, activity_main6.class );
        startActivity ( my );

    }


    public void patient(View view) {
        Intent my = new Intent ( Main4Activity.this, MainActivity.class );
        startActivity ( my );
    }

}


