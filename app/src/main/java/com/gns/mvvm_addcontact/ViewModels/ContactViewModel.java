package com.gns.mvvm_addcontact.ViewModels;

import android.os.AsyncTask;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gns.mvvm_addcontact.models.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactViewModel extends ViewModel {
    private MutableLiveData<List<Contact>> allContacts;
    private MutableLiveData<Boolean> isInProgress = new MutableLiveData<>();

    public void init(){
        allContacts =  new MutableLiveData<List<Contact>>();
        allContacts.setValue(new ArrayList<Contact>(){
            {add(new Contact("Ganesh","0449225624","", Contact.Gender.Male));}
        });
    }

    public void addNewValue(final Contact newContact){
        isInProgress.setValue(true);
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                List<Contact> newContactList = (List<Contact>)allContacts.getValue();
                newContactList.add(newContact);
                allContacts.postValue(newContactList);
                isInProgress.setValue(false);
            }

            @Override
            protected Void doInBackground(Void... voids) {
                try{Thread.sleep(2000);}catch (Exception ex){}
                return null;
            }
        }.execute();
    }
    public MutableLiveData<List<Contact>> getAllContacts(){
        return allContacts;
    }
    public MutableLiveData<Boolean> getIsUpdating(){
        return isInProgress;
    }
}
