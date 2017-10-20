package kr.co.tje.lgtwins;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class TeamRankActivity extends BaseActivity {
    private android.widget.TextView text;
    private android.widget.ImageView img;


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

        naverBaseballTeamRank task = new naverBaseballTeamRank();
        task.execute();
    }


    private class naverBaseballTeamRank extends AsyncTask<Void, Void, Map<String, String>> {

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


                Elements teamRank = rows.select("th");
                result.put("팀순위", teamRank.text());

                Elements teamLogo = teamRank.select("img");
                String str = teamLogo.attr("src");
                result.put("팀로고", str);



                for (int i = 1; i < rows.size(); i++) {
//                    한줄 통채로
                    Element row = rows.get(i);


                    result.put("tr값", row.text());


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
            text.setText(map.get("팀로고"));
//            Glide.with(mContext).load(map.get("팀로고")).into(img);
//            Picasso.with(mContext).load(map.get("팀로고")).resize(50,50).into(img);


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
