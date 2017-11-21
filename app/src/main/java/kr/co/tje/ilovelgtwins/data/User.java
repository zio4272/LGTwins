package kr.co.tje.ilovelgtwins.data;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by the on 2017-11-01.
 */

public class User implements Serializable {

    private int id;
    private String loginId;
    private String loginPw;
    private String username;
    private int gender;
    private String phonenum;
    private String useremail;
    private String profileurl;

    public static User getUserFromJson (JSONObject jsonObject) {

        User user = new User();

        try {
            user.loginId = jsonObject.getString("loginId");
            user.loginPw = jsonObject.getString("loginPw");
            user.username = jsonObject.getString("username");
            user.gender = jsonObject.getInt("gender");
            user.phonenum = jsonObject.getString("phonenum");
            user.useremail = jsonObject.getString("useremail");
            user.profileurl = jsonObject.getString("profileURL");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return user;

    }

    public User() {
    }

    public User(int id, String loginId, String loginPw, String username, int gender, String phonenum, String useremail, String profileurl) {
        this.id = id;
        this.loginId = loginId;
        this.loginPw = loginPw;
        this.username = username;
        this.gender = gender;
        this.phonenum = phonenum;
        this.useremail = useremail;
        this.profileurl = profileurl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getLoginPw() {
        return loginPw;
    }

    public void setLoginPw(String loginPw) {
        this.loginPw = loginPw;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getProfileurl() {
        return profileurl;
    }

    public void setProfileurl(String profileurl) {
        this.profileurl = profileurl;
    }
}
