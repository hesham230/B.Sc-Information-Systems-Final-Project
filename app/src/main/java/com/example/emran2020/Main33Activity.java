package com.example.emran2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
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

public class Main33Activity extends AppCompatActivity {
    TextView t0,t00,t1,t2,t3,t4,t5,t6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main33 );

        t0=findViewById ( R.id.textView104 );
        t00=findViewById ( R.id.textView106 );
        t1=findViewById ( R.id.textView105 );
        t2=findViewById ( R.id.textView103 );
        t3=findViewById ( R.id.textView102 );
        t4=findViewById ( R.id.textView101);
        t5=findViewById ( R.id.textView100);
        t6=findViewById ( R.id.textView96 );

        count ();

    }

    public void pie (int t1,int t2 ,int t3 ,int t4 ,int t5 ,int t6){
        AnimatedPieView mAnimatedPieView = findViewById(R.id.animatedPieView7);
        AnimatedPieViewConfig config = new AnimatedPieViewConfig();
        config.startAngle(-90)// Starting angle offset
                .addData(new SimplePieInfo (t1, Color.parseColor ("#00ff00" ), ( "Force Free Weight" ) ))
                .addData(new SimplePieInfo (t2, Color.parseColor ("#ff751a" ), ( "Force Rubber Bar" ) ))
                .addData(new SimplePieInfo (t3, Color.parseColor ("#d65cad" ), ( "Riding Bikes" ) ))
                .addData(new SimplePieInfo (t4, Color.parseColor ("#ff5050" ), ( "Riding Elliptic" ) ))
                .addData(new SimplePieInfo (t5, Color.parseColor ("#4dd2ff" ), ( "Riding Growing" ) ))//Data (bean that implements the IPieInfo interface)
                .addData(new SimplePieInfo(t6, Color.parseColor ("#4d79ff" ),( "Riding Walk" ))).drawText(true).strokeMode ( true)
                .duration(2000).textSize (33);
        //

// The following two sentences can be replace directly 'mAnimatedPieView.start (config); '
        mAnimatedPieView.applyConfig(config);
        mAnimatedPieView.start();
    }
    public void count() {


        DatabaseReference reference = FirebaseDatabase.getInstance ().getReference ().child ( "Data" ).child ( "Patients Training" );
        Query query = reference.orderByChild ( "b________Id" ).equalTo (GlobalClass.idGraph);
        query.addListenerForSingleValueEvent ( new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int all=0;
                int training1 = 0;
                int training2 = 0;
                int training3 = 0;
                int training4 = 0;
                int training5 = 0;
                int training6 = 0;


                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren ()) {
                    PatientsTraining p = dataSnapshot1.getValue ( PatientsTraining.class );


                    if (p.getTraining1 ().contains ( "* Force Free Weight" )) {
                        all++; }

                    if (p.getTraining1 ().equals ( "* Force Free Weight -> Yes" )) {
                        training1++; }

                     if (p.getTraining2 ().equals ("* TraForce Rubber Bar -> Yes" )) {
                        training2++;  }

                    if (p.getTraining3 ().equals ("* Riding Bikes -> Yes")) {
                        training3++;  }

                   if (p.getTraining4 ().equals ( "* Riding Elepitic -> Yes" )) {
                        training4++;  }

                     if (p.getTraining5().equals ("* Riding Growing -> Yes" )) {
                        training5++;  }

                    if ("* Riding Walk -> Yes".equals ( p.getTraining6() )) {
                        training6++;  }
                }


                t0.setText ( "ID: " +GlobalClass.idGraph);
                t00.setText("Number of workouts: "+String.valueOf ( all ));
                t1.setText ( "Number of workouts of type Force Free Weight: "+String.valueOf ( training1 ) );
                t2.setText ( "Number of workouts of type TraForce Rubber Bar: "+String.valueOf ( training2 ) );
                t3.setText ( "Number of workouts of type Riding Elepitic: " +String.valueOf ( training3 ));
                t4.setText ( "Number of workouts of type Force Free Weight: "+String.valueOf ( training4 ) );
                t5.setText ( "Number of workouts of type Riding Growing:  "+String.valueOf ( training5 ) );
                t6.setText ( "Number of workouts of type Riding Walk: " +String.valueOf ( training6 ));
                pie(training1,training2,training3,training4,training5,training6);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText ( Main33Activity.this, "Opsss.... Something is wrong", Toast.LENGTH_SHORT ).show ();
            }
        } );


    }

    public void details2(View view){

        DatabaseReference reference = FirebaseDatabase.getInstance ().getReference ().child ( "Data" ).child ( "Members" );
        Query query = reference.orderByChild ( "b________Id" ).equalTo ( GlobalClass.idGraph );
        query.addListenerForSingleValueEvent ( new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren ()) {
                    Users p = dataSnapshot1.getValue ( Users.class );

                    AlertDialog.Builder builder= new AlertDialog.Builder ( Main33Activity.this );
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
                Toast.makeText ( Main33Activity.this, "Opsss.... Something is wrong", Toast.LENGTH_SHORT ).show ();
            }
        } );
    }


}
