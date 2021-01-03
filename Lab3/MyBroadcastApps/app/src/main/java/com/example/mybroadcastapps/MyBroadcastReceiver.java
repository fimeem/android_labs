package com.example.mybroadcastapps;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if("Dummy_Broadcast_Message".equals(intent.getAction()))
        {
            String text = intent.getStringExtra("extra_text");
            Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
        }
        if(BatteryManager.ACTION_CHARGING.equals(intent.getAction()))
        {
            Toast.makeText(context, "Charging", Toast.LENGTH_SHORT).show();
        }
        else if(BatteryManager.ACTION_DISCHARGING.equals(intent.getAction()))
        {
            Toast.makeText(context, "Charger Disconnected", Toast.LENGTH_SHORT).show();
        }
    }
}
