package com.example.ajmalsyed.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Colors_Activity extends AppCompatActivity {
    MediaPlayer mMediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors_);
        setTitle("Colors");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final ArrayList<Colors> colorsArrayList=new ArrayList<Colors>();
        colorsArrayList.add(new Colors("wetetti","red",R.drawable.color_red,R.raw.color_red));
        colorsArrayList.add(new Colors("chiwiita","mustard yellow",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));
        colorsArrayList.add(new Colors("topiisa","dusty yellow",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        colorsArrayList.add(new Colors("chokokki","green",R.drawable.color_green,R.raw.color_green));
        colorsArrayList.add(new Colors("takaakki","brown",R.drawable.color_brown,R.raw.color_brown));
        colorsArrayList.add(new Colors("topoppi","gray",R.drawable.color_gray,R.raw.color_gray));

        ColorsAddapter colorsAddapter=new ColorsAddapter(this,colorsArrayList,R.color.color_colors);
        ListView colorslistview= (ListView) findViewById(R.id.colorsrootview);
        colorslistview.setAdapter(colorsAddapter);

        colorslistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Colors colorsound=colorsArrayList.get(position);
                releaseMediaPlayer();
               mMediaPlayer=MediaPlayer.create(Colors_Activity.this,colorsound.getmMusic());
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
