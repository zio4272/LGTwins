package kr.co.tjeit.lgtwins.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import kr.co.tjeit.lgtwins.R;
import kr.co.tjeit.lgtwins.adapter.PlayerAdatper;
import kr.co.tjeit.lgtwins.data.Player;
import kr.co.tjeit.lgtwins.util.GlobalData;

/**
 * Created by ziO on 2017-10-18.
 */

public class SeemoreFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_player, container, false);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupEvent();
        setValues();
    }

    private void setValues() {


    }

    private void setupEvent() {
    }
}
