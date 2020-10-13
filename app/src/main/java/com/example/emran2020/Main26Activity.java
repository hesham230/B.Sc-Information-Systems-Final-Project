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

public class Main26Activity extends AppCompatActivity {
    EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main26 );
        text=findViewById ( R.id.show );

    }

    public void show1(View view) {



        if (TextUtils.isEmpty ( text.getText ().toString ())){
            Toast.makeText ( Main26Activity.this, "Enter Your Id",
                    Toast.LENGTH_SHORT ).show ();
            text.setError ( "enter Your Id" );
            return;
        }

        if(text.getText ().toString ().length ()!=9){
            Toast.makeText ( Main26Activity.this, "Your Id should be 9 numbers",
                    Toast.LENGTH_SHORT ).show ();
            text.setError (  "Your Id should be 9 numbers" );
            return;
        }


        DatabaseReference reference = FirebaseDatabase.getInstance ().getReference ().child ( "Data" ).child ( "Patients Training" );
        Query query = reference.orderByChild ( "b________Id" ).equalTo ( text.getText ().toString () );
        query.addListenerForSingleValueEvent ( new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists ()) {
                    GlobalClass.idShow=text.getText ().toString ();
                    Intent intent =new Intent ( Main26Activity.this,Main24Activity.class );
                     startActivity ( intent);
                }
                else{
                    AlertDialog.Builder builder= new AlertDialog.Builder ( Main26Activity.this );
                    builder.setTitle ( "Message" );
                    builder.setMessage ( "This id: "+"< " +text.getText ().toString ()+" >"+ " is not exists");
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
