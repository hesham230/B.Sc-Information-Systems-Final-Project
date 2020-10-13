package com.example.emran2020;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class TrainingAdapter extends RecyclerView.Adapter<TrainingAdapter.MyViewHolder> {

    Context context;
    ArrayList<PatientsTraining> profiles;

    public TrainingAdapter(Context c, ArrayList<PatientsTraining> p) {
        context = c;
        profiles = p;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder ( LayoutInflater.from ( context ).inflate ( R.layout.activity_training_view, parent, false ) );
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.date1.setText ("Date: "+ profiles.get ( position ).getA________EntryDate ());
            holder.id.setText ("Id:   "+ profiles.get ( position ).getB________Id ());
            holder.firstName.setText ("First Name:   "+profiles.get ( position ).getC________FirstName () );
            holder.lastName.setText ( "LastName:   "+profiles.get ( position ).getD________lastName () );
            holder.value1.setText ("Gender: "+profiles.get ( position ).getE________Gender ());
            holder.value2.setText ("Age: "+profiles.get ( position ).getF________Age ());
            holder.value3.setText ("Glucose: "+profiles.get ( position ).getG________Glucose ());
            holder.value4.setText ("Weight: "+profiles.get ( position ).getH________Weight ());
            holder.value5.setText ("HeartBeat: "+profiles.get ( position ).getI________HeartBeat ());
            holder.value6.setText ("Blood pressure: "+profiles.get ( position ).getJ________BloodPressure ());
            holder.value7.setText ("Getting medication: "+profiles.get ( position ).getK________GettingMedication ());
            holder.value8.setText ("Risk level: "+profiles.get ( position ).getL________RiskLevel ());

            holder.training1.setText ("Training1:   "+profiles.get ( position ).getTraining1 () );
            holder.training2.setText ("Training2:   "+ profiles.get ( position ).getTraining2 () );
            holder.training3.setText ("Training3:   "+ profiles.get ( position ).getTraining3 () );
            holder.training4.setText ("Training4:   "+ profiles.get ( position ).getTraining4 () );
            holder.training5.setText ("Training5:   "+ profiles.get ( position ).getTraining5 () );
            holder.training6.setText ("Training6:   "+profiles.get ( position ).getTraining6 () );
}


    @Override
    public int getItemCount() {


        return profiles.size ();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
    TextView date1,id,firstName, lastName,training1 ,training2,training3,training4,training5,training6,
            value1, value2, value3, value4, value5, value6, value7, value8;


       public MyViewHolder(View itemView) {
        super ( itemView );

        date1 = (TextView) itemView.findViewById ( R.id.textView23 );
        id = (TextView) itemView.findViewById ( R.id.textView32);
        firstName = (TextView) itemView.findViewById ( R.id.textView30 );
        lastName = (TextView) itemView.findViewById ( R.id.textView3);


        value1 = (TextView) itemView.findViewById ( R.id.textView29);
        value2 = (TextView) itemView.findViewById ( R.id.textView40);
        value3 = (TextView) itemView.findViewById ( R.id.textView39);
        value4 = (TextView) itemView.findViewById ( R.id.textView44);
        value5 = (TextView) itemView.findViewById ( R.id.textView42);
        value6 = (TextView) itemView.findViewById ( R.id.textView43);
        value7= (TextView) itemView.findViewById ( R.id.textView41);
        value8 = (TextView) itemView.findViewById ( R.id.textView45);


        training1 = (TextView) itemView.findViewById ( R.id.textView52 );
        training2 = (TextView) itemView.findViewById ( R.id.textView51 );
        training3 = (TextView) itemView.findViewById ( R.id.textView53);
        training4 = (TextView) itemView.findViewById ( R.id.textView54);
        training5 = (TextView) itemView.findViewById ( R.id.textView56 );
        training6 = (TextView) itemView.findViewById ( R.id.textView55 );

        }
    }
}