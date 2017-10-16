package kr.co.tjeit.lgtwins;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.sothree.slidinguppanel.ScrollableViewHelper;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import java.util.ArrayList;
import java.util.List;

import kr.co.tjeit.lgtwins.adapter.PostAdapter;
import kr.co.tjeit.lgtwins.data.Post;
import kr.co.tjeit.lgtwins.util.GlobalData;


public class MainActivity extends BaseActivity {
    //
    PostAdapter mAdapter;
    List<Post> postList = new ArrayList<>();

    private com.sothree.slidinguppanel.SlidingUpPanelLayout slidinglayout;
    private android.widget.ListView postListView;
    private android.widget.Button seeMoreBtn;
    private android.widget.LinearLayout playerMenu;
    private LinearLayout playerLayout;
    private LinearLayout homeLayout;
    private LinearLayout homeMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindView();
        setupEvent();
        setValues();
    }


    @Override
    public void setupEvent() {

        playerMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.playerMenu:
                        playerLayout.setVisibility(View.VISIBLE);
                        slidinglayout.setVisibility(View.GONE);
                        break;


                }
            }
        });

        homeMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.homeMenu:
                        playerLayout.setVisibility(View.GONE);
                        slidinglayout.setVisibility(View.VISIBLE);
                        break;


                }
            }
        });


        seeMoreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, PostPopupActivity.class);
                startActivity(intent);
            }
        });

        slidinglayout.addPanelSlideListener(new SlidingUpPanelLayout.PanelSlideListener() {
            @Override
            public void onPanelSlide(View panel, float slideOffset) {

            }

            @Override
            public void onPanelStateChanged(View panel, SlidingUpPanelLayout.PanelState previousState, SlidingUpPanelLayout.PanelState newState) {

                // 축소될 경우
                if (newState.name().toString().equals("Collapsed")) {
                    slidinglayout.setScrollableViewHelper(null);


                    // 펴질 경우
                } else if (newState.name().equals("Expanded")) {
                    slidinglayout.setScrollableViewHelper(new NestedScrollableViewHelper());
                    slidinglayout.setVerticalScrollBarEnabled(true);


                }

            }
        });



    }


    @Override
    public void setValues() {

        GlobalData.initGlobalData();

//        int height = getWindowManager().getDefaultDisplay().getHeight(); // 화면의 전체 사이즈
//        slidinglayout.setPanelHeight(height / 5); // 전체사이즈 나누기 5
        slidinglayout.setAnchorPoint(0.7f); // 1.0f = 100% , 0.7f = 70% 업
        slidinglayout.setPanelHeight(300); // 접혀있는 상태 기본 세로 크기



        mAdapter = new PostAdapter(mContext, postList);
        postListView.setAdapter(mAdapter);

        postList.add(GlobalData.posts.get(GlobalData.posts.size()-1));
        postList.add(GlobalData.posts.get(GlobalData.posts.size()-2));


    }

    @Override
    public void bindView() {
        this.playerMenu = (LinearLayout) findViewById(R.id.playerMenu);
        this.homeMenu = (LinearLayout) findViewById(R.id.homeMenu);
        this.slidinglayout = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);
        this.seeMoreBtn = (Button) findViewById(R.id.seeMoreBtn);
        this.postListView = (ListView) findViewById(R.id.postListView);
        this.playerLayout = (LinearLayout) findViewById(R.id.playerLayout);
    }

    public class NestedScrollableViewHelper extends ScrollableViewHelper {
        public int getScrollableViewScrollPosition(View scrollableView, boolean isSlidingUp) {
            if (scrollableView instanceof NestedScrollView) {
                if (isSlidingUp) {
                    return scrollableView.getScrollY();
                } else {
                    NestedScrollView nsv = ((NestedScrollView) scrollableView);
                    View child = nsv.getChildAt(0);
                    return (child.getBottom() - (nsv.getHeight() + nsv.getScrollY()));
                }
            } else {
                return 0;
            }
        }
    }


}
