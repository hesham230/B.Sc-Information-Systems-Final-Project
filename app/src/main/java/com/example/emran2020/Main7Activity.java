package com.example.emran2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
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

import java.util.ArrayList;

public class Main7Activity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main7 );

        DatabaseReference reference = FirebaseDatabase.getInstance ().getReference ().child ( "Messages" ).child ( "Processing messages" );
        reference.addValueEventListener ( new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


              int x= (int) dataSnapshot.getChildrenCount ();

                if(x!=0){
                    AlertDialog.Builder builder= new AlertDialog.Builder ( Main7Activity.this );
                    builder.setTitle ( "Message" );
                    builder.setMessage ( "You have "+String.valueOf ( x ) + " Alerts" );
                    builder.setIcon ( R.drawable.alert);
                    builder.setPositiveButton ( "Cancel",null);
                    builder.setNegativeButton ( "To Process", new DialogInterface.OnClickListener () {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent my = new Intent ( Main7Activity.this, Main37Activity.class );
                                    startActivity ( my );
                                }
                            }

                    );

                    builder.create ();
                    builder.show ();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText ( Main7Activity.this, "Opsss.... Something is wrong", Toast.LENGTH_SHORT ).show ();
            }
        } );



    }

    public void PatientsDetails(View view) {
        Intent my =new Intent ( Main7Activity.this , Main9Activity.class );
        startActivity ( my );
    }

    public void PatientsTraining(View view) {
        Intent my =new Intent ( Main7Activity.this , Main21Activity.class );
        startActivity ( my );

    }

    public void Satisfaction(View view) {
        Intent my =new Intent ( Main7Activity.this , Main31Activity.class );
        startActivity ( my );

    }

    public void message(View view) {
        Intent my =new Intent ( Main7Activity.this , Main37Activity.class );
        startActivity ( my );

    }
}
