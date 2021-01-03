package com.example.todolist2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    ArrayList<String> items;
    ArrayAdapter<String> itemsAdapter;
    ListView list;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.list);
        items = new ArrayList<String>();
        readItems();
        itemsAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items);
        list.setAdapter(itemsAdapter);

        setupListViewListener();
    }

    private void setupListViewListener()
    {
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                items.remove(position);
                itemsAdapter.notifyDataSetChanged();
                saveItems();
                return true;
            }
        });
    }

    public void addToDoItem(View v) {
        EditText text = (EditText) findViewById(R.id.text);
        String st= String.valueOf(text.getText());
        itemsAdapter.add(text.getText().toString());
        text.setText("");
        saveItems();
    }

    private void readItems()
    {
        File filesDir = getFilesDir();
        File todoFile = new File(filesDir, "todo.txt");
        try
        {
            items = new ArrayList<String>(FileUtils.readLines(todoFile));
        }
        catch(IOException e)
        {
            items = new ArrayList<String>();
            e.printStackTrace();
        }
    }
    private void saveItems()
    {
        File filesDir = getFilesDir();
        File todoFile = new File(filesDir, "todo.txt");
        try
        {
            FileUtils.writeLines(todoFile, items);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
