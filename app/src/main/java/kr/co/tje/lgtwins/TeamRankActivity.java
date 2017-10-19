package kr.co.tje.lgtwins;

import android.Manifest;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

import kr.co.tje.lgtwins.util.PermissionRequester;


public class TeamRankActivity extends BaseActivity {


    private TextView testTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_rank);

        bindView();
        setupEvent();
        setValues();


        PermissionRequester.Builder request = new PermissionRequester.Builder(this);
        request.create().request(Manifest.permission.INTERNET, 10000, new PermissionRequester.OnClickDenyButtonListener() {
            @Override
            public void onClick(Activity activity) {
                Toast.makeText(activity, "인터넷 권한이 필요합니다.", Toast.LENGTH_SHORT).show();
                activity.finish();
            }
        });
    }


    private class MainPageTask extends AsyncTask<Void, Void, Void> {
        private Elements element;

        @Override
        protected void onPostExecute(Void result) {
            //doInBackground 작업이 끝나고 난뒤의 작업
            testTxt.setText(element.text());
        }

        @Override
        protected Void doInBackground(Void... params) {
            //백그라운드 작업이 진행되는 곳.
            try {
                Document doc = Jsoup.connect("http://sports.news.naver.com").get();
                element = doc.select("#algoList > tbody");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
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
        this.testTxt = (TextView) findViewById(R.id.testTxt);

    }


}
