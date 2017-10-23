package kr.co.tje.lgtwins.data;

import java.io.Serializable;

/**
 * Created by ziO on 2017-10-23.
 */

public class CalendarResult implements Serializable {

    private String date;
    private String time;
    private String leftTeamName;
    private String leftTeamLogoURL;
    private String score;
    private String rightTeamLogoURL;
    private String rightTeamName;

    public CalendarResult() {
    }

    public CalendarResult(String date, String time, String leftTeamName, String leftTeamLogoURL, String score, String rightTeamLogoURL, String rightTeamName) {
        this.date = date;
        this.time = time;
        this.leftTeamName = leftTeamName;
        this.leftTeamLogoURL = leftTeamLogoURL;
        this.score = score;
        this.rightTeamLogoURL = rightTeamLogoURL;
        this.rightTeamName = rightTeamName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLeftTeamName() {
        return leftTeamName;
    }

    public void setLeftTeamName(String leftTeamName) {
        this.leftTeamName = leftTeamName;
    }

    public String getLeftTeamLogoURL() {
        return leftTeamLogoURL;
    }

    public void setLeftTeamLogoURL(String leftTeamLogoURL) {
        this.leftTeamLogoURL = leftTeamLogoURL;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getRightTeamLogoURL() {
        return rightTeamLogoURL;
    }

    public void setRightTeamLogoURL(String rightTeamLogoURL) {
        this.rightTeamLogoURL = rightTeamLogoURL;
    }

    public String getRightTeamName() {
        return rightTeamName;
    }

    public void setRightTeamName(String rightTeamName) {
        this.rightTeamName = rightTeamName;
    }
}
