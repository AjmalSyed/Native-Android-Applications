package com.example.ajmalsyed.pets_app;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener {
    EditText searchtext;
    Button searchbutton;
    TextView name,breed,gender,weight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchtext= (EditText) findViewById(R.id.search_edit_text);
        searchbutton= (Button) findViewById(R.id.search_button);
        name= (TextView) findViewById(R.id.nametext);
        breed= (TextView) findViewById(R.id.breedtext);
        gender= (TextView) findViewById(R.id.gendertext);
        weight= (TextView) findViewById(R.id.weighttext);

        searchbutton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        petsEntry petsEntry=new petsEntry(this);

       Cursor cursor= petsEntry.getSearchData(searchtext.getText().toString());


        if (cursor.moveToNext()) {
            name.setText(cursor.getString(1));
            breed.setText(cursor.getString(2));
            gender.setText(cursor.getString(3));
           weight.setText(cursor.getString(4));
        }

           else {
            name.setText("not found ");
            breed.setText("");
            gender.setText("");
            weight.setText("");
            Toast.makeText(this, "Please entre correct name ", Toast.LENGTH_SHORT).show();
            }

        cursor.close();
    }
        }










