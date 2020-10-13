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

public class Main34Activity extends AppCompatActivity {

    DatabaseReference reference;
    RecyclerView recyclerView;
    ArrayList<messages> list;
   messageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main34 );

        recyclerView = (RecyclerView) findViewById ( R.id.myRecycler5 );
        recyclerView.setLayoutManager ( new LinearLayoutManager ( this ) );


        reference = FirebaseDatabase.getInstance ().getReference ().child ( "Messages" ).child ( "All messages" );
        reference.addValueEventListener ( new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                list = new ArrayList<messages> ();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren ()) {
                    messages p = dataSnapshot1.getValue ( messages.class );
                    list.add ( p );
                }

                adapter = new messageAdapter ( Main34Activity.this, list );
                recyclerView.setAdapter ( adapter );
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText ( Main34Activity.this, "Opsss.... Something is wrong", Toast.LENGTH_SHORT ).show ();
            }
        } );
    }

}
