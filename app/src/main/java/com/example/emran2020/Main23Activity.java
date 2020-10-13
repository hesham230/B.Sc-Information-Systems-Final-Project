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

public class Main23Activity extends AppCompatActivity {

    EditText answer;
    Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main23);
        answer = findViewById ( R.id.editText99 );
        spinner=findViewById ( R.id.spinner2 );
    }

    public void Search123(View view) {
        String text = spinner.getSelectedItem().toString();
        String Answer=answer.getText ().toString ();

        if (TextUtils.isEmpty (  Answer )){
            answer.setError ( "Insert her a value" );
            return;
        }

        GlobalClass.search1=Answer;
        GlobalClass.spinnerValue1=text;


        Intent myy = new Intent ( Main23Activity.this, Main22Activity.class );

        startActivity ( myy );
    }
}
