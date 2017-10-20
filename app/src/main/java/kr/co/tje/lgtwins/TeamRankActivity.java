package kr.co.tje.lgtwins;

import android.Manifest;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import kr.co.tje.lgtwins.util.PermissionRequester;


public class TeamRankActivity extends BaseActivity {
    private android.widget.TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_rank);

        bindView();
        setupEvent();
        setValues();


    }

    private class naverBaseballTeamRank extends AsyncTask<Void, Void, Map<String, String>> {

        @Override
        protected Map<String, String> doInBackground(Void... params) {
            Map<String, String> result = new HashMap<String, String>();
            try {
                Document document = Jsoup.connect("http://sports.news.naver.com/kbaseball/record/index.nhn?category=kbo").get();
                Elements teamTable = document.select("#regularTeamRecordList_table");
                Elements rows = teamTable.select("tr");

//                result.put("팀테이블", teamTable.toString());

                for (int i = 1; i < rows.size(); i++) {
                    Element row = rows.get(i);
                    result.put("tr값", row.toString());

                    Elements cols = row.select("td");
                    result.put("td값", cols.text());
                }



            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;
        }

        @Override
        protected void onPostExecute(Map<String, String> map) {
            text.setText(map.get("전부"));

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
    }


}
