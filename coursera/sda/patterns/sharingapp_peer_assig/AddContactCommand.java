package com.example.sharingapp;

import android.content.Context;

public class AddContactCommand extends Command {


    private ContactList contact_list;
    private Contact contact;
    private Context context;

    public AddContactCommand(ContactList contactList, Contact contact, Context context) {
        this.contact_list = contactList;
        this.contact = contact;
        this.context = context;
    }

    public void execute(){
        contact_list.addContact(contact);
        setIsExecuted(contact_list.saveContacts(context));
    }
}
