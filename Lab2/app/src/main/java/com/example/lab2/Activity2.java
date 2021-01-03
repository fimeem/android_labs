package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    String st = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Bundle bundle = getIntent().getExtras();
        st=bundle.getString("s");
        TextView text = (TextView)findViewById(R.id.viewText);
        text.setText(st);
    }

    public void web(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://google.com/#q="+st));
        startActivity(intent);
    }
}
