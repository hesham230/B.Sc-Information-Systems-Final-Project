package com.example.emran2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Main19Activity extends AppCompatActivity {
    EditText id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main19 );
        id = findViewById ( R.id.show70 );


    }


    public void show70(View view) {


        if (TextUtils.isEmpty ( id.getText ().toString () )) {
            Toast.makeText ( Main19Activity.this, "Enter Your Id",
                    Toast.LENGTH_SHORT ).show ();
            id.setError ( "enter Your Id" );
            return;
        }

        if (id.getText ().toString ().length () != 9) {
            Toast.makeText ( Main19Activity.this, "Your Id should be 9 numbers",
                    Toast.LENGTH_SHORT ).show ();
            id.setError ( "Your Id should be 9 numbers" );
            return;
        }


    DatabaseReference reference = FirebaseDatabase.getInstance ().getReference ().child ( "Data" ).child ( "Patients Training" );
    Query query = reference.orderByChild ( "b________Id" ).equalTo ( id.getText ().toString () );
        query.addListenerForSingleValueEvent ( new ValueEventListener () {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            if (dataSnapshot.exists ()) {
                GlobalClass.idShow1=id.getText ().toString ();
                Intent intent =new Intent ( Main19Activity.this ,Main32Activity.class);
                startActivity ( intent );
            }
            else{
                AlertDialog.Builder builder= new AlertDialog.Builder ( Main19Activity.this );
                builder.setTitle ( "Message" );
                builder.setMessage ( "This id: "+" <"+id.getText ().toString ()+"> "+ " is not exists");
                builder.setIcon ( R.drawable.sad);
                builder.setPositiveButton ( "Ok",null);
                builder.create ();
                builder.show ();

            }

        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    } );
}
}

