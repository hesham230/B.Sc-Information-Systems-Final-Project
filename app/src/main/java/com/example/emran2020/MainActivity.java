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

public class MainActivity extends AppCompatActivity {
    public   EditText passWord, user;



    public FirebaseAuth mAuthh;


    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        user = findViewById ( R.id.userNameId );
        passWord = findViewById ( R.id.passWordId );
        mAuthh = FirebaseAuth.getInstance ();


    }
    public void registerEnter(View view) {


        Intent my = new Intent ( MainActivity.this, Main2Activity.class );
        startActivity ( my );
    }

    public void enterLoginn(View view) {
         final String email = user.getText ().toString ()+"@gmail.com";
         final String Id=user.getText ().toString ();
         final String passs = passWord.getText ().toString ();
        GlobalClass.answer4=Id;


        if (TextUtils.isEmpty ( email ) || TextUtils.isEmpty ( passs )) {
            Toast.makeText ( getApplicationContext (), "Enter Your Email and Password", Toast.LENGTH_LONG ).show ();
            return;
        }

        mAuthh.signInWithEmailAndPassword ( email, passs )
                .addOnCompleteListener ( this, new OnCompleteListener<AuthResult> () {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful ()) {

                           GlobalClass.answer1=Id;
                           GlobalClass.oldold=passs;


                           GlobalClass.answer3=email;

                            // Sign in success, update UI with the signed-in user's information
                            Log.d ( TAG, "signInWithEmail:success" );


                            FirebaseUser user = mAuthh.getCurrentUser ();

                            updateUIi ( user );

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w ( TAG, "signInWithEmail:failure", task.getException () );


                               AlertDialog.Builder builder= new AlertDialog.Builder ( MainActivity.this );
                                                        builder.setTitle ( "Message" );
                                                        builder.setMessage ( "This user is not exist \n try again maybe ID or Password is wrong ");
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

//    @Override
//    public void onStart() {
//        super.onStart ();
//        // Check if user is signed in (non-null) and update UI accordingly.
//        FirebaseUser currentUser = mAuthh.getCurrentUser ();
//        if (currentUser != null) {
//            updateUIi ( currentUser );
//        }
//
//    }

    public void updateUIi(final FirebaseUser currentUser) {
        final String emaill = user.getText ().toString ();

        DatabaseReference reference = FirebaseDatabase.getInstance ().getReference ().child ( "Data" ).child ( "Members" );
        Query query = reference.orderByChild ( "b________Id" ).equalTo (emaill);
        query.addListenerForSingleValueEvent ( new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot11 : dataSnapshot.getChildren ()) {
                    Users p = dataSnapshot11.getValue ( Users.class );
                    String firstName = dataSnapshot11.child ( "c________FirstName" ).getValue ().toString ();
                    String lastName = dataSnapshot11.child ( "d________LastName" ).getValue ().toString ();
                    String age = dataSnapshot11.child ( "h________Age" ).getValue ().toString ();
                    String gender = dataSnapshot11.child ( "f________Gender" ).getValue ().toString ();
                    String phone = dataSnapshot11.child ( "i________Phone" ).getValue ().toString ();
                    GlobalClass.age = age;
                    if (gender.equals ( "male" )) {
                        GlobalClass.gender = "0";
                        GlobalClass.gender1 = "male";
                    } else {
                        GlobalClass.gender = "1";
                        GlobalClass.gender1 = "female";
                    }
                    GlobalClass.firstName = firstName;
                    GlobalClass.lastName = lastName;


                    GlobalClass.phone=phone;

                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        } );




            Intent myy = new Intent ( MainActivity.this, Main27Activity.class );
            myy.putExtra ( "email ,", currentUser.getEmail () );
            startActivity ( myy );

    }







}



