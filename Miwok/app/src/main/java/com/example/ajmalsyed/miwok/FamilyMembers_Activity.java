package com.example.ajmalsyed.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyMembers_Activity extends AppCompatActivity {
    MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_members_);
        setTitle("FamilyMembers");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final ArrayList<Familymembers> familymembers=new ArrayList<Familymembers>();
        
        familymembers.add(new Familymembers("apa","father",R.drawable.family_father,R.raw.family_father));
        familymembers.add(new Familymembers("ata","mother",R.drawable.family_mother,R.raw.family_mother));
        familymembers.add(new Familymembers("angsi","son",R.drawable.family_son,R.raw.family_son));
        familymembers.add(new Familymembers("tune","daughter",R.drawable.family_daughter,R.raw.family_daughter));
        familymembers.add(new Familymembers("taachi","older brother",R.drawable.family_older_brother,R.raw.family_older_brother));
        familymembers.add(new Familymembers("chalitti","younger brother",R.drawable.family_younger_brother,R.raw.family_younger_brother));
       // familymembers.add(new Familymembers("",""));

    FamilymemberAddapter FamilymemberAddapter =new FamilymemberAddapter(this,familymembers,R.color.family_colors);
        ListView listView= (ListView) findViewById(R.id.familyrootview);
        listView.setAdapter(FamilymemberAddapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Familymembers familysound=familymembers.get(position);
                releaseMediaPlayer();
              mMediaPlayer =MediaPlayer.create(FamilyMembers_Activity.this,familysound.getmMusic());
                mMediaPlayer.start();
            }
        });

    }  @Override
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
