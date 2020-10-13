package com.example.emran2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Main49Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main49 );
    }

    public void toProcess(View view) {
        Intent intent = new Intent ( Main49Activity.this ,Main38Activity.class );
        startActivity ( intent );
    }

    public void viewunprocessMessages(View view) {
        Intent intent = new Intent ( Main49Activity.this ,Main50Activity.class );
        startActivity ( intent );
    }
}
