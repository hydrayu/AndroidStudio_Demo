package com.hydra.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckedTextView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    List<String> list;
    ListView listview;
    List<Boolean> listShow; // 這個用來記錄哪幾個 item 是被打勾的

    String[] DevInfo={"Board","Brand","CPU_ABI","Device","Display","FingerPrint","Host","ID","Manufacturer","Model","Product","Tags","Type","User"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = (ListView) findViewById(R.id.listView1);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                public void onItemClick(AdapterView<?> parent, View v, int position, long id)
                {
                    CheckedTextView chkItem = (CheckedTextView) v.findViewById(R.id.check1);
                    chkItem.setChecked(!chkItem.isChecked());
                    Toast.makeText(MainActivity.this, "您點選了第 "+(position+1)+" 項", Toast.LENGTH_SHORT).show();
                    listShow.set(position, chkItem.isChecked());
                }
            }
        );


        listShow = new ArrayList<Boolean>();
        list = new ArrayList<String>();
        for(int x=0;x<14;x++)
        {
            list.add(DevInfo[x]);
            listShow.add(true);
        }
        ListAdapter adapterItem = new com.hydra.listviewdemo.ListAdapter(this,list);
        listview.setAdapter(adapterItem);
    }

}
