package com.example.emran2020;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;


public class Main16Activity extends AppCompatActivity  {


String date;
public PatientsTraining patientsTraining;


    TextView t1,t2,t3,t4,t5,t6;

   int [][] myArray1,myArray11,myArray2,myArray22,myArray3,myArray33,myArray4,myArray44,myArray5,myArray55,myArray6,myArray66;

    int ans1,ans2,ans3,ans4,ans5,ans6;

    String age7=GlobalClass.age;
    String gender8=GlobalClass.gender;


    int [] arr= { Integer.parseInt (GlobalClass.glucose) ,Integer.parseInt (GlobalClass.weight),
            Integer.parseInt (GlobalClass.heartbeat),Integer.parseInt (GlobalClass.bloodpressure),
            Integer.parseInt (age7),Integer.parseInt (GlobalClass.gettingmedic1),
            Integer.parseInt (GlobalClass.rislevel1),Integer.parseInt (gender8) };


    @Override    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main16 );


        t1=findViewById ( R.id.textView);
        t2=findViewById ( R.id.textView2);
        t3=findViewById ( R.id.textView4);
        t4=findViewById ( R.id.textView10);
        t5=findViewById ( R.id.textView11);
        t6=findViewById ( R.id.textView12);


        start1 ();

        ans1=(kindOf(myArray1,indexOfMin(check(myArray11,arr) , min(check(myArray11 ,arr )  ))));
        ans2=(kindOf(myArray2,indexOfMin(check(myArray22,arr) , min(check(myArray22 ,arr )  ))));
        ans3=(kindOf(myArray3,indexOfMin(check(myArray33,arr) , min(check(myArray33 ,arr )  ))));
        ans4=(kindOf(myArray4,indexOfMin(check(myArray44,arr) , min(check(myArray44 ,arr )  ))));
        ans5=(kindOf(myArray5,indexOfMin(check(myArray55,arr) , min(check(myArray55 ,arr )  ))));
        ans6=(kindOf(myArray6,indexOfMin(check(myArray66,arr) , min(check(myArray66 ,arr )  ))));


       String a= "1)Training of force free weight :\n"+ convert ( ans1 );
       String b= "2)Training of force rubber bar :\n"+ convert ( ans2 );
       String c= "3) Training of riding bikes :\n"+ convert ( ans3 );
       String d= "4) Training of riding elliptic :\n"+ convert ( ans4 );
       String e= "5) Training of riding growing :\n"+ convert ( ans5 );
       String f= "6) Training of riding walk :\n"+ convert ( ans6 );


       String a1="* Force Free Weight -> "+convertD ( ans1 );
       String b1="* TraForce Rubber Bar -> "+convertD ( ans2 );
       String c1="* Riding Bikes -> "+convertD ( ans3 );
       String d1="* Riding Elliptic -> "+convertD ( ans4 );
       String e1="* Riding Growing -> "+convertD ( ans5 );
       String f1="* Riding Walk -> "+convertD ( ans6 );

       GlobalClass.training1=a1;
       GlobalClass.training2=b1;
       GlobalClass.training3=c1;
       GlobalClass.training4=d1;
       GlobalClass.training5=e1;
       GlobalClass.training6=f1;



        t1.setText (  ( a)  );
        t2.setText (  ( b)  );
        t3.setText (  ( c)  );
        t4.setText (  ( d)  );
        t5.setText (  ( e)  );
        t6.setText (  ( f)  );

    }

    public String convert( int x){
        String result;
        if(x==1){
            result="You must do this workout";

        }
        else{
            result="You don't have to do this workout";

        }
        return result;
    }



    public String convertD( int x){
        String result;
        if(x==1){
            result="Yes";

        }
        else{
            result="No";

        }
        return result;
    }



    public void start1(){

        Classification c1 = new Classification ( getResources ().openRawResource ( R.raw.forcefreeweigth ) );
        Classification c11 = new Classification ( getResources ().openRawResource ( R.raw.forcefreeweigthwithoutlabel ) );

        Classification c2 = new Classification ( getResources ().openRawResource ( R.raw.forcerubberbar ) );
        Classification c22 = new Classification ( getResources ().openRawResource ( R.raw.forcerubberbarwithoutlabel ) );

        Classification c3 = new Classification ( getResources ().openRawResource ( R.raw.ridingbikes ) );
        Classification c33 = new Classification ( getResources ().openRawResource ( R.raw.ridingbikeswithoutlabel ) );

        Classification c4 = new Classification ( getResources ().openRawResource ( R.raw.ridingelepitic ) );
        Classification c44 = new Classification ( getResources ().openRawResource ( R.raw.ridingbikeswithoutlabel ) );

        Classification c5 = new Classification ( getResources ().openRawResource ( R.raw.ridingrowing ) );
        Classification c55 = new Classification ( getResources ().openRawResource ( R.raw.ridingrowingwithoutlabel ) );


        Classification c6 = new Classification ( getResources ().openRawResource ( R.raw.ridingwalk ) );
        Classification c66 = new Classification ( getResources ().openRawResource ( R.raw.ridingwalkwithoutlabel ) );

        myArray1=c1.read ();
        myArray11=c11.read ();

        myArray2=c2.read ();
        myArray22=c22.read ();

        myArray3=c3.read ();
        myArray33=c33.read ();

        myArray4=c4.read ();
        myArray44=c44.read ();

        myArray5=c5.read ();
        myArray55=c55.read ();

        myArray6=c6.read ();
        myArray66=c66.read ();

    }
    public int[] check(int[][] matrx, int[] arr) {
        int ky = 0;
        int[] answer = new int[matrx.length];


        for (int i = 0; i < matrx.length; i++) {
            for (int j = 0; j < matrx[i].length; j++) {
                answer[i] += Math.pow ( (matrx[i][j] - arr[j]), 2 );
            }
        }
        for (int key = 0; key < answer.length; key++) {
            answer[key] = (int) Math.sqrt ( answer[key] );
        }
        return answer;
    }


    public int min(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }

        }
        return min;
    }

    public int indexOfMin(int[] arr, int key) {
        int y = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != key) {
                continue;
            }
            y = i;

        }
        return y;

    }

    public int kindOf(int[][] list, int index) {
        int x = list[index][8];
        return x;

    }


    public void finish23(View view) {

        Calendar calendar=Calendar.getInstance ();
        date= DateFormat.getDateInstance ().format ( calendar.getTime () );


        patientsTraining= new PatientsTraining (date,GlobalClass.answer1,GlobalClass.firstName,GlobalClass.lastName,GlobalClass.gender1,
                GlobalClass.age,GlobalClass.glucose,GlobalClass.weight,GlobalClass.heartbeat,GlobalClass.bloodpressure,GlobalClass.gettingmedic2,GlobalClass.rislevel2,
                GlobalClass.training1,GlobalClass.training2,GlobalClass.training3,GlobalClass.training4,GlobalClass.training5,GlobalClass.training6);

        DatabaseReference Data = FirebaseDatabase.getInstance ().getReference ("Data").child ( "Patients Training" );
        Data.push ().setValue ( patientsTraining );



        android.app.AlertDialog.Builder builder= new AlertDialog.Builder ( Main16Activity.this );
        builder.setTitle ( "Message" );
        builder.setMessage ( "Thank You");
        builder.setIcon ( R.drawable.successfully1);
     builder.setPositiveButton ( "Thanks", new DialogInterface.OnClickListener () {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent =new Intent ( Main16Activity.this,Main5Activity.class );
                startActivity ( intent );

            }
        } );

        builder.create ();
        builder.show ();


    }





    }










