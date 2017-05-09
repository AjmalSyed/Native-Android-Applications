package com.example.ajmalsyed.miwok;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ajmal Syed on 1/26/2017.
 */
public class ColorsAddapter extends ArrayAdapter<Colors> {
    private int mColorId;
    public ColorsAddapter(Activity context, ArrayList<Colors> colorsArrayList,int mColorId) {
        super(context, 0,colorsArrayList );
        this.mColorId=mColorId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listitemview=convertView;
        if(listitemview==null){
            listitemview= LayoutInflater.from(getContext()).inflate(R.layout.colorslist,parent,false);
        }
        Colors currentcolor=getItem(position);
        ImageView miwokimage= (ImageView) listitemview.findViewById(R.id.imagid);
        miwokimage.setImageResource(currentcolor.getmImageId());
        TextView miwoktext= (TextView) listitemview.findViewById(R.id.miwoketext);
        TextView defaulttext= (TextView) listitemview.findViewById(R.id.defaulttext);
        miwoktext.setText(currentcolor.getmMiwoktranslate());
        defaulttext.setText(currentcolor.getmDefaulttranslate());
        View color_container=listitemview.findViewById(R.id.categary_colors);
        int color= ContextCompat.getColor(getContext(),mColorId);
        color_container.setBackgroundColor(color);
        return listitemview;
    }
}