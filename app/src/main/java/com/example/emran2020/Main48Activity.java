package com.example.emran2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Main48Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main48 );
    }

    public void showMessages(View view) {
        Intent intent = new Intent ( Main48Activity.this ,Main34Activity.class );
        startActivity ( intent );
    }

    public void searchM5(View view) {
        Intent intent = new Intent ( Main48Activity.this ,Main36Activity.class );
        startActivity ( intent );
    }
}
