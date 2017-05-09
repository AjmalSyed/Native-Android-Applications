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
public class FamilymemberAddapter extends ArrayAdapter<Familymembers> {
    private int mColorId;
   public FamilymemberAddapter(Activity context, ArrayList<Familymembers> familymembers,int mColorId){
       super(context,0,familymembers);
       this.mColorId=mColorId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listitemview=convertView;
        if(listitemview==null){
            listitemview= LayoutInflater.from(getContext()).inflate(R.layout.familylist,parent,false);

        }
        Familymembers currentmember=getItem(position);
        ImageView miwokimage= (ImageView) listitemview.findViewById(R.id.imagid);
        miwokimage.setImageResource(currentmember.getmImageId());
        TextView miwoktext= (TextView) listitemview.findViewById(R.id.miwoketext);
        miwoktext.setText(currentmember.getmMiwoktranslate());
        TextView defaulttext= (TextView) listitemview.findViewById(R.id.defaulttext);
        defaulttext.setText(currentmember.getmDefaulttranslate());

        View color_container=listitemview.findViewById(R.id.categary_family);
        int color= ContextCompat.getColor(getContext(),mColorId);
        color_container.setBackgroundColor(color);
        return listitemview;

    }
}
