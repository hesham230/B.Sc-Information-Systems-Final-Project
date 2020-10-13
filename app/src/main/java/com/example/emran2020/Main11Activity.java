package com.example.emran2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
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

public class Main11Activity extends AppCompatActivity {
    DatabaseReference reference;
    RecyclerView recyclerView;
    ArrayList<Users> list;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main11 );

        choose ( GlobalClass.spinnerValue,GlobalClass.search);
    }

  public void choose(String spinnerValue,String value){
      switch(spinnerValue) {
          case "Id":
              searcBySpinner ( "b________Id", value );
              break;
          case "Registration Date ------> Sep 16, 2020":
              searcBySpinner ( "a________RegistrationDate", value );
              break;

          case "First Name":
              searcBySpinner ( "c________FirstName", value );
              break;
          case "Last Name":
              searcBySpinner ( "d________LastName", value );
              break;
          case "Gender ------> male/female":
              searcBySpinner ( "f________Gender", value );
              break;
          case "BirthDay ------> day/month/year":
              searcBySpinner ( "g________Birthday", value );
              break;
          case "Phone":
              searcBySpinner ( "i________Phone", value );
              break;
          case "Age":
              searcBySpinner ( "h________Age", value );
              break;
          case "Location":
              searcBySpinner ( "j________Location",value );
              break;
          default:
              Toast.makeText ( Main11Activity.this, "Please Choose which variable you want to search for", Toast.LENGTH_LONG ).show ();

              Intent my =new Intent ( Main11Activity.this , Main10Activity.class );
              startActivity ( my );




      }

  }
  public void searcBySpinner(final String spinnerValue , String value){
      recyclerView = (RecyclerView) findViewById ( R.id.myRecyclerrr );
      recyclerView.setLayoutManager ( new LinearLayoutManager ( this ) );

      reference = FirebaseDatabase.getInstance ().getReference ().child ( "Data" ).child ( "Members" );
      Query query = reference.orderByChild ( spinnerValue ).equalTo ( value );
      query.addListenerForSingleValueEvent ( new ValueEventListener () {
          @Override
          public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               if (dataSnapshot.exists ()) {


                  list = new ArrayList<Users> ();
                  for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren ()) {
                      Users p = dataSnapshot1.getValue ( Users.class );
                      list.add ( p );
                  }


                  adapter = new MyAdapter ( Main11Activity.this, list );
                  recyclerView.setAdapter ( adapter );
              }
              else{
                  String spinnerV=spinnerValue;
                  String text = "";
                  switch(spinnerV) {
                      
                      case "b________Id":
                          text= "Id" ;
                          break;

                      case "a________RegistrationDate":
                          text= "Registration Date" ;
                          break;

                      case "c________FirstName":
                          text="First Name";
                          break;

                      case "d________LastName":
                          text= "Last Name" ;
                          break;

                      case "f________Gender":
                          text= "Gender" ;
                          break;

                      case "g________Birthday":
                          text="BirthDay";
                          break;

                      case ":i________Phone":
                          text="Phone" ;
                          break;

                      case "h________Age":
                          text="Age";
                          break;

                      default:
                          text="location";
                  }
                  
           final Intent myy = new Intent ( Main11Activity.this, Main10Activity.class );


                      AlertDialog.Builder builder= new AlertDialog.Builder ( Main11Activity.this );
                      builder.setTitle ( "Message" );
                      builder.setMessage ( "This "+text+ " is not exists");
                      builder.setIcon ( R.drawable.sad);
                      builder.setPositiveButton ( "Ok", new DialogInterface.OnClickListener () {
                          @Override
                          public void onClick(DialogInterface dialog, int which) {
                              startActivity ( myy );
                          }
                      } );
                      builder.create ();
                      builder.show ();


              }


          }

          @Override
          public void onCancelled(@NonNull DatabaseError databaseError) {
              Toast.makeText ( Main11Activity.this, "Opsss.... Something is wrong", Toast.LENGTH_SHORT ).show ();
          }
      } );

  }

}