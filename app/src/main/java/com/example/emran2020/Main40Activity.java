package com.example.emran2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Main40Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main40 );
    }

    public void details100(View view) {
        Intent intent = new Intent ( Main40Activity.this, Main41Activity.class );
        startActivity ( intent );
    }

    public void myTraining(View view) {
        Intent intent = new Intent ( Main40Activity.this, Main42Activity.class );
        startActivity ( intent );
    }
}
