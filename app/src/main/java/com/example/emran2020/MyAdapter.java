package com.example.emran2020;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<Users> profiles;

    public MyAdapter(Context c, ArrayList<Users> p) {
        context = c;
        profiles = p;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder ( LayoutInflater.from ( context ).inflate ( R.layout.cardview, parent, false ) );
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.date.setText ("Registration Date:   " +profiles.get ( position ).getA________RegistrationDate ());
        holder.id.setText ("Id:   "+ profiles.get ( position ).getB________Id () );
        holder.firstName.setText ("First name:   "+ profiles.get ( position ).getC________FirstName () );
        holder.lastName.setText ( "Last name:   "+profiles.get ( position ).getD________LastName () );
        holder.pass.setText ("Password:   "+ profiles.get ( position ).getE________PassWord ());
        holder.gender.setText ("Gender:   "+ profiles.get ( position ).getF________Gender ());
        holder.birthday.setText ("Birthday:   "+ profiles.get ( position ).getG________Birthday ());
        holder.age.setText ( "Age:   "+profiles.get ( position ).getH________Age () );
        holder.phone.setText ("Phone:   "+ profiles.get ( position ).getI________Phone () );
        holder.location.setText ("Location:   "+ profiles.get ( position ).getJ________Location ());

    }

    @Override
    public int getItemCount() {
        return profiles.size ();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView date,id, firstName,lastName,pass, gender,birthday,age, phone, location;

        public MyViewHolder(View itemView) {
            super ( itemView );
            date = (TextView) itemView.findViewById ( R.id.textView5);
            id = (TextView) itemView.findViewById ( R.id.textView7 );
            firstName = (TextView) itemView.findViewById ( R.id.textView6 );
            lastName = (TextView) itemView.findViewById ( R.id.textView8);
            pass = (TextView) itemView.findViewById ( R.id.textView9);
            gender = (TextView) itemView.findViewById ( R.id.textView24);
            birthday = (TextView) itemView.findViewById ( R.id.textView26 );
            age=(TextView)itemView.findViewById ( R.id.textView27 );
            phone = (TextView) itemView.findViewById ( R.id.textView28 );
           location = (TextView) itemView.findViewById ( R.id.textView31);

        }
    }
}