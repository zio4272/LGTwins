package kr.co.tjeit.lgtwins;

import android.graphics.drawable.ColorDrawable;
import android.support.annotation.IntegerRes;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class PostDetailViewActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail_view);
        bindView();
        setupEvent();
        setValues();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // 액션바 좌측에 화살표 보이기
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // home 아이콘 (화살표)가 눌릴경우 finish();
            case android.R.id.home:
                finish();
                return true;
        }
        return (super.onOptionsItemSelected(item));
    }


    @Override
    public void setupEvent() {

    }

    @Override
    public void setValues() {
//        setTitle("트윈스 뉴스");
        setTitle(Html.fromHtml("<font color='#ff0000'>트윈스 뉴스 </font>")); // 타이틀 색상 & 제목 동시에 변경 HTML 방식으로
//        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xFFFFFFFF)); // 0xFF뒤에 원하는 색상 6글자






    }

    @Override
    public void bindView() {

    }
}
