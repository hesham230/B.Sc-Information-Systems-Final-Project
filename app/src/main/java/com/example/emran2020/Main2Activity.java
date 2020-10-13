package com.example.emran2020;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.Calendar;
public class Main2Activity extends AppCompatActivity {
    String date;

    EditText newId,newFullName,newPassWord,newBirthday, newPhone ,newLocation;
    RadioButton rd1, rd2;
    private FirebaseDatabase database;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private static final String USER = "user";
    private static final String TAG = "RegisterActivity";
    public Users members;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main2 );

      Calendar calendar=Calendar.getInstance ();
       final int year=calendar.get(Calendar.YEAR);
        final int mon=calendar.get(Calendar.MONTH);
        final int day=calendar.get(Calendar.DAY_OF_MONTH);

        rd1=findViewById ( R.id.radioButton3 );
        rd2=findViewById ( R.id.radioButton4 );
        newId = findViewById ( R.id.newId );
        newFullName=findViewById ( R.id.newFullName );
        newPassWord = findViewById ( R.id.newPassWord );
        newBirthday=findViewById ( R.id.newBirthday );
        newPhone = findViewById ( R.id.newPhone );
        newLocation=findViewById ( R.id.newLocation );

        database = FirebaseDatabase.getInstance ();
        mDatabase = database.getReference ( "Data" ).child ( "Members" );
        mAuth = FirebaseAuth.getInstance ();

        newBirthday.setOnClickListener ( new View.OnClickListener () {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                DatePickerDialog datePicker=new DatePickerDialog ( Main2Activity.this, new DatePickerDialog.OnDateSetListener () {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        int m=month+1;
                        newBirthday.setText(dayOfMonth+ "/" + m + "/" + year);

                    }

                }, year ,mon,day);
                datePicker.setTitle ( "   Choose Date " );
                datePicker.show ();
            }
        } );

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void enterRegister(View view) {
        String gender;

        Calendar calendar=Calendar.getInstance ();
        date= DateFormat.getDateInstance ().format ( calendar.getTime () );

        String id = newId.getText ().toString ();
        String id2 = newId.getText ().toString ()+"@gmail.com";
        String  birthday=newBirthday.getText ().toString ();
        String  birthday1=newBirthday.getText ().toString ();
        String fullName = newFullName.getText ().toString ();
        String password = newPassWord.getText ().toString ();




        if (rd1.isChecked () == false && rd2.isChecked () == false) {
            Toast.makeText ( this, "Please Choose Answer", Toast.LENGTH_LONG ).show ();
            return;

        }
        if (rd1.isChecked ()) {
            gender="male";
        }
        else{
            gender="female";
        }



        String phone = newPhone.getText ().toString ();
        String location = newLocation.getText ().toString ();

        if (TextUtils.isEmpty ( id )&& TextUtils.isEmpty ( password )&&TextUtils.isEmpty ( fullName )&&TextUtils.isEmpty ( birthday1 )
                && TextUtils.isEmpty ( location )&&TextUtils.isEmpty ( phone)) {
            newId.setError ( "enter Your Id" );
            newFullName.setError ( "Enter Your Full Name" );
            newPassWord.setError ( "Enter Your Password" );

            newBirthday.setError ( "Enter Your Birthday" );
            newPhone.setError ( "Enter Your Phone" );
            newLocation.setError ( "Enter Your Location" );
            Toast.makeText ( Main2Activity.this, "Please Enter Details ", Toast.LENGTH_LONG ).show ();
            return;
        }

        if (TextUtils.isEmpty ( id )){
            Toast.makeText ( Main2Activity.this, "Enter Your Id",
                    Toast.LENGTH_SHORT ).show ();
            newId.setError ( "enter Your Id" );
            return;}


        if (TextUtils.isEmpty ( fullName )){
            Toast.makeText ( Main2Activity.this, "Enter Your Full Name",
                    Toast.LENGTH_SHORT ).show ();
            newFullName.setError ( "Enter Your Full Name" );
            return;
        }


        if ( TextUtils.isEmpty ( password )) {
            Toast.makeText ( Main2Activity.this, "Enter Your Pasword",
                    Toast.LENGTH_SHORT ).show ();
            newPassWord.setError ( "Enter Your Password" );
            return;
        }


        if (TextUtils.isEmpty ( birthday)) {
            Toast.makeText ( Main2Activity.this, "Enter Your Birthdhay",
                    Toast.LENGTH_SHORT ).show ();
            newBirthday.setError ( "Enter Your Birthday" );
            return;
        }

        if (TextUtils.isEmpty ( phone)) {
            newPhone.setError ( "Enter Your Phone" );
            Toast.makeText ( Main2Activity.this, "Enter Your phone",
                    Toast.LENGTH_SHORT ).show ();
            return;
        }

        if (TextUtils.isEmpty ( location )) {
            Toast.makeText ( Main2Activity.this, "Enter Your Location",
                    Toast.LENGTH_SHORT ).show ();
            newLocation.setError ( "Enter Your Location" );
            return;
        }


        if(!(fullName.contains ( " " )))  {
            Toast.makeText ( Main2Activity.this, "Enter Your Full Name for example : \n firstName lastName",
                    Toast.LENGTH_SHORT ).show ();
            newFullName.setError ("Enter Your Full Name for example : \n firstName lastName" );
            return;
        }




        if(id.length ()!=9){
            Toast.makeText ( Main2Activity.this, "Your Id should be 9 numbers",
                    Toast.LENGTH_SHORT ).show ();
            newId.setError (  "Your Id should be 9 numbers" );
            return;
        }

        if(password.length ()<6){
            Toast.makeText ( Main2Activity.this, "Your Password should be at least 6 numbers/characters",
                    Toast.LENGTH_SHORT ).show ();
            newPassWord.setError ( "Your Password should be at least 6 numbers/characters" );
            return;
        }



        if(phone.length ()<7){
            Toast.makeText ( Main2Activity.this, "Your Password should be at least 6 numbers/characters",
                    Toast.LENGTH_SHORT ).show ();
            newPhone.setError ( "Your Phone should be at least 7 numbers" );
            return;
        }
        int Count=0;
        boolean check=false;
        for(int m=0 ; m<birthday.length (); m++){
            if(birthday.charAt ( m)=='/'){
                Count++;

            }
        }
        if(Count==2){


        if(birthday.length ()==8 || birthday.length ()==9 || birthday.length ()==10 ) {

            if ((birthday.charAt ( 1 ) == '/' && birthday.charAt ( 3 ) == '/')
                    || (birthday.charAt ( 2 ) == '/' && birthday.charAt ( 4 ) == '/')
                    || (birthday.charAt ( 2 ) == '/' && birthday.charAt ( 5 ) == '/')
                    || (birthday.charAt ( 1 ) == '/' && birthday.charAt ( 4 ) == '/')) {
                check = true;
            } else {
                check = false;
            }
        }



        }
        else{
            Toast.makeText ( Main2Activity.this, "enter a correct date :\n dat/month/year ",
                    Toast.LENGTH_SHORT ).show ();
            newBirthday.setError ( "enter a correct date " );

        }



        if(check==false){
            Toast.makeText ( Main2Activity.this, "enter a correct date :\n dat/month/year ",
                    Toast.LENGTH_SHORT ).show ();
            newBirthday.setError ( "enter a correct date " );
            return;
        }




        String first = "";
        String last = "";
        int key = 0;

        for (int i = 0; i < fullName.length (); i++) {
            if (fullName.charAt ( i ) != ' ') {
                first += fullName.charAt ( i );
            } else {
                key = i;
                break;
            }
        }
        for (int j = key + 1; j < fullName.length (); j++) {
            last += fullName.charAt ( j );
        }

        if( last.contains ( " " ) ){

            Toast.makeText ( Main2Activity.this, "Enter Your lastName",
                    Toast.LENGTH_SHORT ).show ();
            newFullName.setError ("Enter Your  lastName" );
            return;
        }

        if(last.length ()<2 ){

            Toast.makeText ( Main2Activity.this, "Enter Your lastName",
                    Toast.LENGTH_SHORT ).show ();
            newFullName.setError ("Enter Your  lastName" );
            return;
        }

        String age1="";
        int count=0;
        int k1=0;
        for(int k=0 ;k<birthday.length ();k++){
            if(count==2){
                k1=k;
                break;
            }
            if (birthday.charAt ( k ) == '/') {
                count++;
            }
        }

        if(age1.length ()>4){
            Toast.makeText ( Main2Activity.this, "enter a correct date :\n dat/month/year ",
                    Toast.LENGTH_SHORT ).show ();
            newBirthday.setError ( "enter a correct date " );


        }

        for(int v=k1;v<birthday.length ();v++){
            age1 += birthday.charAt ( v);
        }




        int year= Calendar.getInstance().get(Calendar.YEAR);



        int age=(year-Integer.parseInt ( age1 ));




        members = new Users (date,id,first,last,password,gender,birthday1,String.valueOf ( age ),phone,location);



        registerUser ( id2, password);
        DatabaseReference data = FirebaseDatabase.getInstance ().getReference ( "LastSignIn" ).child ( "Members" );
        data.setValue (members );


    }

    public void registerUser(String email, String password) {
        mAuth.createUserWithEmailAndPassword ( email, password )
                .addOnCompleteListener ( this, new OnCompleteListener<AuthResult> () {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful ()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d ( TAG, "createUserWithEmail:success" );
                            FirebaseUser user = mAuth.getCurrentUser ();
                            updateUI ( user );
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w ( TAG, "createUserWithEmail:failure", task.getException () );
                            Toast.makeText ( Main2Activity.this, "Authentication failed \n this id is already exists",
                                    Toast.LENGTH_SHORT ).show ();

                        }


                    }
                } );

    }

    public void updateUI(FirebaseUser currentUser) {
        String keyId = mDatabase.push ().getKey ();
        mDatabase.child ( keyId ).setValue ( members );


        Intent my = new Intent ( Main2Activity.this, MainActivity.class );
        startActivity ( my );
    }
}


;