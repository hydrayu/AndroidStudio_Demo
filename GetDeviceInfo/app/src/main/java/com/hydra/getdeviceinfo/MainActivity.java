package com.hydra.getdeviceinfo;

import android.icu.text.LocaleDisplayNames;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    MainActivity mainActivity;
    // 主機版名稱        Build.BOARD;
    // 品牌名稱          Build.BRAND;
    // CPU + ABI        Build.CPU_ABI;
    // 設備名稱          Build.DEVICE;
    // 版本號碼          Build.DISPLAY;
    // 設備識別碼        Build.FINGERPRINT;
    // HOST            Build.HOST;
    // 版本號碼         Build.ID;
    // 製造商          Build.MANUFACTURER;
    // 模組號碼        Build.MODEL;
    // 產品名稱       Build.PRODUCT;
    // 設備描述       Build.TAGS;
    // 設備類別; user or eng    Build.TYPE;
    // USER         Build.USER;

    List<String> list;
    ListView listview;
    List<Boolean> listShow; // 這個用來記錄哪幾個 item 是被打勾的

    String[][] DevInfo={{"Board","Brand","CPU_ABI","Device","Display","FingerPrint","Host","ID","Manufacturer","Model","Product","Tags","Type","User"},
                        {Build.BOARD,Build.BRAND,Build.CPU_ABI,Build.DEVICE,Build.DISPLAY,Build.FINGERPRINT,Build.HOST,Build.ID,Build.MANUFACTURER,Build.MODEL,Build.PRODUCT,Build.TAGS,Build.TYPE,Build.USER}
                        };

    /*String[] DevInfoName={"Board","Brand","CPU_ABI","Device","Display","FingerPrint","Host","ID","Manufacturer","Model","Product","Tags","Type","User"};
    String[] DevInfo={Build.BOARD,Build.BRAND,Build.CPU_ABI,Build.DEVICE,Build.DISPLAY,Build.FINGERPRINT,Build.HOST,Build.ID,Build.MANUFACTURER,Build.MODEL,
            Build.PRODUCT,Build.TAGS,Build.TYPE,Build.USER};*/



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivity = this;




        listview = (ListView) findViewById(R.id.lv_checkbox);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                CheckedTextView chkItem = (CheckedTextView) v.findViewById(R.id.ctv);
                if(!chkItem.isChecked()){
                    chkItem.setChecked(true);
                    Toast.makeText(MainActivity.this, "您點選了第 "+(position+1)+" 項", Toast.LENGTH_SHORT).show();
                }else{
                    chkItem.setChecked(false);
                    Toast.makeText(MainActivity.this, "您取消了第 "+(position+1)+" 項", Toast.LENGTH_SHORT).show();
                }
                listShow.set(position, chkItem.isChecked());

                LinearLayout leftLL = (LinearLayout)findViewById(R.id.leftLL);
                leftLL.removeAllViews();
                for(int x=0;x<listShow.size();x++)
                {
                    //Log.d("Hydra","listShow("+x+") is "+listShow.get(x));
                    if(listShow.get(x)==true)
                    {
                        //lastBtn = new Button(mainActivity); lastBtn.setLayoutParams(btP.getLayoutParams());
                        LinearLayout ll = new LinearLayout(mainActivity);
                        ll.setOrientation(LinearLayout.HORIZONTAL);
                        TextView TV_Title = new TextView(mainActivity);
                        TV_Title.setLayoutParams(new TableLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 50));
                        TextView TV_Content = new TextView(mainActivity);
                        TV_Content.setLayoutParams(new TableLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 50));
                        TV_Title.setText(DevInfo[0][x+1]);
                        TV_Content.setText(DevInfo[1][x+1]);
                        ll.addView(TV_Title);
                        ll.addView(TV_Content);
                        leftLL.addView(ll);
                        Log.d("Hydra","listShow.get(true)="+DevInfo[0][x+1]+": "+DevInfo[1][x+1]);
                    }
                }
            }

        });


        listShow = new ArrayList<Boolean>();
        list = new ArrayList<String>();
        Log.d("Hydra","DevInfo[0].Length="+DevInfo[0].length);
        for(int x=1;x<DevInfo[0].length;x++)
        {
            list.add(DevInfo[0][x]);
            listShow.add(false);
        }

        ListAdapter adapterItem = new com.hydra.getdeviceinfo.ListAdapter(this,list);
        listview.setAdapter(adapterItem);

    }

}
