package com.example.emran2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Main31Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main31 );
    }

    public void scan(View view) {
        Intent intent = new Intent ( Main31Activity.this ,Main39Activity.class );
        startActivity ( intent );
    }

    public void satisfaction(View view) {
        Intent intent = new Intent ( Main31Activity.this ,Main26Activity.class );
        startActivity ( intent );
    }

    public void risk(View view) {
        Intent intent = new Intent ( Main31Activity.this ,Main19Activity.class );
        startActivity ( intent );
    }

    public void genderProportions(View view) {
        Intent intent = new Intent ( Main31Activity.this ,Main29Activity.class );
        startActivity ( intent );
    }
}
