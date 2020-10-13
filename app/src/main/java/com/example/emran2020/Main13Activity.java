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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
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

import java.util.ArrayList;

public class Main13Activity extends AppCompatActivity {
    public EditText deleteId, deletePass;

    private static final String TAG = "Main13Activity";

    public FirebaseAuth auth;
    public FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main13 );


        deleteId = findViewById ( R.id.IdtoDelete );
        deletePass = findViewById ( R.id.v444 );

        auth = FirebaseAuth.getInstance ();
        user = auth.getCurrentUser ();


    }


    public void DeletetNotAll(View view) {


        String deleteIdd = deleteId.getText ().toString ();
        String deletePasss = deletePass.getText ().toString ();

        if (TextUtils.isEmpty ( deleteIdd ) && TextUtils.isEmpty ( deletePasss )) {
            deleteId.setError ( "enter Your Id" );
            deletePass.setError ( "Enter Your Password" );

            Toast.makeText ( Main13Activity.this, "Please Enter Details ", Toast.LENGTH_LONG ).show ();
            return;
        }
        if (TextUtils.isEmpty ( deleteIdd )) {
            Toast.makeText ( Main13Activity.this, "Enter Your Id",
                    Toast.LENGTH_SHORT ).show ();
            deleteId.setError ( "enter Your Id" );
            return;
        }

        if (TextUtils.isEmpty ( deletePasss )) {
            Toast.makeText ( Main13Activity.this, "Enter Your Pasword",
                    Toast.LENGTH_SHORT ).show ();
            deletePass.setError ( "Enter Your Password" );
            return;
        }

        if (deleteIdd.length () != 9) {
            Toast.makeText ( Main13Activity.this, "Your Id should be 9 numbers",
                    Toast.LENGTH_SHORT ).show ();
            deleteId.setError ( "Your Id should be 9 numbers" );
            return;
        }

        if (deletePasss.length () < 6) {
            Toast.makeText ( Main13Activity.this, "Your Password should be at least 6 numbers/characters",
                    Toast.LENGTH_SHORT ).show ();
            deletePass.setError ( "Your Password should be at least 6 numbers/characters" );
            return;
        }


        enterLoginn ();
    }


    public void enterLoginn() {

        final String id = deleteId.getText ().toString () + "@gmail.com";
        final String passs = deletePass.getText ().toString ();


        auth.signInWithEmailAndPassword ( id, passs )
                .addOnCompleteListener ( this, new OnCompleteListener<AuthResult> () {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful ()) {
                            final FirebaseUser userr = auth.getCurrentUser ();
                            // Sign in success, update UI with the signed-in user's information
                            Log.d ( TAG, "signInWithID:success" );



                            AlertDialog.Builder builder= new AlertDialog.Builder ( Main13Activity.this );
                            builder.setTitle ( "Message" );
                            builder.setMessage ( "Are you sure you want to delete this user ?!");
                            builder.setIcon ( R.drawable.questionmark);
                            builder.setNegativeButton ( "Yes", new DialogInterface.OnClickListener () {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    updateUIi ( userr );
                                }
                            } );
                            builder.setPositiveButton ( "Cancel",null );

                            builder.create ();
                            builder.show ();


                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w ( TAG, "signInWithEmail:failure", task.getException () );
                            AlertDialog.Builder builder= new AlertDialog.Builder ( Main13Activity.this );
                            builder.setTitle ( "Message" );
                            builder.setMessage ( "This user is not exist \n try again maybe ID or Password is rong ");
                            builder.setIcon ( R.drawable.sad);
                            builder.setPositiveButton ( "Ok", null);

                                   builder.create ();
                                  builder.show ();


                            return;
                        }

                        // ...
                    }
                } );

    }


    public void updateUIi(final FirebaseUser currentUser) {
        final String id = deleteId.getText ().toString () + "gmail.com";
        final String passs = deletePass.getText ().toString ();
        final FirebaseUser user = FirebaseAuth.getInstance ().getCurrentUser ();

        // Get auth credentials from the user for re-authentication. The example below shows
        // email and password credentials but there are multiple possible providers,
        // such as GoogleAuthProvider or FacebookAuthProvider.
        AuthCredential credential = EmailAuthProvider.getCredential ( id, passs );

        // Prompt the user to re-provide their sign-in credentials
        user.reauthenticate ( credential )
                .addOnCompleteListener ( new OnCompleteListener<Void> () {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        user.delete ()
                                .addOnCompleteListener ( new OnCompleteListener<Void> () {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful ()) {
                                            //DeleteData ();
                                            Log.d ( TAG, "User account deleted." );
                                            AlertDialog.Builder builder= new AlertDialog.Builder ( Main13Activity.this );
                                            builder.setTitle ( "Message" );
                                            builder.setMessage ( " User has been deleted successfully \n If you want delete a new ID press again on < Delete >");

                                            builder.setIcon ( R.drawable.successfully1);
                                            builder.setPositiveButton ( "Delete", new DialogInterface.OnClickListener () {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {

                                                    Intent my = new Intent ( Main13Activity.this, Main13Activity.class );
                                                    startActivity ( my );
                                                }
                                            } );

                                            builder.setNegativeButton ( "Thanks", new DialogInterface.OnClickListener () {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    Intent myy = new Intent ( Main13Activity.this, Main9Activity.class );
                                                    myy.putExtra ( "email ,", currentUser.getEmail () );
                                                    startActivity ( myy );


                                                }
                                            } );

                                            builder.create ();
                                            builder.show ();

                                        }
                                    }
                                } );

                    }
                } );


    }





    public void DeleteAll(View view) {
        DeleteData ();
        DeleteDataTraining ();
        DeleteLastSignIn();
        DeleteSatisfaction();





        String deleteIdd = deleteId.getText ().toString ();
        String deletePasss = deletePass.getText ().toString ();

        if (TextUtils.isEmpty ( deleteIdd ) && TextUtils.isEmpty ( deletePasss )) {
            deleteId.setError ( "enter Your Id" );
            deletePass.setError ( "Enter Your Password" );

            Toast.makeText ( Main13Activity.this, "Please Enter Details ", Toast.LENGTH_LONG ).show ();
            return;
        }
        if (TextUtils.isEmpty ( deleteIdd )) {
            Toast.makeText ( Main13Activity.this, "Enter Your Id",
                    Toast.LENGTH_SHORT ).show ();
            deleteId.setError ( "enter Your Id" );
            return;
        }

        if (TextUtils.isEmpty ( deletePasss )) {
            Toast.makeText ( Main13Activity.this, "Enter Your Password",
                    Toast.LENGTH_SHORT ).show ();
            deletePass.setError ( "Enter Your Password" );
            return;
        }

        if (deleteIdd.length () != 9) {
            Toast.makeText ( Main13Activity.this, "Your Id should be 9 numbers",
                    Toast.LENGTH_SHORT ).show ();
            deleteId.setError ( "Your Id should be 9 numbers" );
            return;
        }

        if (deletePasss.length () < 6) {
            Toast.makeText ( Main13Activity.this, "Your Password should be at least 6 numbers/characters",
                    Toast.LENGTH_SHORT ).show ();
            deletePass.setError ( "Your Password should be at least 6 numbers/characters" );
            return;
        }



        final String id = deleteId.getText ().toString () + "@gmail.com";
        final String passs = deletePass.getText ().toString ();



        DatabaseReference reference = FirebaseDatabase.getInstance ().getReference ().child ( "Data" ).child ( "Members" );
        Query query = reference.orderByChild ( "b________Id" ).equalTo ( id );
        query.addListenerForSingleValueEvent ( new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(!(dataSnapshot.exists ())){
                    GlobalClass.checkin=false;
                    AlertDialog.Builder builder= new AlertDialog.Builder ( Main13Activity.this );
                    builder.setTitle ( "Message" );
                    builder.setMessage ( "Youu deleted this user and left only his data!!\n are e you sure you want to continue to delete his data ?!" );
                    builder.setIcon ( R.drawable.questionmark);
                    builder.setNegativeButton ( "yes", new DialogInterface.OnClickListener () {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText ( Main13Activity.this, "Data deleted successfully",
                                    Toast.LENGTH_SHORT ).show ();


                        }
                    }


                    );

                    builder.setPositiveButton ( "cancel",null );
                    builder.create ();
                    builder.show ();


                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        } );





    if(GlobalClass.checkin!=false) {


         auth.signInWithEmailAndPassword ( id, passs )
            .addOnCompleteListener ( this, new OnCompleteListener<AuthResult> () {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful ()) {
                        final FirebaseUser userr = auth.getCurrentUser ();
                        // Sign in success, update UI with the signed-in user's information
                        Log.d ( TAG, "signInWithID:success" );


                        AlertDialog.Builder builder = new AlertDialog.Builder ( Main13Activity.this );
                        builder.setTitle ( "Message" );
                        builder.setMessage ( "Are you sure you want to delete this user ?!" );
                        builder.setIcon ( R.drawable.questionmark );
                        builder.setNegativeButton ( "Yes", new DialogInterface.OnClickListener () {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {


                                updateUIi ( userr );
                            }
                        } );
                        builder.setPositiveButton ( "Cancel", null );

                        builder.create ();
                        builder.show ();


                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w ( TAG, "signInWithEmail:failure", task.getException () );
                        AlertDialog.Builder builder = new AlertDialog.Builder ( Main13Activity.this );
                        builder.setTitle ( "Message" );
                        builder.setMessage ( "This user is not exist \n try again maybe ID or Password is wrong " );
                        builder.setIcon ( R.drawable.sad );
                        builder.setPositiveButton ( "Ok", null );

                        builder.create ();
                        builder.show ();


                        return;
                    }

                    // ...
                }
            } );


}











    }




    public void DeleteData() {

        final String id = deleteId.getText ().toString ();
        DatabaseReference reference = FirebaseDatabase.getInstance ().getReference ().child ( "Data" ).child ( "Members" );
        Query query = reference.orderByChild ( "b________Id" ).equalTo ( id );
        query.addListenerForSingleValueEvent ( new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot dataSnapshot88 : dataSnapshot.getChildren ()) {
                    Users p = dataSnapshot88.getValue ( Users.class );
                    dataSnapshot88.getRef ().removeValue ();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        } );
    }


    public void DeleteDataTraining() {
        final String email = deleteId.getText ().toString ();
        DatabaseReference reference = FirebaseDatabase.getInstance ().getReference ().child ( "Data" ).child ( "Patients Training" );
        Query query = reference.orderByChild ( "b________Id" ).equalTo ( email );
        query.addListenerForSingleValueEvent ( new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot88 : dataSnapshot.getChildren ()) {
                    PatientsTraining p = dataSnapshot88.getValue ( PatientsTraining.class );
                    dataSnapshot88.getRef ().removeValue ();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        } );
    }
    public void DeleteSatisfaction() {
        final String email = deleteId.getText ().toString ();
        DatabaseReference reference = FirebaseDatabase.getInstance ().getReference ().child ( "Data" ).child ( "Satisfaction Of Patients"  );
        Query query = reference.orderByChild ( "id" ).equalTo ( email );
        query.addListenerForSingleValueEvent ( new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot88 : dataSnapshot.getChildren ()) {
                    PatientsTraining p = dataSnapshot88.getValue ( PatientsTraining.class );
                    dataSnapshot88.getRef ().removeValue ();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        } );
    }


    public void DeleteLastSignIn() {
        final String email = deleteId.getText ().toString ();

        DatabaseReference data = FirebaseDatabase.getInstance ().getReference ( "LastSignIn" ).child ( "Members" );
        Query query = data.orderByChild ( "id" ).equalTo ( email );
        query.addListenerForSingleValueEvent ( new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot88 : dataSnapshot.getChildren ()) {
                    PatientsTraining p = dataSnapshot88.getValue ( PatientsTraining.class );
                    dataSnapshot88.getRef ().removeValue ();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        } );
    }



}


