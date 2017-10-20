package kr.co.tje.lgtwins;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.co.tje.lgtwins.data.Team;


public class TeamRankActivity extends BaseActivity {
    private android.widget.TextView text;
    private android.widget.ImageView img;

    List<Team> teams = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_rank);

        bindView();
        setupEvent();
        setValues();


    }

    @Override
    protected void onResume() {
        super.onResume();

        NaverBaseballTeamRank task = new NaverBaseballTeamRank();
        task.execute();
    }


    private class NaverBaseballTeamRank extends AsyncTask<Void, Void, Map<String, String>> {

        @Override
        protected Map<String, String> doInBackground(Void... params) {
            Map<String, String> result = new HashMap<String, String>();
            try {
                Document document = Jsoup.connect("http://sports.news.naver.com/kbaseball/record/index.nhn?category=kbo")
                        .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36")
                        .get();

                Elements teamTable = document.select("#regularTeamRecordList_table");

                // 테이블의 한줄
                Elements rows = teamTable.select("tr");


                for (int i = 0; i < rows.size(); i++) {
//                    한줄 통채로
                    Element row = rows.get(i);

                    Team team = new Team();

                    String rankStr = row.select("th").first().text();
                    team.setRank(Integer.parseInt(rankStr));

                    String teamName = row.select("span").first().text();
                    team.setName(teamName);

//                    팀 로고 받아오는 부분
                    Elements teamLogo = row.select("img");
                    String url = teamLogo.attr("src").replace("25", "200");
                    team.setUrl(url);


                    teams.add(team);

                }




            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;
        }

        @Override
        protected void onPostExecute(Map<String, String> map) {
            text.setText(map.get("팀로고"));
//            Glide.with(mContext).load(map.get("팀로고")).into(img);
//            Picasso.with(mContext).load(map.get("팀로고")).resize(50,50).into(img);

            for (Team team : teams) {
                Log.d("팀이름", team.getName());
            }
            Glide.with(mContext).load(teams.get(0).getUrl()).into(img);


        }
    }


    @Override
    public void setupEvent() {


    }


    @Override
    public void setValues() {

    }

    @Override
    public void bindView() {
        this.text = (TextView) findViewById(R.id.text);
        this.img = (ImageView) findViewById(R.id.img);
    }


}
