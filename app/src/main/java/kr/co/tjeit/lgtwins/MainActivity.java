package kr.co.tjeit.lgtwins;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kr.co.tjeit.lgtwins.adapter.PostAdapter;
import kr.co.tjeit.lgtwins.adapter.PostAdapter2;
import kr.co.tjeit.lgtwins.data.News;
import kr.co.tjeit.lgtwins.util.GlobalData;


public class MainActivity extends BaseActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    SliderLayout sliderLayout;

    PostAdapter mAdapter;
    PostAdapter2 m2Adapter;

    List<News> postList = new ArrayList<>();

    HashMap<String, String> HashMapForURL;
    HashMap<String, Integer> HashMapForLocalRes;

    TabHost tabHost;

    private com.sothree.slidinguppanel.SlidingUpPanelLayout slidinglayout;
    private android.widget.ListView postListView;
    private android.widget.Button seeMoreBtn;
    private android.widget.LinearLayout playerMenu;
    private LinearLayout playerLayout;
    private LinearLayout homeLayout;
    private LinearLayout homeMenu;
    private SliderLayout sliderImage;
    private android.widget.TextView mainText;
    private android.widget.TabWidget tabs;
    private LinearLayout tab1;
    private LinearLayout tab2;
    private android.widget.FrameLayout tabcontent;
    private ListView postListView2;
    private LinearLayout seeMoreLayout;
    private LinearLayout seeMoreLayout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindView();
        setupEvent();
        setValues();

        tabHost.setup();

        TabHost.TabSpec spec1 = tabHost.newTabSpec("tab1").setIndicator("트윈스 뉴스");
        spec1.setContent(R.id.tab1);
        tabHost.addTab(spec1);

        TabHost.TabSpec spec2 = tabHost.newTabSpec("tab2").setIndicator("공지·이벤트");
        spec2.setContent(R.id.tab2);
        tabHost.addTab(spec2);

        tabHost.getTabWidget().setDividerDrawable(null); // 탭과 탭 사이의 경계선? 삭제.


        // 이미지 슬라이드
        AddImagesUrlOnline(); // URL에 있는걸 가져와서 보여주는것
//      AddImageUrlFormLocalRes(); // 자체적으로 저장된 파일


        for (String name : HashMapForURL.keySet()) {

            TextSliderView textSliderView = new TextSliderView(mContext);

            textSliderView.description(name).image(HashMapForURL.get(name)).setScaleType(BaseSliderView.ScaleType.CenterCrop).setOnSliderClickListener(this);
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle().putString("extra", name);
            sliderImage.addSlider(textSliderView);

        }


    }

    // URL에서 이미지 불러오기 (인터넷 권한 설정 해야함)
    private void AddImagesUrlOnline() {

        HashMapForURL = new HashMap<String, String>();

        HashMapForURL.put(GlobalData.twinsPhotos.get(0).getTitle(), GlobalData.twinsPhotos.get(0).getImageURL());
        HashMapForURL.put(GlobalData.twinsPhotos.get(1).getTitle(), GlobalData.twinsPhotos.get(1).getImageURL());
        HashMapForURL.put(GlobalData.twinsPhotos.get(2).getTitle(), GlobalData.twinsPhotos.get(2).getImageURL());

    }

    // 저장된 파일 불러오는 코드 (현재 사용 안함)
    private void AddImageUrlFormLocalRes() {

        HashMapForLocalRes = new HashMap<String, Integer>();

        HashMapForLocalRes.put("CupCake", R.drawable.emblem);
        HashMapForLocalRes.put("Donut", R.drawable.emblem);
        HashMapForLocalRes.put("Eclair", R.drawable.emblem);
        HashMapForLocalRes.put("Froyo", R.drawable.emblem);
        HashMapForLocalRes.put("GingerBread", R.drawable.emblem);

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


        seeMoreLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, PostPopupActivity.class);
                startActivity(intent);
            }
        });
        seeMoreLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, NoticeAndEventPopupActivity.class);
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
//                    slidinglayout.setScrollableViewHelper(null);
//


                    // 펴질 경우
                } else if (newState.name().equals("Expanded")) {
//                    slidinglayout.setScrollableViewHelper(new NestedScrollableViewHelper());
                    slidinglayout.setVerticalScrollBarEnabled(true);


                }

            }
        });

