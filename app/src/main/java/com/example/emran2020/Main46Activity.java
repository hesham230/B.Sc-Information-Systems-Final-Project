package com.example.emran2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Main46Activity extends AppCompatActivity {
    DatabaseReference reference;
    RecyclerView recyclerView;
    ArrayList<PatientsTraining> list;
    AdapterP2 adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main46);

        recyclerView = (RecyclerView) findViewById ( R.id.myRecycler100 );
        recyclerView.setLayoutManager ( new LinearLayoutManager ( this ) );

        reference = FirebaseDatabase.getInstance ().getReference ().child ( "Data" ).child ( "Patients Training" );
        Query query = reference.orderByChild ("b________Id" ).equalTo ( GlobalClass.answer1 );
        query.addListenerForSingleValueEvent ( new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                  boolean a= false;
                    list = new ArrayList<PatientsTraining> ();

                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren ()) {
                        PatientsTraining p = dataSnapshot1.getValue ( PatientsTraining.class );
                        if (p.getA________EntryDate ().equals (GlobalClass.searchDate )) {
                          a=true;
                            list.add ( p );
                        }

                    }
                if(a==false){

                    AlertDialog.Builder builder = new AlertDialog.Builder ( Main46Activity.this );
                    builder.setTitle ( "Message" );
                    builder.setMessage ( "sorry this "+GlobalClass.searchDate+" not exists" );
                    builder.setIcon ( R.drawable.successfully1 );
                    builder.setPositiveButton ( "Thanks", new DialogInterface.OnClickListener () {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent my = new Intent ( Main46Activity.this, Main40Activity.class );
                                    startActivity ( my );
                                }
                            }


                    );

                    builder.create ();
                    builder.show ();
                }
                    adapter = new AdapterP2 ( Main46Activity.this, list );
                    recyclerView.setAdapter ( adapter );
                }



            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText ( Main46Activity.this, "Opsss.... Something is wrong", Toast.LENGTH_SHORT ).show ();
            }
        } );

    }



}

