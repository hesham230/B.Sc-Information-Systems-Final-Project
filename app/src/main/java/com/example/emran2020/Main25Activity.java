package com.example.emran2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Main25Activity extends AppCompatActivity {
    EditText value;
    SatisfactionOfPatients satisfactionOfPatients;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main25 );
        value=findViewById ( R.id.ed );





    }
    public void continue2(View view) {

        String value1=value.getText ().toString ();



        if (TextUtils.isEmpty ( value1 )) {

            Toast.makeText ( getApplicationContext (), "insert a value from 1 to 10", Toast.LENGTH_LONG ).show ();
            value.setError ( "insert a value from 1 to 10" );
            return;
        }

        if(Integer.parseInt ( value1 )<1 || Integer.parseInt ( value1 )>10 ){
            Toast.makeText ( getApplicationContext (), "insert a value from 1 to 10", Toast.LENGTH_LONG ).show ();
            value.setError ( "insert a value from 1 to 10" );
            return;

        }









        satisfactionOfPatients= new SatisfactionOfPatients (GlobalClass.answer1,Integer.parseInt ( value1 ));

        DatabaseReference Data = FirebaseDatabase.getInstance ().getReference ("Data").child ( "Satisfaction Of Patients" );
        Data.push ().setValue ( satisfactionOfPatients);

        Intent intent =new Intent ( Main25Activity.this,Main3Activity.class );
        startActivity ( intent );


    }
}