//        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
//            @Override
//            public void onTabChanged(String s) {
//                switch (s) {
//                    case "tab1":
//                        Toast.makeText(mContext, "탭1이 선택되었다", Toast.LENGTH_SHORT).show();
//                        break;
//                    case "tab2":
//
//                        break;
//                }
//
//            }
//        });


    }


    @Override
    public void setValues() {

        GlobalData.initGlobalData();

//        int height = getWindowManager().getDefaultDisplay().getHeight(); // 화면의 전체 사이즈
//        slidinglayout.setPanelHeight(height / 5); // 전체사이즈 나누기 5
        slidinglayout.setAnchorPoint(3.0f); // 1.0f = 100% , 0.7f = 70% 업
        slidinglayout.setPanelHeight(300); // 접혀있는 상태 기본 세로 크기


        mAdapter = new PostAdapter(mContext, postList);
        postListView.setAdapter(mAdapter);

        m2Adapter = new PostAdapter2(mContext, postList);
        postListView2.setAdapter(m2Adapter);


        postList.add(GlobalData.newses.get(GlobalData.newses.size() - 1));
        postList.add(GlobalData.newses.get(GlobalData.newses.size() - 2));

        sliderImage.setPresetTransformer(SliderLayout.Transformer.DepthPage);

        sliderImage.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);

        sliderImage.setCustomAnimation(new DescriptionAnimation());

        sliderImage.setDuration(4000);
        sliderImage.startAutoCycle();

        sliderImage.addOnPageChangeListener(MainActivity.this);


    }

    @Override
    public void bindView() {
        this.playerMenu = (LinearLayout) findViewById(R.id.playerMenu);
        this.homeMenu = (LinearLayout) findViewById(R.id.homeMenu);
        this.slidinglayout = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);
        this.seeMoreBtn = (Button) findViewById(R.id.seeMoreBtn);
        this.seeMoreBtn = (Button) findViewById(R.id.seeMoreBtn);
        this.seeMoreBtn = (Button) findViewById(R.id.seeMoreBtn);
        this.seeMoreBtn = (Button) findViewById(R.id.seeMoreBtn);
        this.seeMoreBtn = (Button) findViewById(R.id.seeMoreBtn);
        this.seeMoreBtn = (Button) findViewById(R.id.seeMoreBtn);
        this.tabHost = (TabHost) findViewById(R.id.tabHost);
        this.tabcontent = (FrameLayout) findViewById(android.R.id.tabcontent);
        this.tab2 = (LinearLayout) findViewById(R.id.tab2);
        this.seeMoreLayout2 = (LinearLayout) findViewById(R.id.seeMoreLayout2);
        this.postListView2 = (ListView) findViewById(R.id.postListView2);
        this.tab1 = (LinearLayout) findViewById(R.id.tab1);
        this.seeMoreLayout = (LinearLayout) findViewById(R.id.seeMoreLayout);
        this.postListView = (ListView) findViewById(R.id.postListView);
        this.tabs = (TabWidget) findViewById(android.R.id.tabs);
        this.mainText = (TextView) findViewById(R.id.mainText);
        this.sliderImage = (SliderLayout) findViewById(R.id.sliderImage);
        this.playerLayout = (LinearLayout) findViewById(R.id.playerLayout);
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(this, slider.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Log.d("Slider Demo", "Page Changed: " + position);

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

//    public class NestedScrollableViewHelper extends ScrollableViewHelper {
//        public int getScrollableViewScrollPosition(View scrollableView, boolean isSlidingUp) {
//            if (scrollableView instanceof NestedScrollView) {
//                if (isSlidingUp) {
//                    return scrollableView.getScrollY();
//                } else {
//                    NestedScrollView nsv = ((NestedScrollView) scrollableView);
//                    View child = nsv.getChildAt(0);
//                    return (child.getBottom() - (nsv.getHeight() + nsv.getScrollY()));
//                }
//            } else {
//                return 0;
//            }
//        }
//
//
//    }


}
