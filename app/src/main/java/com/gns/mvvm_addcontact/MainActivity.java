package com.gns.mvvm_addcontact;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;

import com.gns.mvvm_addcontact.ViewModels.ContactViewModel;
import com.gns.mvvm_addcontact.models.Contact;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    RecyclerView contactlist;
    ContactAdapter adapter;
    ContactViewModel contactViewModel;
    Button addButton;
    ProgressBar progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactlist = findViewById(R.id.contact_list);
        progress = findViewById(R.id.spinner);

        contactViewModel = new ContactViewModel();
        contactViewModel.init();
        contactViewModel.getAllContacts().observe(this, new Observer<List<Contact>>() {
            @Override
            public void onChanged(List<Contact> contacts) {
                adapter.notifyDataSetChanged();
            }
        });

        contactViewModel.getIsUpdating().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                progress.setVisibility(aBoolean? View.VISIBLE:View.GONE);
                MutableLiveData<List<Contact>> t = contactViewModel.getAllContacts();

                contactlist.smoothScrollToPosition(contactViewModel.getAllContacts().getValue().size()-1);
            }
        });
        MutableLiveData<List<Contact>> test = contactViewModel.getAllContacts();
        adapter = new ContactAdapter(

                contactViewModel.getAllContacts().getValue()
        );
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        contactlist.setLayoutManager(mLayoutManager);
        contactlist.setItemAnimator(new DefaultItemAnimator());
        contactlist.setAdapter(adapter);




        addButton = findViewById(R.id.button_add);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contactViewModel.addNewValue(new Contact("Test","123456","", Contact.Gender.Male));
            }
        });
    }
}
