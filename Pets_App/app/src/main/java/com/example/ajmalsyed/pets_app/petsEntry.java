package com.example.ajmalsyed.pets_app;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.provider.BaseColumns;
import android.widget.Toast;

/**
 * Created by Ajmal Syed on 3/21/2017.
 */
public class petsEntry extends SQLiteOpenHelper {





    static final String DBname="Pets.db";
      final String Table_name="Pets";
      final String Column_Name="NAME";
      final  String Column_Breed="BREED";
      final String Column_Gender="GENDER";
      final String Column_Weight="WEIGHT";
      final String Column_ID=BaseColumns._ID;
    Context context;


             final String Create_DB="CREATE TABLE "+Table_name +"( "+
                  Column_ID +" INTEGER PRIMARY KEY," +
                  Column_Name+" TEXT NOT NULL,"+
                  Column_Breed+" TEXT NOT NULL,"+
                  Column_Gender+" TEXT NOT NULL DEFAULT NULL,"+
                  Column_Weight+" INTEGER NOT NULL DEFAULT 0);";
      // final String Create_DB="Create Table"+Table_name+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT NOT NULL,BREED TEXT NOT NULL,GENDER TEXT NOT NULL,WEIGHT INT NOT NULL)";
       final String Delete_DB="drop table if exist "+Table_name;

   // public petsEntry(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    public  petsEntry(Context context){
        super(context, DBname, null, 1);
        this.context=context;
       // SQLiteDatabase db=this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Create_DB);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(Delete_DB);
        onCreate(db);

    }

    public   boolean insertdata(String name,String breed,String gender,int weight) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        //values.put(Column_ID,id);
        values.put(Column_Name, name);
        values.put(Column_Breed, breed);
        values.put(Column_Gender, gender);
        values.put(Column_Weight, weight);

        long insert = db.insert(Table_name, null, values);
        if (insert == -1) {
            return false;

        }
        else
            return true;

    }

    public boolean updatedata(String name,String breed,String gender,long weight,int position){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues valuesupdate = new ContentValues();
       // valuesupdate.put(Column_ID,id);
        valuesupdate.put(Column_Name, name);
        valuesupdate.put(Column_Breed, breed);
        valuesupdate.put(Column_Gender, gender);
        valuesupdate.put(Column_Weight, weight);
            String arg[]=new String[]{++position+""};
        long update=db.update(Table_name,valuesupdate,"_id=?",arg);
        Toast.makeText(context,"update id is "+update,Toast.LENGTH_SHORT).show();



        return true;

    }


    public boolean deleteAlldata(){
       // petsEntry petsEntry=new petsEntry(this);
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(Table_name,null,null);
        Toast.makeText(context,"data deleted",Toast.LENGTH_SHORT).show();

        return true;
    }


    public void deleteSelectedItems(long id){

        SQLiteDatabase db=this.getWritableDatabase();
        String [] args=new String[]{++id+""};
        long deleted=db.delete(Table_name,"_id=?",args);
        Toast.makeText(context," selected item deleted id is = "+ id,Toast.LENGTH_SHORT).show();
    }

    public Cursor getSearchData(String name){

        SQLiteDatabase db=this.getWritableDatabase();
        String searchQuery="select * from "+ Table_name+" where "+Column_Name+"="+"'"+ name +"'";
        Cursor cursor=db.rawQuery(searchQuery,null);
        return cursor;
    }

}

