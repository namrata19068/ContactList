package com.example.contactlist;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MT19068_ContactsRvAdapter extends RecyclerView.Adapter<MT19068_ContactsRvAdapter.ViewHolder> {

    private Context mContext;
    private LayoutInflater inflater;
    private List<MT19068_ModelContacts> mlistContacts;
    public MT19068_ContactsRvAdapter(Context context, List<MT19068_ModelContacts> listContacts){
        mlistContacts=listContacts;
        mContext=context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflater=LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.mt19068_item_contacts,parent,false);
        ViewHolder viewHolder= new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        TextView contact_name,contact_number;
        contact_name=holder.contact_name;
        contact_number=holder.contact_number;
        contact_name.setText(mlistContacts.get(position).getName());
        contact_number.setText(mlistContacts.get(position).getNumber());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("onClick:clicked on:", String.valueOf(mlistContacts.get(position)));
                Toast.makeText(mContext, "Done", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(mContext, MT19068_FragArgument.class);
                intent.putExtra("name", mlistContacts.get(position).getName());
                intent.putExtra("number", mlistContacts.get(position).getNumber());
                mContext.startActivity(intent);


            }
        });
    }

    @Override
    public int getItemCount() {
        return mlistContacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView contact_name,contact_number;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            contact_name=itemView.findViewById(R.id.contact_name);
            contact_number=itemView.findViewById(R.id.contact_number);
        }
    }
}
