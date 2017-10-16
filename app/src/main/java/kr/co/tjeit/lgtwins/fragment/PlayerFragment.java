package kr.co.tjeit.lgtwins.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import kr.co.tjeit.lgtwins.R;
import kr.co.tjeit.lgtwins.adapter.PlayerAdatper;
import kr.co.tjeit.lgtwins.data.Player;
import kr.co.tjeit.lgtwins.util.GlobalData;

/**
 * Created by the on 2017-10-16.
 */

public class PlayerFragment extends Fragment {



    private android.widget.ListView playerListView;
    PlayerAdatper mAdapter;
    List<Player> players = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_player, container, false);
        this.playerListView = (ListView) v.findViewById(R.id.playerListView);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupEvent();
        setValues();
    }

    private void setValues() {



        mAdapter = new PlayerAdatper(getContext(), players);
        playerListView.setAdapter(mAdapter);


    }

    private void setupEvent() {
    }
}
