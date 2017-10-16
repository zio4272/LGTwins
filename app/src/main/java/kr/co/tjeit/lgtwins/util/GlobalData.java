package kr.co.tjeit.lgtwins.util;

import java.util.ArrayList;
import java.util.List;

import kr.co.tjeit.lgtwins.data.Player;
import kr.co.tjeit.lgtwins.data.Post;

/**
 * Created by the on 2017-10-16.
 */

public class GlobalData {

    public static List<Post> posts = new ArrayList<>();
    public static List<Player> players = new ArrayList<>();

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


    }
}
