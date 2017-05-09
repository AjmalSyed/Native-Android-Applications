package com.example.ajmalsyed.miwok;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Miwok_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miwok_);
        TextView numberstext= (TextView) findViewById(R.id.numbers_text);
        TextView familymembertext= (TextView) findViewById(R.id.family_members_text);
        TextView colorstext= (TextView) findViewById(R.id.colors_text);
        TextView phrasestext= (TextView) findViewById(R.id.phrases_text);

                numberstext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Miwok_Activity.this,Numbers_Activity.class);
                startActivity(intent);

            }
        });
        familymembertext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Miwok_Activity.this,FamilyMembers_Activity.class);
                startActivity(intent);
            }
        });
        colorstext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Miwok_Activity.this,Colors_Activity.class);
                startActivity(intent);
            }
        });

        phrasestext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Miwok_Activity.this,Phrases_Activity.class);
                startActivity(intent);
            }
        });

    }
}
