package com.example.emran2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
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
import com.razerdp.widget.animatedpieview.AnimatedPieView;
import com.razerdp.widget.animatedpieview.AnimatedPieViewConfig;
import com.razerdp.widget.animatedpieview.data.SimplePieInfo;

public class Main32Activity extends AppCompatActivity {

    TextView id ,all , low , medium , high ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main32 );


        id=findViewById ( R.id.textView19 );
        all=findViewById ( R.id.textView16 );
        low=findViewById ( R.id.textView17 );
        medium=findViewById ( R.id.textView18 );
        high=findViewById ( R.id.textView20 );

        count();


    }
    public void pie (int x, int y,int z){
        AnimatedPieView mAnimatedPieView = findViewById(R.id.animatedPieView2);
        AnimatedPieViewConfig config = new AnimatedPieViewConfig();
        config.startAngle(-90)// Starting angle offset
                .addData(new SimplePieInfo (x, Color.parseColor ("#5FFF33" ), ( "low" ) ))
                .addData(new SimplePieInfo (z, Color.parseColor ("#FF4533" ), ( "high" ) ))//Data (bean that implements the IPieInfo interface)
                .addData(new SimplePieInfo(y, Color.parseColor ("#FFC433" ),( "medium" ))).drawText(true).strokeMode ( false )
                .duration(2000).textSize ( 25 );
        //

// The following two sentences can be replace directly 'mAnimatedPieView.start (config); '
        mAnimatedPieView.applyConfig(config);
        mAnimatedPieView.start();
    }
    public void count() {


        DatabaseReference reference = FirebaseDatabase.getInstance ().getReference ().child ( "Data" ).child ( "Patients Training" );
        Query query = reference.orderByChild ( "b________Id" ).equalTo ( GlobalClass.idShow1 );
        query.addListenerForSingleValueEvent ( new ValueEventListener ()  {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int a = 0;
                int b = 0;
                int c=0;



                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren ()) {
                        PatientsTraining p = dataSnapshot1.getValue ( PatientsTraining.class );

                          if ("Low".equals ( p.getL________RiskLevel () )) {
                            a++;
                        } else if("Medium".equals ( p.getL________RiskLevel () )) {
                            b++;
                        } else if("High".equals ( p.getL________RiskLevel () )) {
                            c++;
                        }

                    }

                    id.setText ( "Id: "+GlobalClass.idShow1 );
                    all.setText ( "Number of general tests: "+ String.valueOf ( a+b+c ) );
                    low.setText ( "Number of general tests whose risk assessment was LOW: "+ String.valueOf ( a ) );
                    medium.setText ( "Number of general tests whose risk assessment was MEDIUM: "+ String.valueOf ( b ) );
                    high.setText ( "Number of general tests whose risk assessment was HIGH: "+ String.valueOf ( c ) );


                Log.v ( "low", String.valueOf ( a ) );
                Log.v ( "medium", String.valueOf ( b ) );
                Log.v ( "high", String.valueOf ( c ) );
                pie(a,b,c);


        }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText ( Main32Activity.this, "Opsss.... Something is wrong", Toast.LENGTH_SHORT ).show ();
            }
        } );
    }
    public void details1(View view){

        DatabaseReference reference = FirebaseDatabase.getInstance ().getReference ().child ( "Data" ).child ( "Members" );
        Query query = reference.orderByChild ( "b________Id" ).equalTo ( GlobalClass.idShow1 );
        query.addListenerForSingleValueEvent ( new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren ()) {
                    Users p = dataSnapshot1.getValue ( Users.class );

                    AlertDialog.Builder builder= new AlertDialog.Builder ( Main32Activity.this );
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
                Toast.makeText ( Main32Activity.this, "Opsss.... Something is wrong", Toast.LENGTH_SHORT ).show ();
            }
        } );
    }



}

