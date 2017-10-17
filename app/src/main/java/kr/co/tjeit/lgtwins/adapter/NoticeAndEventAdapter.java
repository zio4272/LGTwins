package kr.co.tjeit.lgtwins.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

import kr.co.tjeit.lgtwins.R;
import kr.co.tjeit.lgtwins.data.NoticeAndEvent;

/**
 * Created by the on 2017-10-17.
 */

public class NoticeAndEventAdapter extends ArrayAdapter<NoticeAndEvent> {

    Context mContext;
    List<NoticeAndEvent> mList;
    LayoutInflater inf;

    public NoticeAndEventAdapter(Context context, List<NoticeAndEvent> list) {
        super(context, R.layout.notice_event_list_item, list);
        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            row = inf.inflate(R.layout.notice_event_list_item, null);

        }
        return row;
    }

    @Override
    public int getCount() {
        return 10;
    }
}
