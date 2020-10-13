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

public class Main35Activity extends AppCompatActivity {
    DatabaseReference reference;
    RecyclerView recyclerView;
    ArrayList<messages> list;
    messageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main35 );
        choose1( GlobalClass.spinnerValue2,GlobalClass.search2);
    }

    public void choose1(String spinnerValue1,String value1) {
        switch (spinnerValue1) {
            case "Id":
                searcBySpinner( "b________Id", value1 );
                break;
            case "Date ------> Sep 16, 2020":
                searcBySpinner( "a________Date", value1 );
                break;

            case "First Name":
                searcBySpinner ( "c________FirstName", value1 );
                break;
            case "Last Name":
                searcBySpinner( "d________lastName", value1 );
                break;

            default:
                Toast.makeText ( Main35Activity.this, "Please Choose which variable you want to search for", Toast.LENGTH_LONG ).show ();

                Intent my = new Intent ( Main35Activity.this, Main36Activity.class );
                startActivity ( my );


        }
    }
    public void searcBySpinner(final String spinnerValue , String value){
        recyclerView = (RecyclerView) findViewById ( R.id.recyclerView44 );
        recyclerView.setLayoutManager ( new LinearLayoutManager ( this ) );

        reference = FirebaseDatabase.getInstance ().getReference ().child ( "Messages" ).child ( "All messages" );
        Query query = reference.orderByChild ( spinnerValue ).equalTo ( value );
        query.addListenerForSingleValueEvent ( new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists ()) {

                    list = new ArrayList<messages> ();

                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren ()) {
                        messages p = dataSnapshot1.getValue ( messages.class );
                        list.add ( p );
                    }
                    adapter = new messageAdapter ( Main35Activity.this, list );
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
                            text= "Date" ;
                            break;

                        case "c________FirstName":
                            text="First Name";
                            break;


                        default:
                            text= "Last Name" ;

                    }

                    final Intent myy = new Intent ( Main35Activity.this, Main36Activity.class );

                    AlertDialog.Builder builder= new AlertDialog.Builder ( Main35Activity.this );
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
                Toast.makeText ( Main35Activity.this, "Opsss.... Something is wrong", Toast.LENGTH_SHORT ).show ();
            }
        } );

    }


}