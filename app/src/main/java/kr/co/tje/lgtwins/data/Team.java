package kr.co.tje.lgtwins.data;

import java.io.Serializable;

/**
 * Created by user on 2017-10-20.
 */

public class Team implements Serializable {

    private int rank;
    private String name;
    private String url;
    private String totGameCount; // 총경기수
    private String winGame; // 승
    private String loseGame; // 패
    private String drawGame; // 무
    private String winRating; // 승률
    private String equalsGame; // 게임차
    private String againGame; // 연속 (연승 연패 등)
    private String goBase; // 출루율
    private String bigHit; // 장타율
    private String latestTenGame; // 최근10경기


    public Team() {
    }

    public Team(int rank, String name, String url, String totGameCount, String winGame, String loseGame, String drawGame, String winRating, String equalsGame, String againGame, String goBase, String bigHit, String latestTenGame) {
        this.rank = rank;
        this.name = name;
        this.url = url;
        this.totGameCount = totGameCount;
        this.winGame = winGame;
        this.loseGame = loseGame;
        this.drawGame = drawGame;
        this.winRating = winRating;
        this.equalsGame = equalsGame;
        this.againGame = againGame;
        this.goBase = goBase;
        this.bigHit = bigHit;
        this.latestTenGame = latestTenGame;
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

    public String getTotGameCount() {
        return totGameCount;
    }

    public void setTotGameCount(String totGameCount) {
        this.totGameCount = totGameCount;
    }

    public String getWinGame() {
        return winGame;
    }

    public void setWinGame(String winGame) {
        this.winGame = winGame;
    }

    public String getLoseGame() {
        return loseGame;
    }

    public void setLoseGame(String loseGame) {
        this.loseGame = loseGame;
    }

    public String getDrawGame() {
        return drawGame;
    }

    public void setDrawGame(String drawGame) {
        this.drawGame = drawGame;
    }

    public String getWinRating() {
        return winRating;
    }

    public void setWinRating(String winRating) {
        this.winRating = winRating;
    }

    public String getEqualsGame() {
        return equalsGame;
    }

    public void setEqualsGame(String equalsGame) {
        this.equalsGame = equalsGame;
    }

    public String getAgainGame() {
        return againGame;
    }

    public void setAgainGame(String againGame) {
        this.againGame = againGame;
    }

    public String getGoBase() {
        return goBase;
    }

    public void setGoBase(String goBase) {
        this.goBase = goBase;
    }

    public String getBigHit() {
        return bigHit;
    }

    public void setBigHit(String bigHit) {
        this.bigHit = bigHit;
    }

    public String getLatestTenGame() {
        return latestTenGame;
    }

    public void setLatestTenGame(String latestTenGame) {
        this.latestTenGame = latestTenGame;
    }
}