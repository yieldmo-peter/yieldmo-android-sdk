package com.yieldmo.adt.yieldmodemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yieldmo.adt.yieldmodemo.R;

public class LayoutDemoAdapter extends BaseAdapter {

    Context context;
    View adViewToShow;

    public LayoutDemoAdapter(Context ctx, View adView) {
        context = ctx;
        adViewToShow = adView;
    }

    @Override
    public int getCount() {
        return 20;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (position == 2) {
            convertView = adViewToShow;
        } else {
            convertView = LayoutInflater.from(context).inflate(R.layout.row, parent, false);
            TextView txt = (TextView) convertView.findViewById(R.id.value);
            txt.setText("Row " + position);
        }
        return convertView;
    }
}
