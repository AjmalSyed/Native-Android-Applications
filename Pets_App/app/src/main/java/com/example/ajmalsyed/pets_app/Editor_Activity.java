package com.example.ajmalsyed.pets_app;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class Editor_Activity extends AppCompatActivity {
    private EditText mNameText,mBreedText, mweightText;
    private Spinner mGenderSpinner;
    int mGender=0;
    int position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor_);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent=getIntent();
        position=intent.getIntExtra("id",0);
        Toast.makeText(getApplicationContext(),"Position is "+position,Toast.LENGTH_SHORT).show();



        mNameText= (EditText) findViewById(R.id.name_editText);
           mBreedText= (EditText) findViewById(R.id.breed_editText);
             mweightText = (EditText) findViewById(R.id.weight_editText);
               mGenderSpinner = (Spinner) findViewById(R.id.spinner_gender);

        spinner();
    }


    public  void Editdata(){

        petsEntry petsEntry=new petsEntry(this);
            SQLiteDatabase db=petsEntry.getWritableDatabase();

        boolean dataisupdate=petsEntry.updatedata(mNameText.getText().toString(),
                mBreedText.getText().toString(),mGenderSpinner.getSelectedItem().toString(),
                Integer.parseInt(mweightText.getText().toString().trim()),position);

        Toast.makeText(getApplicationContext(),"update id "+dataisupdate,Toast.LENGTH_SHORT).show();




        if(dataisupdate){
            Toast.makeText(getApplicationContext(),"data update done",Toast.LENGTH_SHORT).show();
        }
              else{
                    Toast.makeText(getApplicationContext(),"data not update",Toast.LENGTH_SHORT).show();
        }


    }

    void spinner(){

         ArrayAdapter<CharSequence>  adapter=ArrayAdapter.createFromResource(Editor_Activity.this,R.array.spinner_array,android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                mGenderSpinner.setAdapter(adapter);

                    mGenderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                         public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            String selection = (String) parent.getItemAtPosition(position);
                            if (!TextUtils.isEmpty(selection)) {
                                if (selection.equals(getString(R.string.male))) {
                                    mGender = 1;
                                } else if (selection.equals(getString(R.string.female))) {
                                    mGender = 2;
                                }     else {
                                            mGender = 0;
                                }
                            }
                        }

             @Override
             public void onNothingSelected(AdapterView<?> parent) {
                 mGender =0;

             }
         });



     }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_editor_,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();

        switch (id){

            case R.id.Save:
                Editdata();
                  finish();
                    return true;

                      case R.id.delete:
                          return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
