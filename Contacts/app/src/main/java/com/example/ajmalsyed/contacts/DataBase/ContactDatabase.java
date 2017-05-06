package com.example.ajmalsyed.contacts.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.widget.Toast;

/**
 * Created by Ajmal Syed on 4/22/2017.
 */
public class ContactDatabase extends SQLiteOpenHelper {

    static final String DATABASE_NAME="Contacts.db";
    public final String TABLE_NAME="Contacts";
    public final String ID_COLUMN = BaseColumns._ID;
    public final String NAME_COLUMN = "Name";
    public final String PHONE_NUMBERS ="Cell_Number" ;
    public final String EMAIL_COLUMN = "email";
    Context context;

    final String Create_DB="CREATE TABLE "+TABLE_NAME +"( "+
            ID_COLUMN +" INTEGER PRIMARY KEY," +
            NAME_COLUMN+" TEXT NOT NULL,"+
            PHONE_NUMBERS+" TEXT NOT NULL,"+
            EMAIL_COLUMN+" TEXT NOT NULL DEFAULT NULL);";



    public ContactDatabase(Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Create_DB);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST "+TABLE_NAME);
        onCreate(db);

    }

    public boolean Insertion(String name,String number,String email){
        SQLiteDatabase db=this.getWritableDatabase();
         ContentValues value=new ContentValues();
          value.put(NAME_COLUMN,name);
          value.put(PHONE_NUMBERS,number);
          value.put(EMAIL_COLUMN,email);
           long datainsert=db.insert(TABLE_NAME,null,value);
             if(datainsert==-1){
                 return false;
             }
              else{
                 return true;
             }
    }

    public void DeleteSelectedlist(long id){
        SQLiteDatabase db=this.getWritableDatabase();
        String [] args=new String[]{++id+""};
        long deleted=db.delete(TABLE_NAME,"_id=?",args);
        Toast.makeText(context," selected item deleted id is = "+ id,Toast.LENGTH_SHORT).show();
    }


    public void deleteAlldata(){
        SQLiteDatabase db=this.getReadableDatabase();
        db.delete(TABLE_NAME,null,null);
        Toast.makeText(context," delete All items",Toast.LENGTH_SHORT).show();
    }


    public boolean updateData(String name ,String number,String email,int position){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues valuesupdate = new ContentValues();
        valuesupdate.put(NAME_COLUMN, name);
        valuesupdate.put(PHONE_NUMBERS, number);
        valuesupdate.put(EMAIL_COLUMN, email);
        String arg[]=new String[]{++position+""};
        long update=db.update(TABLE_NAME,valuesupdate,"_id=?",arg);
        Toast.makeText(context,"update id is "+update,Toast.LENGTH_SHORT).show();
        return true;
    }

    public Cursor SearchData(String name){
        SQLiteDatabase db=this.getReadableDatabase();
        String searchquery="Select * from "+TABLE_NAME+" where "+NAME_COLUMN+"= '"+name+"'";
        Cursor cursor=db.rawQuery(searchquery,null);
        return cursor;
    }

}
