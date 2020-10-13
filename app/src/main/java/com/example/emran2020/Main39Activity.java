package com.example.emran2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
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

public class Main39Activity extends AppCompatActivity {
    EditText id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main39 );
        id = findViewById ( R.id.show7000 );


    }


    public void show7000(View view) {


        if (TextUtils.isEmpty ( id.getText ().toString () )) {
            Toast.makeText ( Main39Activity.this, "Insert Id",
                    Toast.LENGTH_SHORT ).show ();
            id.setError ( "enter Your Id" );
            return;
        }

        if (id.getText ().toString ().length () != 9) {
            Toast.makeText ( Main39Activity.this, " Id should be 9 numbers",
                    Toast.LENGTH_SHORT ).show ();
            id.setError ( "Id should be 9 numbers" );
            return;
        }



        DatabaseReference reference = FirebaseDatabase.getInstance ().getReference ().child ( "Data" ).child ( "Patients Training" );
        Query query = reference.orderByChild ( "b________Id" ).equalTo ( id.getText ().toString () );
        query.addListenerForSingleValueEvent ( new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists ()) {
                    GlobalClass.idGraph=id.getText ().toString ();
                    Intent intent =new Intent ( Main39Activity.this,Main33Activity.class );
                    startActivity ( intent);
                }
                else{
                    AlertDialog.Builder builder= new AlertDialog.Builder ( Main39Activity.this );
                    builder.setTitle ( "Message" );
                    builder.setMessage ( "This id: "+"< " +id.getText ().toString ()+" >"+ " is not exists");
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