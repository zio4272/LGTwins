package kr.co.tje.lgtwins;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
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
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.restfb.FacebookClient;
import com.restfb.types.GraphResponse;
import com.restfb.types.Post;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.logging.Handler;

import kr.co.tje.lgtwins.adapter.NoticeAndEventAdapter;
import kr.co.tje.lgtwins.adapter.PostAdapter;
import kr.co.tje.lgtwins.data.News;
import kr.co.tje.lgtwins.data.NoticeAndEvent;
import kr.co.tje.lgtwins.util.GlobalData;
import kr.co.tje.lgtwins.util.ServerUtil;


public class MainActivity extends BaseActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    SliderLayout sliderLayout;

    PostAdapter mAdapter;
    NoticeAndEventAdapter m2Adapter;

    List<News> postList = new ArrayList<>();
    List<NoticeAndEvent> noticeAndEventList = new ArrayList<>();

    HashMap<String, String> HashMapForURL;
    HashMap<String, Integer> HashMapForLocalRes;

    private AccessToken accessToken;

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
    private LinearLayout seeMoreMenu;
    private LinearLayout seeMoreMenuLayout;
    private TextView currentTempTxt;
    private TextView skyTxt;
    private android.widget.ImageView skyImage;
    private LinearLayout teamRankLayout;
    private LinearLayout calendarAndResultLayout;

    private FacebookClient facebookClient;
    private ListView lvArticleListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindView();
        setupEvent();
        setValues();

        GraphRequest request = GraphRequest.newGraphPathRequest(accessToken, "/997476320324005/feed", new GraphRequest.Callback() {
            @Override
            public void onCompleted(com.facebook.GraphResponse response) {
                Log.d("뭐나오나요", response.toString());

            }
        });

        request.executeAsync();


        ServerUtil.FacebookAccessToken(mContext, new ServerUtil.JsonResponseHandler() {
            @Override
            public void onResponse(JSONObject json) {
                Log.d("페이스북ACCESS_TOKEN", json.toString());
            }
        });


