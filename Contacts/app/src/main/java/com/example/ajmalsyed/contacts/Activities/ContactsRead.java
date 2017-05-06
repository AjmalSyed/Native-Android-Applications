package com.example.ajmalsyed.contacts.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.ajmalsyed.contacts.Adapter.ContactAdapter;
import com.example.ajmalsyed.contacts.Adapter.ContactInstance;
import com.example.ajmalsyed.contacts.DataBase.ContactDatabase;
import com.example.ajmalsyed.contacts.R;

import java.util.ArrayList;

public class ContactsRead extends AppCompatActivity {
    ContactDatabase contactDatabase=new ContactDatabase(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_read);

    }



    @Override
    protected void onResume() {
        super.onResume();
        DataDisplay();
    }


    public void DataDisplay(){

        SQLiteDatabase db=contactDatabase.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * from "+contactDatabase.TABLE_NAME,null);
        int name=cursor.getColumnIndex(contactDatabase.NAME_COLUMN);
        int number=cursor.getColumnIndex(contactDatabase.PHONE_NUMBERS);
        int email=cursor.getColumnIndex(contactDatabase.EMAIL_COLUMN);
        ArrayList<ContactInstance> instanceArrayList=new ArrayList<ContactInstance>();
        try{
        while (cursor.moveToNext()){
            String mName=cursor.getString(name);
            String mNumber=cursor.getString(number);
            String mEmail=cursor.getString(email);

              instanceArrayList.add(new ContactInstance(mName,mNumber,mEmail));
              ContactAdapter contactlistAdapter=new ContactAdapter(this,R.layout.contactlist,instanceArrayList,R.color.listcolor);
              ListView listView= (ListView) findViewById(R.id.contactslistview);
              listView.setAdapter(contactlistAdapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent=new Intent(ContactsRead.this,UpdateContact.class);
                        intent.putExtra("id",position);
                        startActivity(intent);
                    }
                });


                listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> parent, View view, int position,final long id) {

                        AlertDialog.Builder builder=new AlertDialog.Builder(ContactsRead.this);
                          builder.setTitle("OPTION");
                          builder.setMessage("Are You Delete This ?");
                          builder.setNegativeButton("DELETE", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //ContactDatabase contactDatabase1=new ContactDatabase(this);
                                contactDatabase.DeleteSelectedlist(id);
                                recreate();
                            }
                        });
                        AlertDialog option=builder.create();
                        option.show();
                        return false;
                    }
                });
        }
        }
        finally {
            cursor.close();
        }}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();
         switch (id){
             case R.id.DeleteAll:
                 contactDatabase.deleteAlldata();
                 recreate();
                // NavUtils.navigateUpFromSameTask(this);

         }
        return super.onOptionsItemSelected(item);
    }
}
