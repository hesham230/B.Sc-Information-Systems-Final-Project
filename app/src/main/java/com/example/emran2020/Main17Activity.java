package com.example.emran2020;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Main17Activity extends AppCompatActivity {

    EditText value44;
    String  glucose;
    RadioButton r5 ,r6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main17 );

        value44 =findViewById ( R.id.editText4);
        r5=findViewById ( R.id.radioButton5 );
        r6=findViewById ( R.id.radioButton6 );


    }


    public void Next2(View view) {
        glucose=value44.getText ().toString ();



        if (TextUtils.isEmpty ( glucose) &&r5.isChecked () == false && r6.isChecked () == false) {
            Toast.makeText ( Main17Activity.this, "Enter the answers",
                    Toast.LENGTH_SHORT ).show ();
           value44.setError ( "Glucose?!!" );

            return;
        }



        if (TextUtils.isEmpty (glucose)) {
            Toast.makeText ( Main17Activity.this, "Glucose?!!",
                    Toast.LENGTH_SHORT ).show ();
            value44.setError ( "Glucose?!!" );

            return;
        }
        if (r5.isChecked () == false && r6.isChecked () == false) {
            Toast.makeText ( Main17Activity.this, "medications??",
                    Toast.LENGTH_SHORT ).show ();

            return;
        }




        if(r5.isChecked ()){
            GlobalClass.gettingmedic1="0";
            GlobalClass.gettingmedic2="No";

        }
        else {

            GlobalClass.gettingmedic1 = "1";
            GlobalClass.gettingmedic2="No";
        }

        GlobalClass.glucose=glucose;

        Intent intent = new Intent ( Main17Activity.this ,Main18Activity.class );
        startActivity ( intent );


        }

    public void previos1(View view) {
        Intent intent = new Intent ( Main17Activity.this ,Main15Activity.class );
        startActivity ( intent );
    }
}

