package com.example.emran2020;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Calendar;

public class Main3Activity extends AppCompatActivity {

    TextView textq;
    RadioButton rd1, rd2;
    public int i = 0;
    public int key;
    Button bFinish;
    int count = 0;
    String[][] question = new String[5][3];
    String[] arr = {"Yes", "Yes", "Yes", "Yes", "Yes", "Yes"};
    int[] result = new int[5];
    TextView hi ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main3 );
        hi=findViewById ( R.id.hi );
        hi.setText ("Hi"+" "+GlobalClass.firstName+" "+GlobalClass.lastName);





        textq = findViewById ( R.id.textq );
        rd1 = findViewById ( R.id.rd1 );
        rd2 = findViewById ( R.id.rd2 );
        bFinish = findViewById ( R.id.finishId );

        question[0][0] = "Do you have pain and fatigue??";
        question[0][1] = "Yes";
        question[0][2] = "No";

        question[1][0] = "Are you coughing?";
        question[1][1] = "Yes";
        question[1][2] = "No";

        question[2][0] = "Is your temperature above 38 degrees or have you had a fever in the last week?";
        question[2][1] = "Yes";
        question[2][2] = "No";

        question[3][0] = "Have you been in contact with a corona patient in the past week?";
        question[3][1] = "Yes";
        question[3][2] = "No";


        question[4][0] = "Do you have shortness of breath or difficulty breathing?";
        question[4][1] = "Yes";
        question[4][2] = "No";

        textq.setText ( question[i][0] );
        rd1.setText ( question[i][1] );
        rd2.setText ( question[i][2] );

    }

    public void EnterNext(View view) {

        if (rd1.isChecked () == false && rd2.isChecked () == false) {
            Toast.makeText ( this, "Please Choose Answer", Toast.LENGTH_LONG ).show ();
        } else {
            if (i <= 4) {
                String answer = null;
                int s = 0;
                if (rd1.isChecked ()) {
                    answer = rd1.getText ().toString ();
                    s = 1;
                } else {
                    answer = rd1.getText ().toString ();
                    s = 2;
                }
                result[i] = s;

                if(s==1){
                    count++;
                }


            }


            if (i == 4) {
                Toast.makeText ( this, "This Last question", Toast.LENGTH_LONG ).show ();
                bFinish.setVisibility ( View.VISIBLE );
            } else {
//
//                rd2.setChecked ( false );
//                rd1.setChecked ( false );

                i++;


                textq.setText ( question[i][0] );
                rd1.setText ( question[i][1] );
                rd2.setText ( question[i][2] );
            }
        }
    }


    public void EnterPrevious(View view) {
        bFinish.setVisibility ( View.INVISIBLE );

        if (i == 0) {
            Toast.makeText ( this, "This First Question", Toast.LENGTH_LONG ).show ();

        } else {
            i--;
            textq.setText ( question[i][0] );
            rd1.setText ( question[i][1] );
            rd2.setText ( question[i][2] );

            if (result[i] == 1)
                rd1.setChecked ( true );
            else {
                rd2.setChecked ( true );

            }

        }
    }

    public void EnterFinsh1(View view) {

        if (count > 0) {
            check ();


            android.app.AlertDialog.Builder builder = new AlertDialog.Builder ( Main3Activity.this );
            builder.setTitle ( "Massage" );
            builder.setMessage ( "Sorry you can't Continue pleasse Go To the Doctor" );

            builder.setIcon ( R.drawable.dan );
            builder.setPositiveButton ( "Thanks", new DialogInterface.OnClickListener () {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent my = new Intent ( Main3Activity.this, Main5Activity.class );
                    startActivity ( my );

                }
            } );

            builder.create ();
            builder.show ();
        }
        else{


                Intent my = new Intent ( Main3Activity.this, Main15Activity.class );
                startActivity ( my );
            }
        }
        public void check (){
            String content="";
            for(int i=0 ; i <result.length;i++){
            if(result[i]==1){
               content+=question[i][0]+"\n";
            }

        }
            Calendar calendar=Calendar.getInstance ();
            String date= DateFormat.getDateInstance ().format ( calendar.getTime () );

            String content1="This patient cannot exercise because he has: \n";

            if(content.contains ( "fatigue" )){
                content1+= "* pain and fatigue \n";


            }
            if(content.contains ( "coughing" )){
                content1+="* coughing \n";


            }
             if(content.contains ( "difficulty" )){
                 content1+="* shortness of breath or difficulty breathing \n" ;
            }
             if (content.contains ( "38")) {
                 content1+="* temperature above 38 degrees or have you had a fever in the last week \n" ;

            }
             if(content.contains ( "corona" )){
                 content1+="* contact with a corona patient in the past week";

            }


            messages message=new messages (date,GlobalClass.answer4,GlobalClass.firstName,GlobalClass.lastName,GlobalClass.phone,content1);

            processingMessage processingMessage=new processingMessage (date,GlobalClass.answer4,GlobalClass.firstName,GlobalClass.lastName
                    ,GlobalClass.phone,content1 ,"no");


            DatabaseReference reference = FirebaseDatabase.getInstance ().getReference ().child ( "Messages" ).child ( "All messages" );
            reference.push ().setValue ( message);

            DatabaseReference referencee = FirebaseDatabase.getInstance ().getReference ().child ( "Messages" ).child ( "Processing messages" );
            referencee.push ().setValue ( processingMessage);



        }


}



