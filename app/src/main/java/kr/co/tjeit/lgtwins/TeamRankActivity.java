package kr.co.tjeit.lgtwins;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;


public class TeamRankActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_rank);
        bindView();
        setupEvent();
        setValues();


    }

    public static class JsoupExample {
        public static void main(String[] args) throws IOException {
            // get 방식으로 홈페이지를 로드
            Document doc = Jsoup.connect("http://score.sports.media.daum.net/record/soccer/epl/trnk.daum").get();
            // 기록 테이블을 가져와서 내용을 리스트에 입력
            Element table = doc.select(".team_rank").get(0);
            Elements infos = table.select("tbody tr");
            ArrayList<TeamInfo> list = new ArrayList<>();
            for (Element info : infos) {
                Elements tds = info.select("td");
                TeamInfo team = new TeamInfo();
                team.position = Integer.parseInt(tds.get(0).text().trim());
                team.teamName = tds.get(1).text().trim();
                team.played = Integer.parseInt(tds.get(2).text().trim());
                team.win = Integer.parseInt(tds.get(3).text().trim());
                team.draw = Integer.parseInt(tds.get(4).text().trim());
                team.loss = Integer.parseInt(tds.get(5).text().trim());
                team.gf = Integer.parseInt(tds.get(6).text().trim());
                team.ga = Integer.parseInt(tds.get(7).text().trim());
                team.gd = Integer.parseInt(tds.get(8).text().trim());
                team.points = Integer.parseInt(tds.get(9).text().trim());
                team.lastFiveGame = tds.get(10).text().trim();
                list.add(team);
            }
            // 가져온 결과를 출력
        }
    }

    static class TeamInfo {
        public int position;
        // 순위
        public String teamName;
        // 팀명
        public int played;
        // 경기
        public int win;
        // 승
        public int draw;
        // 무
        public int loss;
        // 패
        public int gf;
        // 득점(Goals For)
        public int ga;
        // 실점(Goals Against)
        public int gd;
        // 득실차
        public int points;
        // 승점
        public String lastFiveGame; // 최근 5경기
    }


        @Override
        public void setupEvent() {

        }

        @Override
        public void setValues() {

        }

        @Override
        public void bindView() {

        }
    }
