package kr.co.tjeit.lgtwins;

import android.Manifest;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import kr.co.tjeit.lgtwins.util.PermissionRequester;


public class TeamRankActivity extends BaseActivity {


    private TextView tvLatestLotto;
    private android.widget.ImageView ivNumber1;
    private android.widget.ImageView ivNumber2;
    private android.widget.ImageView ivNumber3;
    private android.widget.ImageView ivNumber4;
    private android.widget.ImageView ivNumber5;
    private android.widget.ImageView ivNumber6;
    private android.widget.ImageView ivNumber7;
    private TextView tvWinGameCount;
    private TextView tvWinGameMoney;

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


    private class GetLottoNumberTask extends AsyncTask<Void, Void, Map<String,String>> {


        @Override
        protected Map<String, String> doInBackground(Void... params) {
            Map<String,String> result = new HashMap<String,String>();
            try {
                Document document = Jsoup.connect("http://nlotto.co.kr/common.do?method=main").get();
                Elements elements = document.select(".lotto_area #lottoDrwNo");
                result.put("latestLottoCount", elements.text());

                for( int i = 1; i < 7; i++ ) {
                    elements = document.select(".lotto_area #numView #drwtNo" + i );
                    result.put("number" + i, elements.attr("src"));
                }

                elements = document.select(".lotto_area #numView #bnusNo");
                result.put("number7", elements.attr("src"));

                elements = document.select(".lotto_area .winner_num #lottoNo1Su");
                result.put("winGameCount", elements.text());

                elements = document.select(".lotto_area .winner_money #lottoNo1SuAmount");
                result.put("winGameMoney", elements.text());

            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;
        }

        @Override
        protected void onPostExecute(Map<String, String> map) {

            tvLatestLotto.setText(map.get("latestLottoCount") + " 회 당첨번호");
            tvWinGameCount.setText("총 " + map.get("winGameCount") + " 게임 당첨");
            tvWinGameMoney.setText("1등 : " + map.get("winGameMoney") + " 원");

            for( int i = 1; i < 8; i++) {
                GetImageTask task1 = new GetImageTask();
                task1.execute(map.get("number" + i), "number" + i);
            }
        }
    }


    private class GetImageTask extends AsyncTask<String, Void, Bitmap> {

        private String numberType;

        @Override
        protected Bitmap doInBackground(String... params) {

            numberType = params[1];

            Bitmap bitmap = null;

            try {
                URL url = new URL("http://www.nlotto.co.kr" + params[0]);

                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setDoInput(true);
                conn.setDoOutput(true);

                conn.connect();

                bitmap = BitmapFactory.decodeStream(conn.getInputStream());

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {

            if ( numberType.equals("number1")) {
                ivNumber1.setImageBitmap(bitmap);
            }
            else if (numberType.equals("number2")){
                ivNumber2.setImageBitmap(bitmap);
            }
            else if (numberType.equals("number3")){
                ivNumber3.setImageBitmap(bitmap);
            }
            else if (numberType.equals("number4")){
                ivNumber4.setImageBitmap(bitmap);
            }
            else if (numberType.equals("number5")){
                ivNumber5.setImageBitmap(bitmap);
            }
            else if (numberType.equals("number6")){
                ivNumber6.setImageBitmap(bitmap);
            }
            else if (numberType.equals("number7")){
                ivNumber7.setImageBitmap(bitmap);
            }

        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        GetLottoNumberTask task = new GetLottoNumberTask();
        task.execute();
    }




    @Override
    public void setupEvent() {

    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindView() {
        this.tvWinGameMoney = (TextView) findViewById(R.id.tvWinGameMoney);
        this.tvWinGameCount = (TextView) findViewById(R.id.tvWinGameCount);
        this.ivNumber7 = (ImageView) findViewById(R.id.ivNumber7);
        this.ivNumber6 = (ImageView) findViewById(R.id.ivNumber6);
        this.ivNumber5 = (ImageView) findViewById(R.id.ivNumber5);
        this.ivNumber4 = (ImageView) findViewById(R.id.ivNumber4);
        this.ivNumber3 = (ImageView) findViewById(R.id.ivNumber3);
        this.ivNumber2 = (ImageView) findViewById(R.id.ivNumber2);
        this.ivNumber1 = (ImageView) findViewById(R.id.ivNumber1);
        this.tvLatestLotto = (TextView) findViewById(R.id.tvLatestLotto);

    }


}
