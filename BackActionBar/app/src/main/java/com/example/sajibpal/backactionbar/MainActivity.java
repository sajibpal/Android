package com.example.sajibpal.backactionbar;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }
   public  boolean onOptionsItemSelected(MenuItem item){

       if(item.getItemId()==android.R.id.home){
           this.finish();
       }
      return super.onOptionsItemSelected(item);
   }

    public  void show(View v){

       if (v.getId()==R.id.button){

         Intent intent=new Intent(MainActivity.this,Backctivity.class);
        startActivity(intent);

       }
    }
}
