package com.example.ajmalsyed.miwok;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ajmal Syed on 1/26/2017.
 */
public class PhrasesAddapter extends ArrayAdapter<Phrases> {
    private int mColorId;
   public PhrasesAddapter(Activity context, ArrayList<Phrases> phrasesArrayList,int mColorId){
       super(context,0,phrasesArrayList);
       this.mColorId=mColorId;
   }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listitemview=convertView;
        if(listitemview==null){
            listitemview= LayoutInflater.from(getContext()).inflate(R.layout.phraseslist,parent,false);
        }
        Phrases currentphrases=getItem(position);
        TextView miwoktext= (TextView) listitemview.findViewById(R.id.miwoketext);
        TextView defaulttext= (TextView) listitemview.findViewById(R.id.defaulttext);
        miwoktext.setText(currentphrases.getmMiwoktranslate());
        defaulttext.setText(currentphrases.getmDefaulttranslate());
        View color_container=listitemview.findViewById(R.id.categary_phrases);
        int color= ContextCompat.getColor(getContext(),mColorId);
        color_container.setBackgroundColor(color);
        return listitemview;
    }
}
