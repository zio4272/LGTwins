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
import kr.co.tjeit.lgtwins.data.Player;
import kr.co.tjeit.lgtwins.data.Post;

/**
 * Created by the on 2017-10-16.
 */

public class PlayerAdatper extends ArrayAdapter<Player> {
    Context mContext;
    List<Player> mList;
    LayoutInflater inf;

    public PlayerAdatper(Context context, List<Player> list) {
        super(context, R.layout.player_list_item, list);
        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            row = inf.inflate(R.layout.player_list_item, null);

        }
        return row;
    }

    @Override
    public int getCount() {
        return 8;
    }
}


