package com.example.ajmalsyed.contacts.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ajmalsyed.contacts.R;

public class HomeActivity extends AppCompatActivity {
    Button contactlist,searchcontact,addcontact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        contactlist= (Button) findViewById(R.id.contactlist_button);
        addcontact= (Button) findViewById(R.id.add_button);
        searchcontact= (Button) findViewById(R.id.search_button);

        addcontact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeActivity.this,AddContacts.class);
                startActivity(intent);
            }
        });

        contactlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeActivity.this,ContactsRead.class);
                startActivity(intent);
            }
        });


        searchcontact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeActivity.this,SearchContact.class);
                startActivity(intent);
            }
        });

    }


}
