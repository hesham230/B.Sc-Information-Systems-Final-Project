package com.example.emran2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Main37Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main37 );
    }

    public void processingMessage(View view) {
        Intent intent = new Intent ( Main37Activity.this ,Main49Activity.class );
        startActivity ( intent );
    }


    public void allMessages9(View view) {
        Intent intent = new Intent ( Main37Activity.this ,Main48Activity.class );
        startActivity ( intent );
    }
}
