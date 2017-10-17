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
import kr.co.tjeit.lgtwins.data.Post;

/**
 * Created by the on 2017-10-17.
 */

public class PostAdapter2 extends ArrayAdapter<Post> {

    Context mContext;
    List<Post> mList;
    LayoutInflater inf;

    public PostAdapter2(Context context, List<Post> list) {
        super(context, R.layout.post_list_item2, list);
        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            row = inf.inflate(R.layout.post_list_item2, null);

        }
        return row;
    }

}