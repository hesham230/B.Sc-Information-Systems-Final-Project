package com.example.emran2020;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
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

public class Main29Activity extends AppCompatActivity {
    TextView all , female , male;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main29 );
        all=findViewById ( R.id.textView13 );
        male=findViewById ( R.id.textView14 );
        female=findViewById ( R.id.textView15 );

        countFemaleAndMale ();



    }
    public void pie (int x, int y){
        AnimatedPieView mAnimatedPieView = findViewById(R.id.animatedPieView);
        AnimatedPieViewConfig config = new AnimatedPieViewConfig();
        config.startAngle(-90)// Starting angle offset
                .addData(new SimplePieInfo(y, Color.parseColor ("#00ff00" ), ( "male" ) ))//Data (bean that implements the IPieInfo interface)
                .addData(new SimplePieInfo(x, Color.parseColor ("#ff0000" ),( "female" ))).drawText(true).strokeMode ( false )
                .duration(2000).textSize ( 30 );

// The following two sentences can be replace directly 'mAnimatedPieView.start (config); '
        mAnimatedPieView.applyConfig(config);
        mAnimatedPieView.start();
    }



    public void countFemaleAndMale() {



        DatabaseReference reference = FirebaseDatabase.getInstance ().getReference ().child ( "Data" ).child ( "Members" );
        Query query = reference.orderByChild ( "f________Gender" );
        query.addListenerForSingleValueEvent ( new ValueEventListener () {

            @Override

            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int m =0;
                int f=0;

                if (dataSnapshot.exists ()) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren ()) {
                    Users p = dataSnapshot1.getValue ( Users.class );


                    if("female".equals ( p.getF________Gender () )){

                        f++;
                    }
                    else {
                        m++;
                    }
                }
                all.setText ( "Number of patients:  "+String.valueOf ( m+f ) );
                male.setText ( "Number of Male patients:  "+String.valueOf ( m ) );
                female.setText ( "Number of Female patients:  "+String.valueOf ( f) );

                pie(f,m);
            }
                else{

                    AlertDialog.Builder builder= new AlertDialog.Builder ( Main29Activity.this );
                    builder.setTitle ( "Message" );
                    builder.setMessage ( "There's no patients");
                    builder.setIcon ( R.drawable.sad);
                    builder.setPositiveButton ( "Ok", null );
                    builder.create ();
                    builder.show ();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText ( Main29Activity.this, "Opsss.... Something is wrong", Toast.LENGTH_SHORT ).show ();
            }

        } );
    }


}
