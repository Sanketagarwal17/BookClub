package com.example.android.bookclub.acceptedrequest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.bookclub.R;

import java.util.ArrayList;

public class Acceptedrequestadapter extends RecyclerView.Adapter<Acceptedrequestadapter.ViewHolder> {


    Context context;
    ArrayList<Acceptedrequestmodel> arrayList;

    public Acceptedrequestadapter(Context context, ArrayList<Acceptedrequestmodel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }


    @NonNull
    @Override
    public Acceptedrequestadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.acceptrequestrecycler, parent, false);
        return new Acceptedrequestadapter.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull Acceptedrequestadapter.ViewHolder viewHolder, int position) {
        Acceptedrequestmodel acceptedrequestmodel = arrayList.get(position);

        String admissiono = acceptedrequestmodel.getAddmissionno();

        String name = acceptedrequestmodel.getName();
        String author = acceptedrequestmodel.getAuthor();
        String prc = acceptedrequestmodel.getPrice();

        viewHolder.admission.setText(admissiono);

        viewHolder.name.setText(name);
        viewHolder.author.setText(author);
        viewHolder.price.setText(prc);
    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, author, price,admission;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            admission = itemView.findViewById(R.id.admia);
            name = itemView.findViewById(R.id.booknamea);
            author = itemView.findViewById(R.id.authora);
            price = itemView.findViewById(R.id.pricea);


        }
    }
}
