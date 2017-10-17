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
import android.widget.TableLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
    TableLayout tableLayout;
    private android.support.design.widget.TabLayout tabs;
    List<Player> players = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_player, container, false);
        this.tabs = (TabLayout) v.findViewById(R.id.tabs);
        this.playerListView = (ListView) v.findViewById(R.id.playerListView);

        players.addAll(GlobalData.players);

        tabs.addTab(tabs.newTab().setText("전체"));
        tabs.addTab(tabs.newTab().setText("투수"));
        tabs.addTab(tabs.newTab().setText("포수"));
        tabs.addTab(tabs.newTab().setText("내야수"));
        tabs.addTab(tabs.newTab().setText("외야수"));
        tabs.addTab(tabs.newTab().setText("육성선수"));

        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tabs) {



                switch (tabs.getPosition()) {

                    case 0:

                        break;

                    case 1:

                        break;

                    case 2:

                        break;

                    case 3:

                        break;

                    case 4:

                        break;

                    case 5:

                        break;

                }


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

        mAdapter = new PlayerAdatper(getContext(), GlobalData.players);
        playerListView.setAdapter(mAdapter);


    }

    private void setupEvent() {
    }
}
