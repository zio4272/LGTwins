package kr.co.tje.lgtwins.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import kr.co.tje.lgtwins.R;

/**
 * Created by the on 2017-10-24.
 */

public class SpinnerAdapter extends BaseAdapter {
    Context mContext;
    List<String> mList;
    LayoutInflater inf;


    public SpinnerAdapter(Context context, List<String> list) {
        mContext = context;
        mList = list;
        inf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        if (mList != null) return mList.size();
        else return 0;
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
