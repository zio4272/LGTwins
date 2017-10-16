package kr.co.tjeit.lgtwins.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import kr.co.tjeit.lgtwins.R;

/**
 * Created by the on 2017-10-16.
 */

public class PlayerFragment extends Fragment {



    private android.widget.ListView playerListView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_player, container, false);
        this.playerListView = (ListView) v.findViewById(R.id.playerListView);
        return v;
    }

}
