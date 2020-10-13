package com.example.emran2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.util.Calendar;

public class Main27Activity extends AppCompatActivity {
    TextView date1, first ,last;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main27 );
        date1=findViewById ( R.id.textView34 );
        first=findViewById ( R.id.textView35 );

        Calendar calendar=Calendar.getInstance ();
        String date= DateFormat.getDateInstance ().format ( calendar.getTime () );
        date1.setText ( date );


       first.setText ("Id: " +GlobalClass.answer1);



    }

    public void toexercises(View view) {
        Intent intent = new Intent ( Main27Activity.this, Main28Activity.class );
        startActivity ( intent );
    }


    public void starthere(View view) {

        GlobalClass.process = "false";


        DatabaseReference referenceEE = FirebaseDatabase.getInstance ().getReference ().child ( "Messages" ).child ( "Processing messages" );
        Query queryY = referenceEE.orderByChild ( "b________Id" ).equalTo ( GlobalClass.answer1 );
        queryY.addListenerForSingleValueEvent ( new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull final DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists ()) {


                    AlertDialog.Builder builder = new AlertDialog.Builder ( Main27Activity.this );
                    builder.setTitle ( "Message" );
                    builder.setMessage ( "You can't continue you must see a doctor" );
                    builder.setIcon ( R.drawable.sad );

                    builder.setPositiveButton ( "Thanks", new DialogInterface.OnClickListener () {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent my = new Intent ( Main27Activity.this, Main5Activity.class );
                            startActivity ( my );

                        }
                    } );

                    builder.create ();
                    builder.show ();


                } else {

                    AlertDialog.Builder builder = new AlertDialog.Builder ( Main27Activity.this );
                    builder.setTitle ( "Message" );
                    builder.setMessage ( "To continue We need to ask you some questions" +
                            "\nto maintain your health and general health" );
                    builder.setIcon ( R.drawable.successfully1 );

                    builder.setPositiveButton ( "I agree", new DialogInterface.OnClickListener () {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            DatabaseReference referencee = FirebaseDatabase.getInstance ().getReference ().child ( "Data" ).child ( "Patients Training" );
                            Query queryy = referencee.orderByChild ( "b________Id" ).equalTo ( GlobalClass.answer1 );
                            queryy.addListenerForSingleValueEvent ( new ValueEventListener () {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    if (dataSnapshot.exists ()) {
                                        Intent intent = new Intent ( Main27Activity.this, Main25Activity.class );

                                        startActivity ( intent );

                                    } else {


                                        Intent intent = new Intent ( Main27Activity.this, Main3Activity.class );

                                        startActivity ( intent );
                                    }

                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            } );


                        }
                    } );

                    builder.create ();
                    builder.show ();
                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        } );


    }

    public void myProfile(View view) {
        Intent intent = new Intent ( Main27Activity.this, Main40Activity.class );
        startActivity ( intent );
    }

}
