package com.example.emran2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.auth.User;

public class activity_main6 extends AppCompatActivity {
    public EditText UserDocotr, pass;
    Users Doctors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main6 );

        UserDocotr = findViewById ( R.id.userNameIddoctor );
        pass = findViewById ( R.id.passWordIddoctor );
    }


    public void enterLoginnDocotr(View view) {
        String DoctorId= UserDocotr.getText ().toString ();
        String passD=pass.getText ().toString ();


        if (TextUtils.isEmpty ( DoctorId )&& TextUtils.isEmpty ( passD )) {
            UserDocotr.setError ( "enter Your Id" );
            pass.setError ( "Enter Your Password" );

            Toast.makeText ( activity_main6.this, "Please Enter Details ", Toast.LENGTH_LONG ).show ();
            return;
        }




        if (TextUtils.isEmpty ( DoctorId )){
            Toast.makeText ( activity_main6.this, "Enter Your Id",
                    Toast.LENGTH_SHORT ).show ();
            UserDocotr.setError ( "enter Your Id" );
            return;}




        if ( TextUtils.isEmpty ( passD )) {
            Toast.makeText ( activity_main6.this, "Enter Your Password",
                    Toast.LENGTH_SHORT ).show ();
            pass.setError ( "Enter Your Password" );
            return;
        }


        if(DoctorId.length ()!=9){
            Toast.makeText ( activity_main6.this, "Your Id should be 9 numbers",
                    Toast.LENGTH_SHORT ).show ();
            UserDocotr.setError (  "Your Id should be 9 numbers" );
            return;
        }

        if(passD.length ()<6){
            Toast.makeText ( activity_main6.this, "Your Password should be at least 6 numbers/characters",
                    Toast.LENGTH_SHORT ).show ();
            pass.setError ( "Your Password should be at least 6 numbers/characters" );
            return;
        }






        DatabaseReference reference = FirebaseDatabase.getInstance ().getReference ().child ( "Data" ).child ( "Medical Staff" );
        Query query = reference.orderByChild ( "b________Id" ).equalTo ( UserDocotr.getText ().toString () );
        query.addListenerForSingleValueEvent ( new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if ((dataSnapshot.exists ())) {

                    for (DataSnapshot dataSnapshot11 : dataSnapshot.getChildren ()) {
                        Users p = dataSnapshot11.getValue ( Users.class );
                        if (p.getE________PassWord ().equals ( pass.getText ().toString () )) {

                            Intent my = new Intent ( activity_main6.this, Main7Activity.class );
                            startActivity ( my );


                        }
                        else{
                            AlertDialog.Builder builder = new AlertDialog.Builder ( activity_main6.this );
                            builder.setTitle ( "Message" );
                            builder.setMessage ("Your Password is wrong " );
                            builder.setIcon ( R.drawable.sad );
                            builder.setPositiveButton ( "Ok", null );

                            builder.create ();
                            builder.show ();



                        }
                    }
                } else {


                    AlertDialog.Builder builder = new AlertDialog.Builder ( activity_main6.this );
                    builder.setTitle ( "Message" );
                    builder.setMessage ( "This user is not exist" );
                    builder.setIcon ( R.drawable.sad );
                    builder.setPositiveButton ( "Ok", null );

                    builder.create ();
                    builder.show ();


                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        } );


    }
}