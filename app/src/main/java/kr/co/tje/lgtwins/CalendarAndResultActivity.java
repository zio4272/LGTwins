package kr.co.tje.lgtwins;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import kr.co.tje.lgtwins.adapter.CRMonthAdapter;
import kr.co.tje.lgtwins.adapter.CRYearAdapter;
import kr.co.tje.lgtwins.data.CalendarResult;

public class CalendarAndResultActivity extends BaseActivity {


    List<CalendarResult> results = new ArrayList<>();
    List<String> years = new ArrayList<>();
    List<String> months = new ArrayList<>();

    String selectYear = "2017";
    String selectMonth = "08";

    CRYearAdapter crYearAdapter;
    CRMonthAdapter crMonthAdapter;


    private android.widget.TextView dateTxt;
    private android.widget.TextView timeTxt;
    private android.widget.ImageView teamLogoImg;
    private android.widget.TextView teamNameTxt;
    private android.widget.TextView stadiumTxt;
    private android.widget.TextView scoreTxt;
    private android.widget.TextView winResultTxt;
    private android.widget.LinearLayout winLoseResultLayout;
    private android.widget.ListView calendarAndResultListView;
    private android.widget.LinearLayout calendarLayout;
    private LinearLayout asldkasldkasd;
    private TextView loseResultTxt;
    private android.widget.Spinner yearSelectSpinner;
    private android.widget.Spinner monthSelectSpinner;

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
                Document document = Jsoup.connect("http://sports.news.naver.com/kbaseball/schedule/index.nhn?date=20171021&month= " + selectMonth + "&year=" + selectYear + "&teamCode=LG")
                        .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36")
                        .get();

                Elements teamTable = document.select("div#calendarWrap.tb_wrap");

                // 테이블의 한줄
                Elements rows = teamTable.select("div");

                results.clear();


                for (int i = 1; i < rows.size(); i++) {
                    Element row = rows.get(i);

                    // 경기장 정보를 가져와본다.
//                    네이버 관찰 결과 경기가 없는날은 경기장 정보도 없다.
//                    경기장 정보가 있는 경우에만 파싱을 마저 진행한다.
                    if (row.select("tbody > tr > td > span.td_stadium").size() > 0 && !row.select("tbody > tr > td > strong.td_score").text().equals("VS")) {

                        CalendarResult calendarResult = new CalendarResult();

                        // 날짜(요일)
                        String date = row.select("tbody > tr > td > span.td_date").text();
                        calendarResult.setDate(date);

                        // 시간
                        String time = row.select("tbody > tr > td > span.td_hour").text();
                        calendarResult.setTime(time);

                        // 좌측 팀 이름
                        String leftName = row.select("tbody > tr > td > span.team_lft").text();
                        calendarResult.setLeftTeamName(leftName);

                        // 좌측 팀 로고 = 검색되는 img들 중 첫번째 것.
//                        Elements => Element로 수정.
                        Element leftTeamLogo = row.select("img").first();
                        String leftURL = leftTeamLogo.attr("src").replace("25", "200");
                        calendarResult.setLeftTeamLogoURL(leftURL);

                        // 스코어
                        String score = row.select("tbody > tr > td > strong.td_score").text();
                        calendarResult.setScore(score);
                        String leftScore = score.split(":")[0];
                        String rightScore = score.split(":")[1];

                        calendarResult.setLeftScore(Integer.parseInt(leftScore));
                        calendarResult.setRightScore(Integer.parseInt(rightScore));


                        // 우측 팀 로고 = 검색되는 img들 중 두번째 것.
                        Element rightTeamLogo = row.select("img").get(1);
                        String rightURL = rightTeamLogo.attr("src").replace("25", "200");
                        calendarResult.setRightTeamLogoURL(rightURL);

                        // 우측 팀 이름
                        String rigthName = row.select("tbody > tr > td > span.team_rgt").text();
                        calendarResult.setRightTeamName(rigthName);

                        String stadium = row.select("tbody > tr > td > span.td_stadium").get(1).text();
                        calendarResult.setStadium(stadium);


                        results.add(calendarResult);
                    }


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
                Log.d("좌측팀로고", calendarResult.getLeftTeamLogoURL());
                Log.d("스코어", calendarResult.getScore());
                Log.d("우측팀로고", calendarResult.getRightTeamLogoURL());
                Log.d("우측팀이름", calendarResult.getRightTeamName());
                Log.d("경기장정보", calendarResult.getStadium());
                Log.d("왼쪽점수", calendarResult.getLeftScore() + "");


            }
//            Glide.with(mContext).load(teams.get(0).getUrl()).into(img);

