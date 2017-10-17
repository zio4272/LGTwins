package kr.co.tjeit.lgtwins.util;

import java.util.ArrayList;
import java.util.List;

import kr.co.tjeit.lgtwins.data.MainSliderPost;
import kr.co.tjeit.lgtwins.data.NoticeAndEvent;
import kr.co.tjeit.lgtwins.data.Player;
import kr.co.tjeit.lgtwins.data.News;
import kr.co.tjeit.lgtwins.data.TwinsPhoto;

/**
 * Created by the on 2017-10-16.
 */

public class GlobalData {

    public static List<News> newses = new ArrayList<>();
    public static List<Player> players = new ArrayList<>();
    public static List<TwinsPhoto> twinsPhotos = new ArrayList<>();
    public static List<NoticeAndEvent> noticeAndEvents = new ArrayList<>();
    public static List<MainSliderPost> mainSliderPosts = new ArrayList<>();

    public static void initGlobalData() {

        newses.clear();
        newses.add(new News());
        newses.add(new News());
        newses.add(new News());
        newses.add(new News());
        newses.add(new News());
        newses.add(new News());
        newses.add(new News());
        newses.add(new News());
        newses.add(new News());
        newses.add(new News());
        newses.add(new News());

        players.clear();
        players.add(new Player(0, 51, "봉중근", 1, "좌투좌타", "http://rucid.dothome.co.kr/wp-content/uploads/2017/08/20_lcw_m_03-980x980.jpg"));
        players.add(new Player(1, 42, "정상호", 2, "우투우타", "http://rucid.dothome.co.kr/wp-content/uploads/2017/08/20_lcw_m_03-980x980.jpg"));
        players.add(new Player(2, 16, "정성훈", 3, "우투우타", "http://rucid.dothome.co.kr/wp-content/uploads/2017/08/20_lcw_m_03-980x980.jpg"));
        players.add(new Player(3, 33, "박용택", 4, "우투좌타", "http://rucid.dothome.co.kr/wp-content/uploads/2017/08/20_lcw_m_03-980x980.jpg"));
        players.add(new Player(4, 121, "나규호", 5, "우투우타", "http://rucid.dothome.co.kr/wp-content/uploads/2017/08/20_lcw_m_03-980x980.jpg"));


        twinsPhotos.clear();
        twinsPhotos.add(new TwinsPhoto(0, "29일 잠실 두산전 3대5", "관리자", "http://rucid.dothome.co.kr/wp-content/uploads/2017/08/20_lcw_m_03-980x980.jpg"));
        twinsPhotos.add(new TwinsPhoto(1, "우승해본게 언젠지..", "관리자", "http://www.lgchallengers.com/wp-content/uploads/2012/08/20120821_01.jpg"));
        twinsPhotos.add(new TwinsPhoto(2, "안녕반가웡~~", "관리자", "http://img.yonhapnews.co.kr/etc/inner/EN/2013/08/19/AEN20130819001300315_01_i.jpg"));

        noticeAndEvents.clear();
        noticeAndEvents.add(new NoticeAndEvent());
        noticeAndEvents.add(new NoticeAndEvent());
        noticeAndEvents.add(new NoticeAndEvent());
        noticeAndEvents.add(new NoticeAndEvent());
        noticeAndEvents.add(new NoticeAndEvent());

        mainSliderPosts.clear();
        mainSliderPosts.add(new MainSliderPost());



    }
}
