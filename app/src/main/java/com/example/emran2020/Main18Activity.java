package com.example.emran2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Main18Activity extends AppCompatActivity {
    EditText value77;
    String risk;
    RadioButton r7,r8,r9 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main18 );
        r7=findViewById ( R.id.radioButton );
        r8=findViewById ( R.id.radioButton2 );
        r9=findViewById ( R.id.radioButton7 );







    }

    public void finish1(View view) {


        if (r7.isChecked () == false && r8.isChecked () == false && r9.isChecked () == false) {
            Toast.makeText ( Main18Activity.this, "Please choose answer?",
                    Toast.LENGTH_SHORT ).show ();

            return;
        }


        if(r7.isChecked ()){
            GlobalClass.rislevel1="1";
            GlobalClass.rislevel2="Low";

        }
        else if(r8.isChecked ()){
            GlobalClass.rislevel1="2";
            GlobalClass.rislevel2="Medium";
        }
        else{
            GlobalClass.rislevel1="3";
            GlobalClass.rislevel2="High";
        }






        Intent intent = new Intent ( Main18Activity.this ,Main16Activity.class );
        startActivity ( intent );
    }

    public void previous2(View view) {
        Intent intent = new Intent ( Main18Activity.this ,Main17Activity.class );
        startActivity ( intent );

    }
}
