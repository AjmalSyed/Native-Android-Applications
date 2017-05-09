package com.example.ajmalsyed.pets_app;

import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Add_Activity extends AppCompatActivity {
    EditText mName,mBreed,mWeight;
    Spinner mGenderSpinner;
    int mGender=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_);

        mName= (EditText) findViewById(R.id.name_editText);
         mBreed= (EditText) findViewById(R.id.breed_editText);
          mWeight= (EditText) findViewById(R.id.weight_editText);
            mGenderSpinner= (Spinner) findViewById(R.id.spinner_gender);
         spinner();
    }

    public void insert(){
        petsEntry petsEntry=new petsEntry(this);

        boolean data=petsEntry.insertdata(mName.getText().toString().trim(),
                mBreed.getText().toString().trim(),
                mGenderSpinner.getSelectedItem().toString(),
                Integer.parseInt(mWeight.getText().toString().trim()));
        if(data){
            Toast.makeText(this,"data insert",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"data not insert",Toast.LENGTH_SHORT).show();
        }
    }



    void spinner(){
        ArrayAdapter<CharSequence>  adapter=ArrayAdapter.createFromResource(this,R.array.spinner_array,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
          mGenderSpinner.setAdapter(adapter);

        mGenderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection= (String) parent.getItemAtPosition(position);
                  if(!TextUtils.isEmpty(selection)){
                    if(selection.equals("male")){
                        mGender=1;
                      }
                         else if(selection.equals("female")){
                            mGender=2;
                    }
                             else{
                                 mGender=0;
                    }
                  }
               }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
               mGender=0;
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add,menu);
           return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.Save){
            insert();
            finish(); //exit activity

        return true;
    }
               else if(id==R.id.back){
                NavUtils.navigateUpFromSameTask(this);
                return true;
    }
             else
            return true;
    }
}
