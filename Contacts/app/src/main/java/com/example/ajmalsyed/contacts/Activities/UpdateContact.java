package com.example.ajmalsyed.contacts.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ajmalsyed.contacts.DataBase.ContactDatabase;
import com.example.ajmalsyed.contacts.R;

public class UpdateContact extends AppCompatActivity {
    EditText name, number, email;
    Button updatebutton;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_contact);

        name = (EditText) findViewById(R.id.etname);
        number = (EditText) findViewById(R.id.etnumber);
        email = (EditText) findViewById(R.id.etemail);
        updatebutton= (Button) findViewById(R.id.updatebutton);

        Intent intent=getIntent();
        position=intent.getIntExtra("id",0);
        Toast.makeText(getApplicationContext(),"Position is "+position,Toast.LENGTH_SHORT).show();

        updatebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditData();
                finish();
            }
        });


    }

    public void EditData(){
        ContactDatabase contactDatabase=new ContactDatabase(this);
        boolean update=contactDatabase.updateData(name.getText().toString().trim(),
                number.getText().toString(),
                email.getText().toString().trim(),position);

                if(update){
                    Toast.makeText(getApplicationContext(),"data update done",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"data not update",Toast.LENGTH_SHORT).show();

                }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.update_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();
        switch (id) {
            case R.id.save:
        }
        return super.onOptionsItemSelected(item);
    }
}
