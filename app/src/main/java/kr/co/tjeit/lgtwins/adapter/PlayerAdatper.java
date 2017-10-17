package kr.co.tjeit.lgtwins.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import kr.co.tjeit.lgtwins.R;
import kr.co.tjeit.lgtwins.data.Player;

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

            Player data = mList.get(position);

            TextView backNumber = (TextView) row.findViewById(R.id.backNumber);
            TextView playerName = (TextView) row.findViewById(R.id.playerName);
            TextView playerPosition = (TextView) row.findViewById(R.id.playerPosition);
            TextView useHand = (TextView) row.findViewById(R.id.useHand);


            backNumber.setText(data.getBackNumber() + "");
            playerName.setText(data.getName());


            if (data.getPosition() == 1) {
                playerPosition.setText("투수");
            } else if (data.getPosition() == 2) {
                playerPosition.setText("포수");
            } else if (data.getPosition() == 3) {
                playerPosition.setText("내야수");
            } else if (data.getPosition() == 4) {
                playerPosition.setText("외야수");
            } else if (data.getPosition() == 5) {
                playerPosition.setText("육성선수");
            }

            useHand.setText(data.getUseHand());


        }
        return row;
    }

}


