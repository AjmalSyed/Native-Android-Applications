package com.example.ajmalsyed.contacts.Adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.ajmalsyed.contacts.R;

import java.util.ArrayList;

/**
 * Created by Ajmal Syed on 4/22/2017.
 */
public class ContactAdapter extends ArrayAdapter<ContactInstance> {
    int colorId;
    ArrayList<ContactInstance> contactarraylist;
    public ContactAdapter(Context context, int resource, ArrayList<ContactInstance> contactarraylist,int colorId) {
        super(context,resource,contactarraylist);
        this.colorId=colorId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listitem=convertView;

        if(listitem==null){
            listitem= LayoutInflater.from(getContext()).inflate(R.layout.contactlist,parent,false);
        }

        ContactInstance currentlist=getItem(position);

        TextView name= (TextView) listitem.findViewById(R.id.nametext);
        name.setText(currentlist.getName());
        TextView number= (TextView) listitem.findViewById(R.id.numbertext);
        number.setText(currentlist.getNumber());
        TextView email= (TextView) listitem.findViewById(R.id.emailtext);
        email.setText(currentlist.getEmail());
        View colorcontainer=listitem.findViewById(R.id.listcolor);
        int color= ContextCompat.getColor(getContext(), colorId);
        colorcontainer.setBackgroundColor(color);

        return listitem;
    }
}
