package kr.co.tjeit.lgtwins;

import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.view.menu.MenuAdapter;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.sothree.slidinguppanel.ScrollableViewHelper;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import java.util.ArrayList;
import java.util.List;

import kr.co.tjeit.lgtwins.adapter.MainAdapter;
import kr.co.tjeit.lgtwins.data.Post;


public class MainActivity extends BaseActivity {
//
    MainAdapter mAdapter;
    List<Post> postList = new ArrayList<>();

    private com.sothree.slidinguppanel.SlidingUpPanelLayout slidinglayout;
    private android.widget.ListView postListView;

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

        slidinglayout.addPanelSlideListener(new SlidingUpPanelLayout.PanelSlideListener() {
            @Override
            public void onPanelSlide(View panel, float slideOffset) {

            }

            @Override
            public void onPanelStateChanged(View panel, SlidingUpPanelLayout.PanelState previousState, SlidingUpPanelLayout.PanelState newState) {

                // 축소될 경우
                if (newState.name().toString().equalsIgnoreCase("Collapsed")) {

                    slidinglayout.setScrollableViewHelper(null);

                    // 펴질 경우
                } else if (newState.name().equalsIgnoreCase("Expanded")) {
                    slidinglayout.setScrollableViewHelper(new NestedScrollableViewHelper());

                }

            }
        });

    }

    @Override
    public void setValues() {
        mAdapter = new MainAdapter(mContext, postList);
        postListView.setAdapter(mAdapter);
//        slidinglayout.setTouchEnabled(true);


    }

    @Override
    public void bindView() {
        this.slidinglayout = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);
        this.postListView = (ListView) findViewById(R.id.postListView);

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
