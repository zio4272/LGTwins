package kr.co.tjeit.lgtwins.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import kr.co.tjeit.lgtwins.MainActivity;
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
    private android.support.design.widget.TabLayout tabs;
    List<Player> players = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_player, container, false);
        this.tabs = (TabLayout) v.findViewById(R.id.tabs);
        this.playerListView = (ListView) v.findViewById(R.id.playerListView);


        tabs.addTab(tabs.newTab().setText("전체"));
        tabs.addTab(tabs.newTab().setText("투수"));
        tabs.addTab(tabs.newTab().setText("포수"));
        tabs.addTab(tabs.newTab().setText("내야수"));
        tabs.addTab(tabs.newTab().setText("외야수"));
        tabs.addTab(tabs.newTab().setText("육성선수"));

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tabs) {

                players.clear(); // 모두 비워줌

                if (tabs.getPosition() == 0) {
                    players.addAll(GlobalData.players);
                } else {
                    for (Player pl : GlobalData.players) {
                        if (tabs.getPosition() == pl.getPosition()) {
                            players.add(pl);
                        }
                    }

                }

                mAdapter.notifyDataSetChanged();


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {


            }
        });


        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupEvent();
        setValues();

    }

    private void setValues() {

        players.addAll(GlobalData.players); // players에 모든 선수 정보를 다 담는다.
        mAdapter = new PlayerAdatper(getContext(), players);
        playerListView.setAdapter(mAdapter);


    }

    private void setupEvent() {
    }
}
