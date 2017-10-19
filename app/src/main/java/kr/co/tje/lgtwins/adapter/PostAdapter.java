package kr.co.tje.lgtwins.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import kr.co.tje.lgtwins.R;
import kr.co.tje.lgtwins.data.News;
import kr.co.tje.lgtwins.util.GlobalData;

/**
 * Created by the on 2017-10-16.
 */

public class PostAdapter extends ArrayAdapter<News> {

    Context mContext;
    List<News> mList;
    LayoutInflater inf;

    public PostAdapter(Context context, List<News> list) {
        super(context, R.layout.post_list_item, list);
        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            row = inf.inflate(R.layout.post_list_item, null);

            News data = mList.get(position);

            TextView titleTxt = (TextView) row.findViewById(R.id.titleTxt);
            TextView dateTxt = (TextView) row.findViewById(R.id.dateTxt);

            titleTxt.setText(GlobalData.newses.get(position).getTitle());


            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String date = dateFormat.format(Calendar.getInstance().getTime());
            dateTxt.setText(date);


        }
        return row;
    }

}
