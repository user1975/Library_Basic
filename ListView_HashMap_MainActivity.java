package com.example.kjs.mylist_2entry;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = (ListView) findViewById(R.id.listView1);

        HashMap<String,String> item = new HashMap<String,String>();
        final ArrayList<HashMap<String,String>> telList = new ArrayList<HashMap<String, String>>();

        for (int i=0;i<10;i++) {
            item = new HashMap<String,String>();
            item.put("name","대상"+i);
            item.put("tel","전화번호"+i);
            telList.add(item);
        }

        SimpleAdapter adapter = new SimpleAdapter(this, telList, android.R.layout.simple_list_item_2,
                new String[] {"name","tel"}, new int[] {android.R.id.text1, android.R.id.text2});

        list.setAdapter(adapter);
    }
}n