//        어플 시작시 무조건 실행
//        잠실야구장의 위도 경도만 불러옴
        ServerUtil.getCurrentWeatherFromServer(mContext, 37.512096, 127.071847, new ServerUtil.JsonResponseHandler() {
            @Override
            public void onResponse(JSONObject json) {

                Log.d("실시간날씨JSON", json.toString());

                try {
                    skyTxt.setText(json.getJSONObject("weather").getJSONArray("minutely").getJSONObject(0).getJSONObject("sky").getString("name"));
                    currentTempTxt.setText(String.format(Locale.KOREA, "%.1f ˚", Double.parseDouble(json.getJSONObject("weather").getJSONArray("minutely").getJSONObject(0).getJSONObject("temperature").getString("tc"))));

                    String weatherState = json.getJSONObject("weather").getJSONArray("minutely").getJSONObject(0).getJSONObject("sky").getString("name");
                    switch (weatherState) {
                        case "상태없음":
                            skyImage.setImageResource(R.drawable.sky_a00);
                            break;
                        case "맑음":
                            skyImage.setImageResource(R.drawable.sky_a01);
                            break;
                        case "구름조금":
                            skyImage.setImageResource(R.drawable.sky_a02);
                            break;
                        case "구름많음":
                            skyImage.setImageResource(R.drawable.sky_a03);
                            break;
                        case "구름많고 비":
                            skyImage.setImageResource(R.drawable.sky_a04);
                            break;
                        case "구름많고 눈":
                            skyImage.setImageResource(R.drawable.sky_a05);
                            break;
                        case "구름많고 비 또는 눈":
                            skyImage.setImageResource(R.drawable.sky_a06);
                            break;
                        case "흐림":
                            skyImage.setImageResource(R.drawable.sky_a07);
                            break;
                        case "흐리고 비":
                            skyImage.setImageResource(R.drawable.sky_a08);
                            break;
                        case "흐리고 눈":
                            skyImage.setImageResource(R.drawable.sky_a09);
                            break;
                        case "흐리고 비 또는 눈":
                            skyImage.setImageResource(R.drawable.sky_a10);
                            break;
                        case "흐리고낙뢰":
                            skyImage.setImageResource(R.drawable.sky_a11);
                            break;
                        case "뇌우, 비":
                            skyImage.setImageResource(R.drawable.sky_a12);
                            break;
                        case "뇌우, 눈":
                            skyImage.setImageResource(R.drawable.sky_a13);
                            break;
                        case "뇌우, 비 또는 눈":
                            skyImage.setImageResource(R.drawable.sky_a14);
                            break;

                    }

//                            하늘상태코드명
//                            -SKY_A00:상태없음
//                            -sky_a01:맑음
//                            -SKY_A02:구름조금
//                            -SKY_A03:구름많음
//                            -SKY_A04:구름많고 비
//                            -SKY_A05:구름많고 눈
//                            -SKY_A06:구름많고 비 또는 눈
//                            -SKY_A07:흐림
//                            -SKY_A08:흐리고 비
//                            -SKY_A09:흐리고 눈
//                            -SKY_A10:흐리고 비 또는 눈
//                            -SKY_A11:흐리고 낙뢰
//                            -SKY_A12:뇌우, 비
//                            -SKY_A13:뇌우, 눈
//                            -SKY_A14:뇌우, 비 또는 눈

//                    if (json.getJSONObject("weather").getJSONArray("minutely").getJSONObject(0).getJSONObject("sky").getString("name").equals("흐림")) {
//                        skyImage.setImageResource(R.drawable.above_shadow);
//                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });


        //모든 액션바 삭제
        getSupportActionBar().hide();


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

        calendarAndResultLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, CalendarAndResultActivity.class);
                startActivity(intent);
            }
        });

        teamRankLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, TeamRankActivity.class);
                startActivity(intent);
            }
        });

        postListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(mContext, PostDetailViewActivity.class);
                startActivity(intent);
            }
        });

        postListView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(mContext, NoticeAndEventDetailViewActivity.class);
                startActivity(intent);
            }
        });


        playerMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.playerMenu:
                        playerLayout.setVisibility(View.VISIBLE);
                        slidinglayout.setVisibility(View.GONE);
                        seeMoreMenuLayout.setVisibility(View.GONE);
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
                        seeMoreMenuLayout.setVisibility(View.GONE);
                        break;


                }
            }
        });

        seeMoreMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.seeMoreMenu:
                        playerLayout.setVisibility(View.GONE);
                        slidinglayout.setVisibility(View.GONE);
                        seeMoreMenuLayout.setVisibility(View.VISIBLE);
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
        slidinglayout.setAnchorPoint(1.0f); // 1.0f = 100% , 0.7f = 70% 업
        slidinglayout.setPanelHeight(500); // 접혀있는 상태 기본 세로 크기


        mAdapter = new PostAdapter(mContext, postList);
        postListView.setAdapter(mAdapter);

        m2Adapter = new NoticeAndEventAdapter(mContext, noticeAndEventList);
        postListView2.setAdapter(m2Adapter);


        postList.add(GlobalData.newses.get(GlobalData.newses.size() - 1));
        postList.add(GlobalData.newses.get(GlobalData.newses.size() - 2));

        noticeAndEventList.add(GlobalData.noticeAndEvents.get(GlobalData.noticeAndEvents.size() - 1));
        noticeAndEventList.add(GlobalData.noticeAndEvents.get(GlobalData.noticeAndEvents.size() - 2));

        sliderImage.setPresetTransformer(SliderLayout.Transformer.DepthPage);

        sliderImage.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);

        sliderImage.setCustomAnimation(new DescriptionAnimation());

        sliderImage.setDuration(4000);
        sliderImage.startAutoCycle();

        sliderImage.addOnPageChangeListener(MainActivity.this);


    }

    @Override
    public void bindView() {
        this.seeMoreMenu = (LinearLayout) findViewById(R.id.seeMoreMenu);
        this.playerMenu = (LinearLayout) findViewById(R.id.playerMenu);
        this.homeMenu = (LinearLayout) findViewById(R.id.homeMenu);
        this.teamRankLayout = (LinearLayout) findViewById(R.id.teamRankLayout);
        this.calendarAndResultLayout = (LinearLayout) findViewById(R.id.calendarAndResultLayout);
        this.slidinglayout = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);
        this.lvArticleListView = (ListView) findViewById(R.id.lvArticleListView);
        this.skyImage = (ImageView) findViewById(R.id.skyImage);
        this.skyTxt = (TextView) findViewById(R.id.skyTxt);
        this.currentTempTxt = (TextView) findViewById(R.id.currentTempTxt);
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
        this.seeMoreMenuLayout = (LinearLayout) findViewById(R.id.seeMoreMenuLayout);
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

    public void backPressed() {

    }


}
