package com.example.mybroadcastsender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //textView = findViewById(R.id.textView);
    }

    public void sendBroadcast(View view) {
        Intent intent = new Intent("Dummy_Broadcast_Message");
        intent.putExtra("extra_text", "Broadcast Received");
        sendBroadcast(intent);
    }
}

