package com.example.ajmalsyed.miwok;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ajmal Syed on 1/23/2017.
 */
public class wordadapter extends ArrayAdapter<words> {
    int mColorId;
    public wordadapter(Activity context, ArrayList<words> words ,int mColorId) {
       super(context, 0, words);
    this.mColorId=mColorId;
    }

        @Override
        public View getView ( int position, View convertView, ViewGroup parent){
            View listitemview = convertView;
            if (listitemview == null) {
                listitemview= LayoutInflater.from(getContext()).inflate(R.layout.number_list,parent,false);
            }
        words currentword=getItem(position);
            ImageView miwokimage= (ImageView) listitemview.findViewById(R.id.imagid);
            miwokimage.setImageResource(currentword.getmImageId());
            TextView miwoketext= (TextView) listitemview.findViewById(R.id.miwoketext);
            miwoketext.setText(currentword.getmMiwoktranslate());
            TextView defaulttext= (TextView) listitemview.findViewById(R.id.defaulttext);
            defaulttext.setText(currentword.getmDefaulttranslate());
            View container=listitemview.findViewById(R.id.categary_numbers);
            int color= ContextCompat.getColor(getContext(),mColorId);

            container.setBackgroundColor(color);
            return listitemview;
        }
    }
