package com.example.emran2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Main45Activity extends AppCompatActivity {

    DatabaseReference reference;
    RecyclerView recyclerView;
    ArrayList<PatientsTraining> list;
   AdapterP2 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main45 );

        recyclerView = (RecyclerView) findViewById ( R.id.myRecycler9);
        recyclerView.setLayoutManager ( new LinearLayoutManager ( this ) );

        reference = FirebaseDatabase.getInstance ().getReference ().child ( "Data" ).child ( "Patients Training" );
        Query query = reference.orderByChild ("b________Id" ).equalTo ( GlobalClass.answer1 );
        query.addListenerForSingleValueEvent ( new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list = new ArrayList<PatientsTraining> ();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren ()) {
                    PatientsTraining patientsTraining = dataSnapshot1.getValue ( PatientsTraining.class );
                    list.add ( patientsTraining );
                }
                adapter = new AdapterP2 ( Main45Activity.this, list );
                recyclerView.setAdapter ( adapter );
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText ( Main45Activity.this, "Opsss.... Something is wrong", Toast.LENGTH_SHORT ).show ();
            }
        } );
    }


}