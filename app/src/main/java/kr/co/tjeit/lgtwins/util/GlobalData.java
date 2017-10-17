package kr.co.tjeit.lgtwins.util;

import java.io.CharArrayReader;
import java.util.ArrayList;
import java.util.Calendar;
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
        newses.add(new News(0, "류중일 감독 취임식", "LG트윈스는 류중일 신임 감독 취임식을 10월 13일(금) 15시에 잠실야구장에서 진행한다.\n\n이날 취임식에는 신문범 대표이사와 양상문 단장, 진혁 경영지원실장을 비롯한 프런트와 선수단 대표로 주장 \n류제국 등이 참석하여 류중일 감독의 취임을 축하할 예정이다.\n\n한편, 이날 류중일 감독의 취임식이 끝난 후 기자회견도 예정되어 있다. (끝)", Calendar.getInstance()));
        newses.add(new News(1, "한국 프로스포츠 최다 12번째 시즌 100만 관중","누적 관중수 사상 최다 2천 8백 50만명 돌파.... 샬라라라라라", Calendar.getInstance()));
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
        noticeAndEvents.add(new NoticeAndEvent(0,"LG트윈스프로야구단 응원/이벤트 대행사 입찰공고","2018년 ~ 2019년 응원/이벤트 대행사 입찰을 아래와 같이 진행합니다.\n\n가. 사업명 : LG트윈스프로야구단 응원/이벤트 대행\n나. 수요기관 : (주)엘지스포츠\n다. 입찰방식 : 경쟁입찰 (나라장터)\n라. 입찰 관련 상세내용은 나라장터의 입찰공고를 참조 부탁드립니다.\n※ 입찰의향서 제출은 나라장터 공고문 양식 참조, 이메일(twins@sportslg.com) 접수" , Calendar.getInstance()));
        noticeAndEvents.add(new NoticeAndEvent(1,"인터파크 상품권(쿠폰번호) 사용 안내","내용이쏼롸쏼라", Calendar.getInstance()));
        noticeAndEvents.add(new NoticeAndEvent());
        noticeAndEvents.add(new NoticeAndEvent());
        noticeAndEvents.add(new NoticeAndEvent());

        mainSliderPosts.clear();
        mainSliderPosts.add(new MainSliderPost());



    }
}
