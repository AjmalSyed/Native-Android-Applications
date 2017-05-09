package com.example.ajmalsyed.coffeeapp;

import android.annotation.TargetApi;
import android.content.Intent;
import android.icu.text.NumberFormat;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
int quantity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    void increment(View view){
         quantity+=1;
        displayquantity(quantity);

    }
    void decrement(View view){
        if(quantity==0){
        displayquantity(0);}
        else
            quantity-=1;
        displayquantity(quantity);

    }
    void displayquantity(int number){
        TextView quantity=(TextView) findViewById(R.id.quantitytext);
        quantity.setText(""+number);
    }
    void submitorder(View view){
      //  int price=5;
       // ordersummery(quantity*5);
        EditText name= (EditText) findViewById(R.id.edittext);
        String nametext=name.getText().toString();
        CheckBox whippedcreamcheck= (CheckBox) findViewById(R.id.whippedcreamcheck);
        boolean haswippedcream=whippedcreamcheck.isChecked();
        CheckBox chocolate= (CheckBox) findViewById(R.id.chocolatcheck);
        boolean haschocolate=chocolate.isChecked();

        String allsummery=summery(nametext,haswippedcream,haschocolate);
        ordersummery(allsummery);

        }


    String summery(String nametext,boolean haswippedcream,boolean haschocolate) {

        String summery="name is: "+nametext;
                summery += " \nYou get " + quantity + " cup of coffee " + " \nTotalPrice: " + quantity * 5;
        if (haswippedcream) {
            summery += "\nCoffee Type: " + getString(R.string.iswhippedcream);//or "wippedcream"
        } else if (haschocolate) {
            summery += "\nCoffee Type: " + getString(R.string.ischocolate); // or " Chocolate";
        }
        return summery;
    }

    void ordersummery(String price ){
        TextView displaysummerymessage= (TextView) findViewById(R.id.pricetext);
        displaysummerymessage.setText(""+price);
    }

}
