package com.example.ajmalsyed.contacts.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ajmalsyed.contacts.DataBase.ContactDatabase;
import com.example.ajmalsyed.contacts.R;

public class AddContacts extends AppCompatActivity {
    EditText name,number,email;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contacts);

          name= (EditText) findViewById(R.id.etname);
          number= (EditText) findViewById(R.id.etnumber);
          email= (EditText) findViewById(R.id.etemail);
          save= (Button) findViewById(R.id.savebutton);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    AddData();
                    finish();
            }
        });
    }

    public void AddData(){
        ContactDatabase contactDatabase=new ContactDatabase(this);
        if(name==null){
            Toast.makeText(AddContacts.this,"fill all fields",Toast.LENGTH_SHORT).show();
        }
         else{
         boolean data=contactDatabase.Insertion(name.getText().toString(),
                number.getText().toString(),
                 email.getText().toString());
        if(data){
            Toast.makeText(AddContacts.this,"data insert successfully",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(AddContacts.this,"data not insert ",Toast.LENGTH_SHORT).show();
        }}

    }

}
