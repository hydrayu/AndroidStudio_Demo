package com.hydra.getdeviceinfo;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;

import java.util.List;

/**
 * Created by imobile on 11/27/17.
 */

public class ListAdapter extends BaseAdapter {
    private Activity activity;
    private List<String> mList;


    private static LayoutInflater inflater = null;


    public ListAdapter(android.app.Activity a, List<String> list)
    {
        activity = a;
        mList = list;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    public int getCount()
    {
        return mList.size();
    }


    public Object getItem(int position)
    {
        return position;
    }


    public long getItemId(int position)
    {
        return position;
    }


    public View getView(int position, View convertView, ViewGroup parent)
    {
        View vi = convertView;
        if(convertView==null)
        {
            vi = inflater.inflate(R.layout.list_item, null);
        }

        CheckedTextView chkBshow = (CheckedTextView) vi.findViewById(R.id.ctv);

        chkBshow.setText(mList.get(position).toString());
        return vi;
    }
}
