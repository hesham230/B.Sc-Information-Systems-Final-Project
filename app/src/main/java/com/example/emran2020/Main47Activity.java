package com.example.emran2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main47Activity extends AppCompatActivity {
    EditText date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main47 );
        date=findViewById ( R.id.search5011 );


    }

    public void search501(View view) {

        if (TextUtils.isEmpty (date.getText ().toString ())) {
            Toast.makeText ( Main47Activity.this, "Insert date",
                    Toast.LENGTH_SHORT ).show ();
            date.setError ( "Insert date" );
            return;
        }
        GlobalClass.searchDate=date.getText ().toString ();
        Intent intent = new Intent ( Main47Activity.this ,Main46Activity.class );
        startActivity ( intent );
    }

    }

