package com.example.android.bookclub.allbooks;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.bookclub.DetailsofEachBook.Details;
import com.example.android.bookclub.R;

import java.util.ArrayList;



 public class  allbooksadapter extends RecyclerView.Adapter<allbooksadapter.ViewHolder>
{


    Context context;
    ArrayList<allbooksmodel> arrayList;
    public allbooksadapter(Context context, ArrayList<allbooksmodel> arrayList)
    {
        this.context=context;
        this.arrayList=arrayList;
    }




    @NonNull
    @Override
    public allbooksadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_recyclerview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull allbooksadapter.ViewHolder viewHolder, int position)
    {
        allbooksmodel allbooksmodeli=arrayList.get(position);
        String name=allbooksmodeli.getName();
        String msg=allbooksmodeli.getAuthor();
        String prc=allbooksmodeli.getPrice();
        viewHolder.name.setText(name);
        viewHolder.author.setText(msg);
        viewHolder.price.setText(prc);

       viewHolder.allbooklayout1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Intent i=new Intent(context, Details.class);
               i.putExtra("Bookid",1);
               context.startActivity(i);

           }
       });


    }



    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public void filterList(ArrayList<allbooksmodel> filterdNames) {
        this.arrayList = filterdNames;
        notifyDataSetChanged();
    }




    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView name,author,price;
         public  RelativeLayout allbooklayout1;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);

            name=itemView.findViewById(R.id.readname);
            author=itemView.findViewById(R.id.readauthor);
            price=itemView.findViewById(R.id.readprice);
           allbooklayout1=itemView.findViewById(R.id.allbooklayout);
        }
    }
}