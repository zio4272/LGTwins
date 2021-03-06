package kr.co.tje.ilovelgtwins.data;

import java.io.Serializable;

/**
 * Created by the on 2017-10-16.
 */

public class Player implements Serializable {

    private int id;
    private int backNumber;
    private String name;
    private int position;
    // 0전체 1투수 2포수 3내야수 4외야수 5육성선수
    private String useHand;
    private String profileImgURL;


    public Player() {
    }

    public Player(int id, int backNumber, String name, int position, String useHand, String profileImgURL) {
        this.id = id;
        this.backNumber = backNumber;
        this.name = name;
        this.position = position;
        this.useHand = useHand;
        this.profileImgURL = profileImgURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBackNumber() {
        return backNumber;
    }

    public void setBackNumber(int backNumber) {
        this.backNumber = backNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getUseHand() {
        return useHand;
    }

    public void setUseHand(String useHand) {
        this.useHand = useHand;
    }

    public String getProfileImgURL() {
        return profileImgURL;
    }

    public void setProfileImgURL(String profileImgURL) {
        this.profileImgURL = profileImgURL;
    }
}
