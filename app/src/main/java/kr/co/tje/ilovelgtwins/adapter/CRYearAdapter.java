package kr.co.tje.ilovelgtwins.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import kr.co.tje.ilovelgtwins.R;

/**
 * Created by the on 2017-10-25.
 */

public class CRYearAdapter extends BaseAdapter {
    Context mContext;
    List<String> mList;
    LayoutInflater inf;


    public CRYearAdapter(Context context, List<String> list) {
        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }


    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inf.inflate(R.layout.spinner_normal, parent, false);
        }

        if (mList != null) {
            //데이터세팅
            String text = mList.get(position);
            ((TextView) convertView.findViewById(R.id.spinnerText)).setText(text);
        }

        return convertView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inf.inflate(R.layout.spinner_dropdown, parent, false);
        }

        //데이터세팅
        String text = mList.get(position);
        ((TextView) convertView.findViewById(R.id.spinnerText)).setText(text);

        return convertView;
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


}
