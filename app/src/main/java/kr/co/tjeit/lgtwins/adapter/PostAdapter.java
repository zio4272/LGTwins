package kr.co.tjeit.lgtwins.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import kr.co.tjeit.lgtwins.R;
import kr.co.tjeit.lgtwins.data.News;
import kr.co.tjeit.lgtwins.util.GlobalData;

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
