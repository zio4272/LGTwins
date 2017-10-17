package kr.co.tjeit.lgtwins.util;

import java.util.ArrayList;
import java.util.List;

import kr.co.tjeit.lgtwins.data.Player;
import kr.co.tjeit.lgtwins.data.Post;
import kr.co.tjeit.lgtwins.data.TwinsPhoto;

/**
 * Created by the on 2017-10-16.
 */

public class GlobalData {

    public static List<Post> posts = new ArrayList<>();
    public static List<Player> players = new ArrayList<>();
    public static List<TwinsPhoto> twinsPhotos = new ArrayList<>();

    public static void initGlobalData () {

        posts.clear();
        posts.add(new Post());
        posts.add(new Post());
        posts.add(new Post());
        posts.add(new Post());
        posts.add(new Post());
        posts.add(new Post());
        posts.add(new Post());
        posts.add(new Post());
        posts.add(new Post());
        posts.add(new Post());
        posts.add(new Post());

        players.clear();
        players.add(new Player());
        players.add(new Player());
        players.add(new Player());
        players.add(new Player());
        players.add(new Player());
        players.add(new Player());
        players.add(new Player());
        players.add(new Player());

        twinsPhotos.clear();
        twinsPhotos.add(new TwinsPhoto(0,"29일 잠실 두산전 3대5", "관리자", "http://rucid.dothome.co.kr/wp-content/uploads/2017/08/20_lcw_m_03-980x980.jpg"));


    }
}
