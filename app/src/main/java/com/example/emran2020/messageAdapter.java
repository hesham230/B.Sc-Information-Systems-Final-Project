package com.example.emran2020;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class messageAdapter extends RecyclerView.Adapter<messageAdapter.MyViewHolder> {

    Context context;
    ArrayList<messages> profiles;

    public messageAdapter(Context c, ArrayList<messages> p) {
        context = c;
        profiles = p;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder ( LayoutInflater.from ( context ).inflate ( R.layout.activity_message, parent, false ) );
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.date.setText ("Date:   " +profiles.get ( position ).getA________Date ());
        holder.id.setText ("Id:   "+ profiles.get ( position ).getB________Id () );
        holder.firstName.setText ("First name:   "+ profiles.get ( position ).getC________FirstName () );
        holder.lastName.setText ( "Last name:   "+profiles.get ( position ).getD________LastName () );

        holder.phone.setText ("Phone:   "+ profiles.get ( position ).getE________Phone () );
        holder.content.setText ("Message:\n"+ profiles.get ( position ).getF________content ());


    }

    @Override
    public int getItemCount() {
        return profiles.size ();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView date,id, firstName,lastName, phone , content , process;
        public MyViewHolder(@NonNull View itemView) {
            super ( itemView );
            date = (TextView) itemView.findViewById ( R.id.textView38);
            id = (TextView) itemView.findViewById ( R.id.textView46 );
            firstName = (TextView) itemView.findViewById ( R.id.textView47 );
            lastName = (TextView) itemView.findViewById ( R.id.textView48);
            phone = (TextView) itemView.findViewById ( R.id.textView21);
            content = (TextView) itemView.findViewById ( R.id.textView50 );




        }
    }
}
