package com.example.ajmalsyed.pets_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ajmal Syed on 4/5/2017.
 */
public class PetsAdapter  extends ArrayAdapter<PetsInstance> {
    ArrayList<PetsInstance>  petsArraylist;
    public PetsAdapter(Context context, int resource,ArrayList<PetsInstance> petsArraylist) {
        super(context, resource,petsArraylist);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listitem=convertView;
        if(listitem==null){
            listitem= LayoutInflater.from(getContext()).inflate(R.layout.petslist,parent,false);
        }

        PetsInstance currentword=getItem(position);

        TextView nametext= (TextView) listitem.findViewById(R.id.pets_name);
        nametext.setText(currentword.getName());

        TextView breedtext= (TextView) listitem.findViewById(R.id.pets_breed);
        breedtext.setText(currentword.getBreed());

        return listitem;
    }
}
