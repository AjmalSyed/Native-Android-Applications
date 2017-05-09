package com.example.ajmalsyed.pets_app;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Catalog_Activity extends AppCompatActivity {
    petsEntry petsEntry=new petsEntry(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_catalog_);
               Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
                  setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
               fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                     Intent intent=new Intent(Catalog_Activity.this,Add_Activity.class);
                           startActivity(intent);
                //Snackbar.make(view, "please perform action ", Snackbar.LENGTH_LONG)
                       // .setAction("Action", null).show();
            }
        });
    }


    @Override
    protected void onStart() {
        displaydatabase();
        super.onStart();

    }

    public void displaydatabase(){


       final petsEntry petsEntry=new petsEntry(this);

             SQLiteDatabase db=petsEntry.getReadableDatabase();
                    Cursor cursor=db.rawQuery("Select * from "+petsEntry.Table_name,null);
                          int name=cursor.getColumnIndex(petsEntry.Column_Name);
                              final int breed=cursor.getColumnIndex(petsEntry.Column_Breed);

        final ArrayList<PetsInstance> petsInstanceArrayList=new ArrayList<PetsInstance>();

            try{


                   while (cursor.moveToNext()) {
                         String columnName = cursor.getString(name);
                             String columbreed=cursor.getString(breed);

               petsInstanceArrayList.add(new PetsInstance(columnName,columbreed));
                       final PetsAdapter petsAdapter=new PetsAdapter(this,R.layout.petslist,petsInstanceArrayList);
                       ListView  listView  = (ListView) findViewById(R.id.petslistview);
                                  listView.setAdapter(petsAdapter);

               listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                   @Override
                   public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                       //PetsInstance petsInstance=petsInstanceArrayList.get(position);

                             Intent intent=new Intent(Catalog_Activity.this,Editor_Activity.class);
                                    intent.putExtra("id",position);
                                   startActivity(intent);


                   }
               });

                       listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                           @Override
                           public boolean onItemLongClick(AdapterView<?> av, View v, final int position, final long id) {

                               final AlertDialog.Builder builder = new AlertDialog.Builder(Catalog_Activity.this);

                               builder.setTitle("OPTION");
                               builder.setMessage("ARE YOU DELETE DATA ?");
                               builder.setNegativeButton("DELETE", new DialogInterface.OnClickListener() {
                                   public void onClick(DialogInterface dialog, int item) {
                                       petsEntry.deleteSelectedItems(id);
                                       recreate();
                                       Toast.makeText(getApplicationContext(),"id in dialog " +id +" and "+item, Toast.LENGTH_SHORT).show();
                                   }

                               });
                               AlertDialog option=builder.create();
                               option.show();

                               return true;
                           }
                       });
                   }


        }
        finally {
            cursor.close();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_catalog_, menu);
             return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

           int id = item.getItemId();


              switch(id){
                    case R.id.Search:
                        Intent intent=new Intent(Catalog_Activity.this,SearchActivity.class);
                        startActivity(intent);
                       return true;

                          case R.id.delete:
                            //  petsEntry petsEntry=new petsEntry(this);
                           petsEntry.deleteAlldata();
                             recreate();


                                 return true;

                                    case R.id.back:
                                       return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
