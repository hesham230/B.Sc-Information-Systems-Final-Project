package com.example.emran2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Main43Activity extends AppCompatActivity {
    TextView date, id, firstName, lastName, gender, passWord, phone, birthday, location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main43 );

        date = findViewById ( R.id.textView36 );
        id = findViewById ( R.id.textView33 );
        firstName = findViewById ( R.id.textView58 );
        lastName = findViewById ( R.id.textView49 );
        gender = findViewById ( R.id.textView57 );
        passWord = findViewById ( R.id.textView37 );
        phone = findViewById ( R.id.textView60 );
        birthday = findViewById ( R.id.textView59 );
        location = findViewById ( R.id.textView61 );

        DatabaseReference reference = FirebaseDatabase.getInstance ().getReference ().child ( "Data" ).child ( "Members" );
        Query query = reference.orderByChild ( "b________Id" ).equalTo ( GlobalClass.answer1 );
        query.addListenerForSingleValueEvent ( new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren ()) {
                    Users p = dataSnapshot1.getValue ( Users.class );
                    date.setText ( "Registration Date: " + p.getA________RegistrationDate () );
                    id.setText ( "id: " + p.getB________Id () );
                    firstName.setText ( "First Name: " + p.getC________FirstName () );
                    lastName.setText ( "Last Name: " + p.d________LastName );
                    gender.setText ( "Gender: " + p.getF________Gender () );
                    passWord.setText ( "PassWord: " + p.getE________PassWord () );
                    birthday.setText ( "Birthday: " + p.getG________Birthday () );
                    phone.setText ( "Phone: " + p.getI________Phone () );
                    location.setText ( "Location: " + p.getJ________Location () );


                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText ( Main43Activity.this, "Opsss.... Something is wrong", Toast.LENGTH_SHORT ).show ();
            }
        } );
    }

}