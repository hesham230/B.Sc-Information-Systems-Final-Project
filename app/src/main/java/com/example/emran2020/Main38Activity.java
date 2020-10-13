package com.example.emran2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Main38Activity extends AppCompatActivity {
    EditText id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main38 );
        id=findViewById ( R.id.id1000 );

    }

    public void show1000(View view) {

        if (TextUtils.isEmpty ( id.getText ().toString () )) {
            Toast.makeText ( Main38Activity.this, "Enter Your Id",
                    Toast.LENGTH_SHORT ).show ();
            id.setError ( "enter Your Id" );
            return;
        }

        if (id.getText ().toString ().length () != 9) {
            Toast.makeText ( Main38Activity.this, "Your Id should be 9 numbers",
                    Toast.LENGTH_SHORT ).show ();
            id.setError ( "Your Id should be 9 numbers" );
            return;
        }


        DatabaseReference reference = FirebaseDatabase.getInstance ().getReference ().child ( "Messages" ).child ( "Processing messages" );
        Query query = reference.orderByChild ( "b________Id" ).equalTo ( id.getText ().toString () );
        query.addListenerForSingleValueEvent ( new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull final DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists ()) {

                    for ( final DataSnapshot dataSnapshot1 : dataSnapshot.getChildren ()) {
                        messages p = dataSnapshot.getValue ( messages.class );

                        String content = dataSnapshot1.child ( "f________content" ).getValue ().toString ();



                        final AlertDialog.Builder builder = new AlertDialog.Builder ( Main38Activity.this );
                        builder.setTitle ( "Massage" );
                        builder.setMessage ( content );
                        builder.setIcon ( R.drawable.message );
                        builder.setNegativeButton ( "Cancel" , null );
                        builder.setPositiveButton ( "Process", new DialogInterface.OnClickListener () {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dataSnapshot1.getRef ().removeValue ();
                            }
                        }


                        );
                        builder.create ();
                        builder.show ();

                    }
                }
                else{
                    AlertDialog.Builder builder= new AlertDialog.Builder ( Main38Activity.this );
                    builder.setTitle ( "Massege" );
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
