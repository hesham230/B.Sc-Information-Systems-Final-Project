package com.example.emran2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Main22Activity extends AppCompatActivity {
    DatabaseReference reference;
    RecyclerView recyclerView;
    ArrayList<PatientsTraining> list;
    TrainingAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main22 );
        choose1( GlobalClass.spinnerValue1,GlobalClass.search1);


        
    }

    public void choose1(String spinnerValue1,String value1) {
        switch (spinnerValue1) {
            case "Id":
                searcBySpinner( "b________Id", value1 );
                break;
            case "Entry Date ------> Sep 16, 2020":
                searcBySpinner( "a________EntryDate", value1 );
                break;

            case "First Name":
                searcBySpinner ( "c________FirstName", value1 );
                break;
            case "Last Name":
                searcBySpinner( "d________lastName", value1 );
                break;
            case "Gender ------> male/female":
                searcBySpinner ( "e________Gender", value1 );
                break;

            case "Age":
                searcBySpinner ( "f________Age", value1 );
                break;

            default:
                Toast.makeText ( Main22Activity.this, "Please Choose which variable you want to search for", Toast.LENGTH_LONG ).show ();

                Intent my = new Intent ( Main22Activity.this, Main23Activity.class );
                startActivity ( my );


        }
    }
    public void searcBySpinner(final String spinnerValue , String value){
        recyclerView = (RecyclerView) findViewById ( R.id.recyclerView2 );
        recyclerView.setLayoutManager ( new LinearLayoutManager ( this ) );

        reference = FirebaseDatabase.getInstance ().getReference ().child ( "Data" ).child ( "Patients Training" );
        Query query = reference.orderByChild ( spinnerValue ).equalTo ( value );
        query.addListenerForSingleValueEvent ( new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists ()) {

                    list = new ArrayList<PatientsTraining> ();

                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren ()) {
                        PatientsTraining p = dataSnapshot1.getValue ( PatientsTraining.class );
                        list.add ( p );
                    }
                    adapter = new TrainingAdapter ( Main22Activity.this, list );
                    recyclerView.setAdapter ( adapter );
                }
                else{


                    String spinnerV=spinnerValue;
                    String text = "";
                    switch(spinnerV) {

                        case "b________Id":
                            text= "Id" ;
                            break;

                        case "a________EntryDate":
                            text= "Entry Date" ;
                            break;

                        case "c________FirstName":
                            text="First Name";
                            break;

                        case "d________lastName":
                            text= "Last Name" ;
                            break;

                        case "e________Gender":
                            text= "Gender" ;
                            break;




                        default:
                            text="Age";

                    }

                    final Intent myy = new Intent ( Main22Activity.this, Main23Activity.class );

                        AlertDialog.Builder builder= new AlertDialog.Builder ( Main22Activity.this );
                        builder.setTitle ( "Message" );
                        builder.setMessage ( "This "+text+ " is not exists");
                        builder.setIcon ( R.drawable.sad);
                        builder.setPositiveButton ( "Ok", new DialogInterface.OnClickListener () {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity ( myy );
                            }
                        } );
                        builder.create ();
                        builder.show ();




                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText ( Main22Activity.this, "Opsss.... Something is wrong", Toast.LENGTH_SHORT ).show ();
            }
        } );

    }


}