package com.example.emran2020;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class AdapterP2 extends RecyclerView.Adapter<AdapterP2.MyViewHolder> {

    Context context;
    ArrayList<PatientsTraining> profiles;

    public AdapterP2(Context c, ArrayList<PatientsTraining> p) {
        context = c;
        profiles = p;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder ( LayoutInflater.from ( context ).inflate ( R.layout.activity_patient_training_profile, parent, false ) );
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.date1.setText ("Date: "+ profiles.get ( position ).getA________EntryDate ());
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
        TextView date1,training1 ,training2,training3,training4,training5,training6,
                value1, value2, value3, value4, value5, value6, value7, value8;


        public MyViewHolder(View itemView) {
            super ( itemView );

            date1 = (TextView) itemView.findViewById ( R.id.textView122 );

            value1 = (TextView) itemView.findViewById ( R.id.textView73);
            value2 = (TextView) itemView.findViewById ( R.id.textView74);
            value3 = (TextView) itemView.findViewById ( R.id.textView75);
            value4 = (TextView) itemView.findViewById ( R.id.textView76);
            value5 = (TextView) itemView.findViewById ( R.id.textView77);
            value6 = (TextView) itemView.findViewById ( R.id.textView78);
            value7= (TextView) itemView.findViewById ( R.id.textView79);
            value8 = (TextView) itemView.findViewById ( R.id.textView81);


            training1 = (TextView) itemView.findViewById ( R.id.textView123 );
            training2 = (TextView) itemView.findViewById ( R.id.textView128 );
            training3 = (TextView) itemView.findViewById ( R.id.textView127);
            training4 = (TextView) itemView.findViewById ( R.id.textView129);
            training5 = (TextView) itemView.findViewById ( R.id.textView130 );
            training6 = (TextView) itemView.findViewById ( R.id.textView131 );

        }
    }
}