package com.example.sajibpal.backactionbar;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class Backctivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


    }

    public  void show(View v){

       if(v.getId()==R.id.bto){

           Intent intent=new Intent(Backctivity.this,Main3Activity.class);
           startActivity(intent);
       }
    }
  /* public boolean onOptionsItemSelected(MenuItem item){

       if(item.getItemId()==android.R.id.home){

           this.finish();
       }
     return super.onOptionsItemSelected(item);
   }*/
}
