package com.example.ajmalsyed.contacts.Adapter;

/**
 * Created by Ajmal Syed on 4/22/2017.
 */
public class ContactInstance {

    String name,email;
    String number;

    public ContactInstance(String name,String number,String email){
        this.name=name;
        this.number=number;
        this.email=email;
    }

    void setName(String name){
        this.name=name;
    }
    void setNumber(String number){
        this.number=number;
    }

    void setEmail(String email){
        this.email=email;
    }

    String getName(){
        return name;
    }

    String getNumber(){
        return number;
    }

    String getEmail(){
        return email;
    }
}
