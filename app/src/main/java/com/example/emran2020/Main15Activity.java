package com.example.emran2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main15Activity extends AppCompatActivity {
    EditText value11 ,value22 ,value33 ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main15 );

        value11 =findViewById ( R.id.editText);
        value22 =findViewById ( R.id.editText3);
        value33 =findViewById ( R.id.editText2 );

    }

    public void Next1(View view) {
        String weight=value11.getText ().toString ();
        String heartb=value22.getText ().toString ();
        String bloodP=value33.getText ().toString ();


        if (TextUtils.isEmpty ( weight) &TextUtils.isEmpty ( heartb)&& TextUtils.isEmpty ( bloodP)) {
            Toast.makeText ( Main15Activity.this, "Enter the answers",
                    Toast.LENGTH_SHORT ).show ();
            value11.setError ( "Enter Your weight" );
            value22.setError ( "Enter Your heartbeat" );
            value33.setError ( "Enter Your blood pressure" );
            return;
        }



        if (TextUtils.isEmpty ( weight)) {
            Toast.makeText ( Main15Activity.this, "Enter Your weight",
                    Toast.LENGTH_SHORT ).show ();
            value11.setError ( "Enter Your weight" );

            return;
        }
        if (TextUtils.isEmpty ( heartb)) {
            Toast.makeText ( Main15Activity.this, "Enter Your heartbeat",
                    Toast.LENGTH_SHORT ).show ();
            value22.setError ( "Enter Your heartbeat" );

            return;
        }

        if (TextUtils.isEmpty ( bloodP)) {
            Toast.makeText ( Main15Activity.this, "Enter Your blood pressure",
                    Toast.LENGTH_SHORT ).show ();
            value33.setError ( "Enter Your blood pressure" );

            return;
        }





        GlobalClass.weight=weight;
        GlobalClass.heartbeat=heartb;
        GlobalClass.bloodpressure=bloodP;

        Intent intent = new Intent ( Main15Activity.this ,Main17Activity.class );
        startActivity ( intent );
    }
}