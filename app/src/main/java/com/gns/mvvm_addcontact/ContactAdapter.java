package com.gns.mvvm_addcontact;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gns.mvvm_addcontact.models.Contact;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    List<Contact> allContacts;

    public ContactAdapter(List<Contact> allContacts){
        this.allContacts = allContacts;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View contactView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_contact_view,null, false);
        return new ContactViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        holder.contactName.setText(allContacts.get(position).getContactname());
        holder.contactNumber.setText(allContacts.get(position).getNumber());
        holder.contactGender.setText(allContacts.get(position). getGender().toString());
    }

    @Override
    public int getItemCount() {
        return allContacts.size();
    }

    class ContactViewHolder extends RecyclerView.ViewHolder{

        CircleImageView contactImage;
        TextView contactName, contactNumber, contactGender;
        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            contactName = itemView.findViewById(R.id.contact_name);
            contactNumber = itemView.findViewById(R.id.contact_number);
            contactGender = itemView.findViewById(R.id.contact_gender);
            contactImage = itemView.findViewById(R.id.contact_image);
        }
    }
}
