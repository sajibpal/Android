package com.example.sajibpal.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    Button btn,btn1,btn2,btn3;
    ListView lst;
    BluetoothAdapter bluetooth;
    Set<BluetoothDevice>pairdevice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.button);
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        lst= (ListView) findViewById(R.id.list);
        bluetooth=BluetoothAdapter.getDefaultAdapter();

        if(bluetooth==null){

            Toast.makeText(this, "Divice not found", Toast.LENGTH_SHORT).show();
        }
    }

  public  void show(View v){

      if(v.getId()==R.id.button){

         if(!bluetooth.isEnabled()){

             Intent intent=new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
             startActivityForResult(intent,0);
         }

      }
      if(v.getId()==R.id.button1){

        if(!bluetooth.isDiscovering()){

            Toast.makeText(this, "MAKING YOUR DEVICE DISCOVERABLE", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
            startActivityForResult(intent,0);
        }
      }
      if(v.getId()==R.id.button2){

          bluetooth.disable();
          Toast.makeText(this, "Bluetooth is off", Toast.LENGTH_SHORT).show();
      }

      if(v.getId()==R.id.button3){

           pairdevice=bluetooth.getBondedDevices();
           ArrayList list=new ArrayList();
          for(BluetoothDevice bt:pairdevice) list.add(bt.getName());
          ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,list);
          lst.setAdapter(adapter);
      }
  }
}
