package com.example.ajmalsyed.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Numbers_Activity extends AppCompatActivity {
    MediaPlayer mMediaPlayer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers_);
        setTitle("Numbers");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final ArrayList<words> words = new ArrayList<words>();


        words.add(new words("Lutti", "One", R.drawable.number_one,R.raw.number_one));
        words.add(new words("Otiiko", "Two", R.drawable.number_two,R.raw.number_two));
        words.add(new words("Tolookosu", "Three", R.drawable.number_three,R.raw.number_three));
        words.add(new words("Oyyisa", "Four", R.drawable.number_four,R.raw.number_four));
        words.add(new words("Massokka", "Five", R.drawable.number_five,R.raw.number_five));
        words.add(new words("Temmokka", "Six", R.drawable.number_six,R.raw.number_six));
        words.add(new words("Kenekaku", "Seven", R.drawable.number_seven,R.raw.number_seven));
        words.add(new words("Kawinta", "Eight", R.drawable.number_eight,R.raw.number_eight));
        words.add(new words("Wo'e", "Nine", R.drawable.number_nine,R.raw.number_nine));
        words.add(new words("Na'aacha", "Ten", R.drawable.number_ten,R.raw.number_ten));
       /* LinearLayout rootview= (LinearLayout) findViewById(R.id.rootview);

       for(int i=0;i<words.size();i++){
           TextView wordsView=new TextView(this);

           wordsView.setText(words.get(i));
           rootview.addView(wordsView);
       }
*/
        wordadapter wordadapter = new wordadapter(this, words, R.color.numbers_color);
        ListView listView = (ListView) findViewById(R.id.rootview);
        listView.setAdapter(wordadapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                words wordsound=words.get(position);
                releaseMediaPlayer();
              mMediaPlayer =MediaPlayer.create(Numbers_Activity.this,wordsound.getmMusic());
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
