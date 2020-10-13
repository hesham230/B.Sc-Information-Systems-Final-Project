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
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Main50Activity extends AppCompatActivity {


    DatabaseReference reference;
    RecyclerView recyclerView;
    ArrayList<messages> list;
    messageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main50 );

        recyclerView = (RecyclerView) findViewById ( R.id.myRecycler500 );
        recyclerView.setLayoutManager ( new LinearLayoutManager ( this ) );


        reference = FirebaseDatabase.getInstance ().getReference ().child ( "Messages" ).child ( "Processing messages" );
        reference.addValueEventListener ( new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                list = new ArrayList<messages> ();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren ()) {
                    messages p = dataSnapshot1.getValue ( messages.class );
                    list.add ( p );
                }

                adapter = new messageAdapter ( Main50Activity.this, list );
                recyclerView.setAdapter ( adapter );
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText ( Main50Activity.this, "Opsss.... Something is wrong", Toast.LENGTH_SHORT ).show ();
            }
        } );
    }
}
