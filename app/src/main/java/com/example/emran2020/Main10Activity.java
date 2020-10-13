package com.example.emran2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Main10Activity extends AppCompatActivity {

    EditText answer;
    Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main10 );
        answer = findViewById ( R.id.editText1000 );
        spinner=findViewById ( R.id.spinner );




    }

    public void search(View view) {

        String text = spinner.getSelectedItem().toString();
        String Answer=answer.getText ().toString ();



        if (TextUtils.isEmpty (  Answer )){
            answer.setError ( "Insert her a value" );
            return;}

        GlobalClass.search=Answer;
        GlobalClass.spinnerValue=text;


        Intent myy = new Intent ( Main10Activity.this, Main11Activity.class );

        startActivity ( myy );
    }

}
