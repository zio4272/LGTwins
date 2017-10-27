package kr.co.tje.ilovelgtwins.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;
import kr.co.tje.ilovelgtwins.R;
import kr.co.tje.ilovelgtwins.data.Team;


public class NaverTeamRankAdapter extends ArrayAdapter<Team> {

    Context mContext;
    List<Team> mList;
    LayoutInflater inf;

    public NaverTeamRankAdapter(Context context, List<Team> list) {
        super(context, R.layout.team_rank_list_item, list);
        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            row = inf.inflate(R.layout.team_rank_list_item, null);

        }



        return row;
    }

}