package com.example.emran2020;

import android.os.Bundle;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.auth.User;

import java.util.ArrayList;

public class Main20Activity extends AppCompatActivity {

    DatabaseReference reference;
    RecyclerView recyclerView;
    ArrayList<PatientsTraining> list;
    TrainingAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main20 );

        recyclerView = (RecyclerView) findViewById ( R.id.recyclerView );
        recyclerView.setLayoutManager ( new LinearLayoutManager ( this ) );


        reference = FirebaseDatabase.getInstance ().getReference ().child ( "Data" ).child ( "Patients Training" );
        reference.addValueEventListener ( new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list = new ArrayList<PatientsTraining> ();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren ()) {
                     PatientsTraining patientsTraining = dataSnapshot1.getValue ( PatientsTraining.class );
                    list.add ( patientsTraining );
                }
                adapter = new TrainingAdapter ( Main20Activity.this, list );
                recyclerView.setAdapter ( adapter );
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText ( Main20Activity.this, "Opsss.... Something is wrong", Toast.LENGTH_SHORT ).show ();
            }
        } );
    }


}

