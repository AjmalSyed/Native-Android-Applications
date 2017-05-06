package com.example.ajmalsyed.contacts.Activities;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ajmalsyed.contacts.DataBase.ContactDatabase;
import com.example.ajmalsyed.contacts.R;

public class SearchContact extends AppCompatActivity {
    EditText searchtext;
    Button searchbutton;
    TextView name,number,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_contact);
        final ContactDatabase contactDatabase=new ContactDatabase(this);



        searchtext= (EditText) findViewById(R.id.search_edit_text);
        searchbutton= (Button) findViewById(R.id.search_button);
        name= (TextView) findViewById(R.id.nametext);
        number= (TextView) findViewById(R.id.numbertext);
        email= (TextView) findViewById(R.id.emailtext);

        searchbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 Cursor cursor=contactDatabase.SearchData(searchtext.getText().toString());
                  if (cursor.moveToNext()){

                      name.setText(cursor.getString(1));
                      number.setText(cursor.getString(2));
                      email.setText(cursor.getString(3));
                  }
                else{
                      name.setText("Contact Not Found");
                      number.setText("");
                      email.setText("");
                    Toast.makeText(getApplicationContext(),"Please Write Corresct Contact",Toast.LENGTH_LONG).show();
                }


                cursor.close();

            }
        });

    }
}
