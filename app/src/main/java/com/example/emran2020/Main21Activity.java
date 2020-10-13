package com.example.emran2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Main21Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main21 );
    }

    public void ShowAllPatientsTraining(View view) {
        Intent intent = new Intent ( Main21Activity.this ,Main20Activity.class );
        startActivity ( intent );
    }

    public void search100(View view) {
        Intent intent = new Intent ( Main21Activity.this ,Main23Activity.class );
        startActivity ( intent );


    }
}
