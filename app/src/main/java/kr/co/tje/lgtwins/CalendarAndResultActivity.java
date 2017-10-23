package kr.co.tje.lgtwins;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.co.tje.lgtwins.data.CalendarResult;
import kr.co.tje.lgtwins.data.Team;

public class CalendarAndResultActivity extends BaseActivity {

    List<CalendarResult> results = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_and_result);
        bindView();
        setupEvent();
        setValues();

    }

    @Override
    protected void onResume() {
        super.onResume();

        CalendarAndResult task = new CalendarAndResult();
        task.execute();
    }



    private class CalendarAndResult extends AsyncTask<Void, Void, Map<String, String>> {

        @Override
        protected Map<String, String> doInBackground(Void... params) {
            Map<String, String> result = new HashMap<String, String>();
            try {
                Document document = Jsoup.connect("http://sports.news.naver.com/kbaseball/schedule/index.nhn?date=20171021&month=08&year=2017&teamCode=LG")
                        .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36")
                        .get();

                Elements teamTable = document.select("div#calendarWrap.tb_wrap");

                // 테이블의 한줄
                Elements rows = teamTable.select("div.sch_tb");


                for (int i = 0; i < rows.size(); i++) {
                    Element row = rows.get(i);

                    CalendarResult calendarResult = new CalendarResult();


                    // 날짜(요일)
                    String date = rows.select("span.td_date").first().text();
                    calendarResult.setDate(date);

                    // 시간
                    String time = rows.select("span").get(1).text();
                    calendarResult.setTime(time);

                    // 좌측 팀 이름
                    String leftName = rows.select("span").get(2).text();
                    calendarResult.setLeftTeamName(leftName);



                    results.add(calendarResult);

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

            for (CalendarResult calendarResult : results) {
               Log.d("날짜(요일)", calendarResult.getDate());
                Log.d("시간", calendarResult.getTime());
                Log.d("좌측팀이름", calendarResult.getLeftTeamName());


            }
//            Glide.with(mContext).load(teams.get(0).getUrl()).into(img);

//            TeamRecord();

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

    }
}
