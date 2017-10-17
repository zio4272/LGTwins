package kr.co.tjeit.lgtwins;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.sothree.slidinguppanel.ScrollableViewHelper;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kr.co.tjeit.lgtwins.adapter.PostAdapter;
import kr.co.tjeit.lgtwins.data.Post;
import kr.co.tjeit.lgtwins.util.GlobalData;


public class MainActivity extends BaseActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    SliderLayout sliderLayout;
    PostAdapter mAdapter;
    List<Post> postList = new ArrayList<>();
    HashMap<String, String> HashMapForURL;
    HashMap<String, Integer> HashMapForLocalRes;

    private com.sothree.slidinguppanel.SlidingUpPanelLayout slidinglayout;
    private android.widget.ListView postListView;
    private android.widget.Button seeMoreBtn;
    private android.widget.LinearLayout playerMenu;
    private LinearLayout playerLayout;
    private LinearLayout homeLayout;
    private LinearLayout homeMenu;
    private SliderLayout sliderImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindView();
        setupEvent();
        setValues();

        // 이미지 슬라이드
        AddImagesUrlOnline(); // URL에 있는걸 가져와서 보여주는것
//        AddImageUrlFormLocalRes(); // 자체적으로 저장된 파일


        for (String name : HashMapForURL.keySet()) {
            TextSliderView textSliderView = new TextSliderView(mContext);
            textSliderView.description(name).image(HashMapForURL.get(name)).setScaleType(BaseSliderView.ScaleType.Fit).setOnSliderClickListener(this);
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle().putString("extra", name);
            sliderImage.addSlider(textSliderView);

        }


    }



    // URL에서 이미지 불러오기 (인터넷 권한 설정 해야함)
    private void AddImagesUrlOnline() {

        HashMapForURL = new HashMap<String, String>();

        HashMapForURL.put("CupCake", "http://androidblog.esy.es/images/cupcake-1.png");
        HashMapForURL.put("Donut", "http://androidblog.esy.es/images/donut-2.png");
        HashMapForURL.put("Eclair", "http://androidblog.esy.es/images/eclair-3.png");
        HashMapForURL.put("Froyo", "http://androidblog.esy.es/images/froyo-4.png");
        HashMapForURL.put("GingerBread", "http://androidblog.esy.es/images/gingerbread-5.png");

    }

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

        postList.add(GlobalData.posts.get(GlobalData.posts.size() - 1));
        postList.add(GlobalData.posts.get(GlobalData.posts.size() - 2));

        sliderImage.setPresetTransformer(SliderLayout.Transformer.DepthPage);

        sliderImage.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);

        sliderImage.setCustomAnimation(new DescriptionAnimation());

        sliderImage.setDuration(3000);
        sliderImage.startAutoCycle();

        sliderImage.addOnPageChangeListener(MainActivity.this);


    }

    @Override
    public void bindView() {
        this.playerMenu = (LinearLayout) findViewById(R.id.playerMenu);
        this.homeMenu = (LinearLayout) findViewById(R.id.homeMenu);
        this.slidinglayout = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);
        this.seeMoreBtn = (Button) findViewById(R.id.seeMoreBtn);
        this.postListView = (ListView) findViewById(R.id.postListView);
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
