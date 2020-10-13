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

public class Main8Activity extends AppCompatActivity {

      DatabaseReference reference;
    RecyclerView recyclerView;
    ArrayList<Users> list;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main8 );

        recyclerView = (RecyclerView) findViewById ( R.id.myRecycler );
        recyclerView.setLayoutManager ( new LinearLayoutManager ( this ) );


        reference = FirebaseDatabase.getInstance ().getReference ().child ( "Data" ).child ( "Members" );
        reference.addValueEventListener ( new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    list = new ArrayList<Users> ();
                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren ()) {
                        Users p = dataSnapshot1.getValue ( Users.class );
                        list.add ( p );
                    }

                adapter = new MyAdapter ( Main8Activity.this, list );
                recyclerView.setAdapter ( adapter );
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText ( Main8Activity.this, "Opsss.... Something is wrong", Toast.LENGTH_SHORT ).show ();
            }
        } );
    }


        }

