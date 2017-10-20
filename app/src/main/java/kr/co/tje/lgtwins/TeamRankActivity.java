package kr.co.tje.lgtwins;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
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


    List<Team> teams = new ArrayList<>();
    private android.widget.LinearLayout teamRankRecordLayout;


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

                    // 순위
                    String rankStr = row.select("th").first().text();
                    team.setRank(rankStr);

                    // 팀이름
                    String teamName = row.select("span").first().text();
                    team.setName(teamName);

                    // 총경기수
                    String totGame = row.select("span").get(1).text();
                    team.setTotGameCount(totGame);

                    // 승리한 경기
                    String winGame = row.select("span").get(2).text();
                    team.setWinGame(winGame);

                    // 패배한 경기
                    String loseGame = row.select("span").get(3).text();
                    team.setLoseGame(loseGame);

                    // 무승부 경기
                    String drawGame = row.select("span").get(4).text();
                    team.setDrawGame(drawGame);

                    // 팀승률
                    String winRating = row.select("td > strong").first().text();
                    team.setWinRating(winRating);

                    // 경기차
                    String equalsGame = row.select("span").get(5).text();
                    team.setEqualsGame(equalsGame);

                    // 연속
                    String continueGame = row.select("span").get(6).text();
                    team.setContinueGame(continueGame);

                    // 출루율
                    String goBase = row.select("span").get(7).text();
                    team.setGoBase(goBase);

                    // 장타율
                    String bigHit = row.select("span").get(8).text();
                    team.setBigHit(bigHit);

                    // 최근 10경기
                    String latestTenGame = row.select("span").get(9).text();
                    team.setLatestTenGame(latestTenGame);


//                    팀 로고 받아오는 부분
                    Elements teamLogo = row.select("img");
//                    replace 를 이용하여 주소창에 25_25 부분을 200_200으로변경 / 네이버에서 해당 크기로 변경가능하게 되어있음 앙 감사띠
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
//            text.setText(map.get("span"));
//            Glide.with(mContext).load(map.get("팀로고")).into(img);
//            Picasso.with(mContext).load(map.get("팀로고")).resize(50,50).into(img);

            for (Team team : teams) {
                Log.d("팀로고", team.getUrl());
                Log.d("팀순위", team.getRank());
                Log.d("팀이름", team.getName());
                Log.d("총경기수", team.getTotGameCount());
                Log.d("승리한경기", team.getWinGame());
                Log.d("패배한경기", team.getLoseGame());
                Log.d("무승부경기", team.getDrawGame());
                Log.d("팀승률", team.getWinRating());
                Log.d("경기차", team.getEqualsGame());
                Log.d("연속", team.getContinueGame());
                Log.d("출루율", team.getGoBase());
                Log.d("장타율", team.getBigHit());
                Log.d("최근10경기", team.getLatestTenGame());


            }
//            Glide.with(mContext).load(teams.get(0).getUrl()).into(img);

            TeamRecord();

        }
    }

    public void TeamRecord() {

        LayoutInflater inf = LayoutInflater.from(mContext);

        for (Team team : teams) {

            View v = inf.inflate(R.layout.team_rank_list_item, null);



            TextView totalGameTxt = v.findViewById(R.id.totalGameTxt);
            TextView winGameTxt = v.findViewById(R.id.winGameTxt);
            TextView loseGameTxt = v.findViewById(R.id.loseGameTxt);
            TextView drawGameTxt = v.findViewById(R.id.drawGameTxt);
            TextView winRatingTxt = v.findViewById(R.id.winRatingTxt);
            TextView equalsGameTxt = v.findViewById(R.id.equalsGameTxt);
            TextView continueGameTxt = v.findViewById(R.id.continueGameTxt);
            TextView goBaseTxt = v.findViewById(R.id.goBaseTxt);
            TextView bigHitTxt = v.findViewById(R.id.bigHitTxt);
            TextView latestTenGameTxt = v.findViewById(R.id.latestTenGameTxt);

            TextView teamRankTxt = v.findViewById(R.id.teamRankTxt);
            ImageView teamLogoImg = v.findViewById(R.id.teamLogoImg);
            TextView teamNameTxt = v.findViewById(R.id.teamNameTxt);


            totalGameTxt.setText(team.getTotGameCount());
            winGameTxt.setText(team.getWinGame());
            loseGameTxt.setText(team.getLoseGame());
            drawGameTxt.setText(team.getDrawGame());
            winRatingTxt.setText(team.getWinRating());
            equalsGameTxt.setText(team.getEqualsGame());
            continueGameTxt.setText(team.getContinueGame());
            goBaseTxt.setText(team.getGoBase());
            bigHitTxt.setText(team.getBigHit());
            latestTenGameTxt.setText(team.getLatestTenGame());

            teamRankTxt.setText(team.getRank());
            Glide.with(mContext).load(team.getUrl()).into(teamLogoImg);
            teamNameTxt.setText(team.getName());



            teamRankRecordLayout.addView(v);







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

        this.teamRankRecordLayout = (LinearLayout) findViewById(R.id.teamRankRecordLayout);

    }


}