package com.example.mybroadcastapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    MyBroadcastReceiver broadcast = new MyBroadcastReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        IntentFilter filter1;
        IntentFilter filter2;
        if (BatteryManager.BATTERY_STATUS_CHARGING == 2) {
            filter1 = new IntentFilter(BatteryManager.ACTION_CHARGING);
        }
        if (BatteryManager.BATTERY_STATUS_DISCHARGING == 3) {
            filter2 = new IntentFilter(BatteryManager.ACTION_DISCHARGING);
        }
        IntentFilter filter3 = new IntentFilter("Dummy_Broadcast_Message");
        registerReceiver(broadcast, filter1);
        registerReceiver(broadcast, filter2);
        registerReceiver(broadcast, filter3);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broadcast);
    }
}
