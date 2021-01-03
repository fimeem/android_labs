
package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void nextActivity(View view) {
        EditText edit = (EditText) findViewById(R.id.edit);
        String s = String.valueOf(edit.getText());
        Intent intent = new Intent(this, Activity2.class);
        intent.putExtra("s", s);
        startActivity(intent);
    }
}
