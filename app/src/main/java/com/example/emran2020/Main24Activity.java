package com.example.emran2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.os.DropBoxManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

public class Main24Activity extends AppCompatActivity {
    TextView text ,text2,text3,text4;

    LineGraphSeries series;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main24 );

        text=findViewById ( R.id.textView25 );
        text2=findViewById ( R.id.textView63 );

        text3=findViewById ( R.id.textView66 );

        text.setText ( "Patient's ID: "+ GlobalClass.idShow );

        text3.setText ( "- כל אחד מערכי ציר X מתאר אימון אחד."+ "\n"+
                "- ציר Y מתאר את שביעת רצון המטובל בכל אימון. " );





        final GraphView graph = (GraphView) findViewById ( R.id.view );
        series=new LineGraphSeries (  );
        graph.addSeries ( series );
        DatabaseReference reference = FirebaseDatabase.getInstance ().getReference ().child ( "Data" ).child ( "Satisfaction Of Patients" );
        Query query = reference.orderByChild ( "id" ).equalTo ( GlobalClass.idShow );
        query.addListenerForSingleValueEvent ( new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                DataPoint [] dp=new DataPoint [(int) dataSnapshot.getChildrenCount ()];
                int index=0;
                int i=1;
                int count=0;
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren ()) {
                   SatisfactionOfPatients dax=dataSnapshot1.getValue (SatisfactionOfPatients.class);
                   count++;

                    dp[index]=new DataPoint ( i++ ,dax.getValue () );
                    index++;



                }
                text2.setText ("The number of exercises the patient did:"+String.valueOf (count));
                    series.resetData ( dp );

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText ( Main24Activity.this, "Opsss.... Something is wrong", Toast.LENGTH_SHORT ).show ();
            }
        } );


    }


    public void details3(View view){

        DatabaseReference reference = FirebaseDatabase.getInstance ().getReference ().child ( "Data" ).child ( "Members" );
        Query query = reference.orderByChild ( "b________Id" ).equalTo ( GlobalClass.idShow );
        query.addListenerForSingleValueEvent ( new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren ()) {
                    Users p = dataSnapshot1.getValue ( Users.class );

                    AlertDialog.Builder builder= new AlertDialog.Builder ( Main24Activity.this );
                    builder.setTitle ( "Details" );
                    builder.setIcon ( R.drawable.person1);
                    builder.setMessage (
                            "Registration Date:   "+p.getA________RegistrationDate ()+"\n"+"\n"+
                                    "First Name:   " + p.getC________FirstName ()+"\n"+"\n"+
                                    "Last Name:  " + p.getD________LastName ()+"\n"+"\n"+
                                    "Age:   " + p.getH________Age ()+"\n" +"\n"+
                                    "Gender:   " + p.getF________Gender ()+"\n" +"\n"+
                                    "Birthday:   "+ p.getG________Birthday ()+"\n" +"\n"+
                                    "Phone:   "+ p.getI________Phone ()+"\n" +"\n"+
                                    "Location:   "+ p.getJ________Location ());
                    builder.setPositiveButton ( "Go back",null);

                    builder.create ();
                    builder.show ();


                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText ( Main24Activity.this, "Opsss.... Something is wrong", Toast.LENGTH_SHORT ).show ();
            }
        } );
    }
}