            CRview();

        }
    }

    private void CRview() {

        winLoseResultLayout.removeAllViews();

        LayoutInflater inf = LayoutInflater.from(mContext);

        for (CalendarResult cr : results) {
            View v = inf.inflate(R.layout.calendar_result_list_item, null);
            this.loseResultTxt = (TextView) v.findViewById(R.id.loseResultTxt);
            this.winResultTxt = (TextView) v.findViewById(R.id.winResultTxt);
            this.scoreTxt = (TextView) v.findViewById(R.id.scoreTxt);
            this.stadiumTxt = (TextView) v.findViewById(R.id.stadiumTxt);
            this.teamNameTxt = (TextView) v.findViewById(R.id.teamNameTxt);
            this.teamLogoImg = (ImageView) v.findViewById(R.id.teamLogoImg);
            this.timeTxt = (TextView) v.findViewById(R.id.timeTxt);
            this.dateTxt = (TextView) v.findViewById(R.id.dateTxt);


            dateTxt.setText(cr.getDate());
            timeTxt.setText(cr.getTime());


            // 좌측 팀 이름이 LG인 경우 강제로 우측팀명으로 변경
            if (cr.getLeftTeamName().equals("LG")) {
                teamNameTxt.setText(cr.getRightTeamName());
                // 왼쪽 점수가 오른쪽 점수보다 크면
                if (cr.getLeftScore() > cr.getRightScore()) {
                    winResultTxt.setVisibility(View.VISIBLE);
                    loseResultTxt.setVisibility(View.GONE);
                } else if (cr.getRightScore() > cr.getLeftScore()) {
                    winResultTxt.setVisibility(View.GONE);
                    loseResultTxt.setVisibility(View.VISIBLE);
                }

            } else if (cr.getRightTeamName().equals("LG")) {
                teamNameTxt.setText(cr.getLeftTeamName());

                if (cr.getLeftScore() < cr.getRightScore()) {
                    winResultTxt.setVisibility(View.VISIBLE);
                    loseResultTxt.setVisibility(View.GONE);
                } else if (cr.getRightScore() < cr.getLeftScore()) {
                    winResultTxt.setVisibility(View.GONE);
                    loseResultTxt.setVisibility(View.VISIBLE);
                }
            } else {

                teamNameTxt.setText(cr.getLeftTeamName());
            }


            String lgLogo = "http://dthumb.phinf.naver.net/?src=http://imgsports.naver.net/images/emblem/new/kbo/default/LG.png&type=f200_200&refresh=1";
            if (cr.getLeftTeamLogoURL().equals(lgLogo)) {
                Glide.with(mContext).load(cr.getRightTeamLogoURL()).into(teamLogoImg);
            } else {
                Glide.with(mContext).load(cr.getLeftTeamLogoURL()).into(teamLogoImg);
            }


            stadiumTxt.setText(cr.getStadium());
            scoreTxt.setText(cr.getScore());


            winLoseResultLayout.addView(v);

        }


    }


    @Override
    public void setupEvent() {

        yearSelectSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectYear = years.get(i);
                CalendarAndResult task = new CalendarAndResult();
                task.execute();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        monthSelectSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectMonth = months.get(i);
                CalendarAndResult task = new CalendarAndResult();
                task.execute();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }


    @Override
    public void setValues() {

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int currentMonth = Calendar.getInstance().get(Calendar.MONTH);

        for (int i = 2008; i <= currentYear; i++) {
            years.add(String.format(Locale.KOREA, "%d", i));
        }

        for (int j = 1; j <= 12; j++) {
            months.add(String.format(Locale.KOREA, "%d", j));
        }

        crYearAdapter = new CRYearAdapter(mContext, years);
        yearSelectSpinner.setAdapter(crYearAdapter);

        crMonthAdapter = new CRMonthAdapter(mContext, months);
        monthSelectSpinner.setAdapter(crMonthAdapter);

        String currentYearStr = String.format(Locale.KOREA, "%d", currentYear);

        int index = years.indexOf(currentYearStr);

        yearSelectSpinner.setSelection(index);
        monthSelectSpinner.setSelection(currentMonth);




    }

    @Override
    public void bindView() {
        this.winLoseResultLayout = (LinearLayout) findViewById(R.id.winLoseResultLayout);
        this.monthSelectSpinner = (Spinner) findViewById(R.id.monthSelectSpinner);
        this.yearSelectSpinner = (Spinner) findViewById(R.id.yearSelectSpinner);

    }
}
