package com.example.emran2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class Main36Activity extends AppCompatActivity {


    EditText answer;
    Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main36);
        answer = findViewById ( R.id.editText999 );
        spinner=findViewById ( R.id.spinner3 );
    }

    public void Search123123(View view) {
        String text = spinner.getSelectedItem().toString();
        String Answer=answer.getText ().toString ();

        if (TextUtils.isEmpty (  Answer )){
            answer.setError ( "Insert her a value" );
            return;
        }

        GlobalClass.search2=Answer;
        GlobalClass.spinnerValue2=text;


        Intent myy = new Intent ( Main36Activity.this, Main35Activity.class );

        startActivity ( myy );
    }
}