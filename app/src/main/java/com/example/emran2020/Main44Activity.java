package com.example.emran2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Main44Activity extends AppCompatActivity {
    EditText firstName, lastName, gender, birthday, passWord, phone, location;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main44 );

        firstName = findViewById ( R.id.editText5 );
        lastName = findViewById ( R.id.editText12 );
        gender = findViewById ( R.id.editText14 );
        birthday = findViewById ( R.id.editText15 );
        passWord = findViewById ( R.id.editText13 );
        phone = findViewById ( R.id.editText16 );
        location = findViewById ( R.id.editText17 );

    }


    public void update1(View view) {
        if (TextUtils.isEmpty ( firstName.getText ().toString () )) {
            Toast.makeText ( Main44Activity.this, "Enter Your First Name",
                    Toast.LENGTH_SHORT ).show ();
            firstName.setError ( "Enter Your First Name" );
            return;
        }

        DatabaseReference reference = FirebaseDatabase.getInstance ().getReference ().child ( "Data" ).child ( "Members" );
        Query query = reference.orderByChild ( "b________Id" ).equalTo ( GlobalClass.answer1 );
        query.addListenerForSingleValueEvent ( new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                for (DataSnapshot dataSnapshot11 : dataSnapshot.getChildren ()) {
                    Users p = dataSnapshot11.getValue ( Users.class );
                    dataSnapshot11.getRef ().child ( "c________FirstName" ).setValue ( firstName.getText ().toString () );


                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        } );

        Toast.makeText ( Main44Activity.this, " Your update was performed successfully", Toast.LENGTH_LONG ).show ();


    }


    public void update2(View view) {
        if (TextUtils.isEmpty ( lastName.getText ().toString () )) {
            Toast.makeText ( Main44Activity.this, "Enter Your Last Name",
                    Toast.LENGTH_SHORT ).show ();
            lastName.setError ( "Enter Your Last Name" );
            return;
        }

        DatabaseReference reference = FirebaseDatabase.getInstance ().getReference ().child ( "Data" ).child ( "Members" );
        Query query = reference.orderByChild ( "b________Id" ).equalTo ( GlobalClass.answer1 );
        query.addListenerForSingleValueEvent ( new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot dataSnapshot11 : dataSnapshot.getChildren ()) {
                    Users p = dataSnapshot11.getValue ( Users.class );

                    dataSnapshot11.getRef ().child ( "d________LastName" ).setValue ( lastName.getText ().toString () );


                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        } );
        Toast.makeText ( Main44Activity.this, " Your update was performed successfully", Toast.LENGTH_LONG ).show ();


    }

    public void update3(View view) {
        if (TextUtils.isEmpty ( gender.getText ().toString () )) {
            Toast.makeText ( Main44Activity.this, "Enter Your Gender",
                    Toast.LENGTH_SHORT ).show ();
            gender.setError ( "Enter Your Gender" );
            return;
        }

        DatabaseReference reference = FirebaseDatabase.getInstance ().getReference ().child ( "Data" ).child ( "Members" );
        Query query = reference.orderByChild ( "b________Id" ).equalTo ( GlobalClass.answer1 );
        query.addListenerForSingleValueEvent ( new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                for (DataSnapshot dataSnapshot11 : dataSnapshot.getChildren ()) {
                    Users p = dataSnapshot11.getValue ( Users.class );

                    dataSnapshot11.getRef ().child ( "f________Gender" ).setValue ( gender.getText ().toString () );


                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        } );
        Toast.makeText ( Main44Activity.this, " Your update was performed successfully", Toast.LENGTH_LONG ).show ();

    }

    public void update4(View view) {
        if (TextUtils.isEmpty ( birthday.getText ().toString () )) {
            Toast.makeText ( Main44Activity.this, "Enter Your Birthday",
                    Toast.LENGTH_SHORT ).show ();
            birthday.setError ( "Enter Your Birthday" );
            return;
        }
        DatabaseReference reference = FirebaseDatabase.getInstance ().getReference ().child ( "Data" ).child ( "Members" );
        Query query = reference.orderByChild ( "b________Id" ).equalTo ( GlobalClass.answer1 );
        query.addListenerForSingleValueEvent ( new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot dataSnapshot11 : dataSnapshot.getChildren ()) {
                    Users p = dataSnapshot11.getValue ( Users.class );

                    dataSnapshot11.getRef ().child ( "g________Birthday" ).setValue ( birthday.getText ().toString () );


                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        } );
        Toast.makeText ( Main44Activity.this, " Your update was performed successfully", Toast.LENGTH_LONG ).show ();


    }

    public void update5(View view) {

        if (TextUtils.isEmpty ( passWord.getText ().toString () )) {
            Toast.makeText ( Main44Activity.this, "Enter Your Password",
                    Toast.LENGTH_SHORT ).show ();
           passWord.setError ( "Enter Your Password" );
            return;
        }

        DatabaseReference reference = FirebaseDatabase.getInstance ().getReference ().child ( "Data" ).child ( "Members" );
        Query query = reference.orderByChild ( "b________Id" ).equalTo ( GlobalClass.answer1 );
        query.addListenerForSingleValueEvent ( new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                for (DataSnapshot dataSnapshot11 : dataSnapshot.getChildren ()) {
                    Users p = dataSnapshot11.getValue ( Users.class );

                    dataSnapshot11.getRef ().child ( "e________PassWord" ).setValue ( passWord.getText ().toString () );


                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        } );


        final FirebaseUser user = FirebaseAuth.getInstance ().getCurrentUser ();

// Get auth credentials from the user for re-authentication. The example below shows
// email and password credentials but there are multiple possible providers,
// such as GoogleAuthProvider or FacebookAuthProvider.
        AuthCredential credential = EmailAuthProvider.getCredential ( GlobalClass.answer1 + "@gmail.com", GlobalClass.oldold );

// Prompt the user to re-provide their sign-in credentials
        user.reauthenticate ( credential )
                .addOnCompleteListener ( new OnCompleteListener<Void> () {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful ()) {
                            user.updatePassword ( passWord.getText ().toString () ).addOnCompleteListener ( new OnCompleteListener<Void> () {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful ()) {
                                        Log.d ( "TAG", "Password updated" );
                                    } else {
                                        Log.d ( "TAG", "Error password not updated" );
                                    }
                                }
                            } );
                        } else {
                            Log.d ( "TAG", "Error auth failed" );
                        }
                    }
                } );


        Toast.makeText ( Main44Activity.this, " Your update was performed successfully", Toast.LENGTH_LONG ).show ();

    }

    public void update6(View view) {
        if (TextUtils.isEmpty (phone.getText ().toString () )) {
            Toast.makeText ( Main44Activity.this, "Enter Your Phone",
                    Toast.LENGTH_SHORT ).show ();
            phone.setError ( "Enter Your Phone" );
            return;
        }
        DatabaseReference reference = FirebaseDatabase.getInstance ().getReference ().child ( "Data" ).child ( "Members" );
        Query query = reference.orderByChild ( "b________Id" ).equalTo ( GlobalClass.answer1 );
        query.addListenerForSingleValueEvent ( new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                for (DataSnapshot dataSnapshot11 : dataSnapshot.getChildren ()) {
                    Users p = dataSnapshot11.getValue ( Users.class );

                    dataSnapshot11.getRef ().child ( "i________Phone" ).setValue ( phone.getText ().toString () );


                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        } );
        Toast.makeText ( Main44Activity.this, " Your update was performed successfully", Toast.LENGTH_LONG ).show ();
    }

    public void update7(View view) {
        if (TextUtils.isEmpty ( location.getText ().toString () )) {
            Toast.makeText ( Main44Activity.this, "Enter Your Location",
                    Toast.LENGTH_SHORT ).show ();
            location.setError ( "Enter Your Location" );
            return;
        }

        DatabaseReference reference = FirebaseDatabase.getInstance ().getReference ().child ( "Data" ).child ( "Members" );
        Query query = reference.orderByChild ( "b________Id" ).equalTo ( GlobalClass.answer1 );
        query.addListenerForSingleValueEvent ( new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                for (DataSnapshot dataSnapshot11 : dataSnapshot.getChildren ()) {
                    Users p = dataSnapshot11.getValue ( Users.class );
                    String first = p.getC________FirstName ();


                    dataSnapshot11.getRef ().child ( "j________Location" ).setValue ( location.getText ().toString () );


                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        } );
        Toast.makeText ( Main44Activity.this, " Your update was performed successfully", Toast.LENGTH_LONG ).show ();
    }


}