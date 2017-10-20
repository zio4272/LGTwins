package kr.co.tje.lgtwins.data;

/**
 * Created by user on 2017-10-20.
 */

public class Team {
    private int rank;
    private String name;
    private String url;

    public Team() {
    }

    public Team(int rank, String name, String url) {
        this.rank = rank;
        this.name = name;
        this.url = url;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
