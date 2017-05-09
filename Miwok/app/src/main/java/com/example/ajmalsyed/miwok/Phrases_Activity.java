package com.example.ajmalsyed.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Phrases_Activity extends AppCompatActivity {
    MediaPlayer mMediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases_);
        setTitle("Phrases");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final ArrayList<Phrases> phrasesArrayList=new ArrayList<Phrases>();

        phrasesArrayList.add(new Phrases("minto wuksus?","Where are you going?",R.raw.phrase_where_are_you_going));
        phrasesArrayList.add(new Phrases("tinna oyaase'na?","What is your name?",R.raw.phrase_what_is_your_name));
        phrasesArrayList.add(new Phrases("oyaaset...","My name is...",R.raw.phrase_my_name_is));
        phrasesArrayList.add(new Phrases("michaksas?","How are you feeling?",R.raw.phrase_how_are_you_feeling));
        phrasesArrayList.add(new Phrases("kuchi achit","I'm feeling good",R.raw.phrase_im_feeling_good));
        phrasesArrayList.add(new Phrases("aanas;aa?","Are you coming?",R.raw.phrase_are_you_coming));
        // phrasesArrayList.add(new Familymembers("",""));

        PhrasesAddapter PhrasesAddapter =new PhrasesAddapter(this,phrasesArrayList,R.color.phrases_colors);
        ListView listView= (ListView) findViewById(R.id.phrasesrootview);
        listView.setAdapter(PhrasesAddapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Phrases phrasessound=phrasesArrayList.get(position);
                mMediaPlayer=MediaPlayer.create(Phrases_Activity.this,phrasessound.getmMusic());
                mMediaPlayer.start();
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
    private void releaseMediaPlayer(){
        if (mMediaPlayer!=null){
            mMediaPlayer.release();
            mMediaPlayer=null;
        }
    }
}
