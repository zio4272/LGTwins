package kr.co.tjeit.lgtwins;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import kr.co.tjeit.lgtwins.adapter.PostAdapter;
import kr.co.tjeit.lgtwins.data.News;
import kr.co.tjeit.lgtwins.util.GlobalData;

public class PostPopupActivity extends BaseActivity {

    PostAdapter mAdapter;
    List<News> postList = new ArrayList<>();

    private android.widget.ListView postListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_popup);
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

        postListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(mContext, PostDetailViewActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void setValues() {

        GlobalData.initGlobalData();

        setTitle("트윈스 뉴스");

        mAdapter = new PostAdapter(mContext, postList);
        postListView.setAdapter(mAdapter);

//        Display display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
//        int width = (int) (display.getWidth() * 0.99); //Display 사이즈의 90%
//        int height = (int) (display.getHeight() * 0.90);  //Display 사이즈의 90%
//        getWindow().getAttributes().width = width;
//        getWindow().getAttributes().height = height;

        postList.addAll(GlobalData.newses);


    }

    @Override
    public void bindView() {
        this.postListView = (ListView) findViewById(R.id.postListView);

    }

}
