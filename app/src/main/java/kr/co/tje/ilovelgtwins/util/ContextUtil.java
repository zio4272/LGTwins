package kr.co.tje.ilovelgtwins.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.restfb.types.User;

/**
 * Created by PC on 2017-11-21.
 */

public class ContextUtil {

    private static final String prefName = "LgTwins";

    private static final String USER_ID = "USER_ID";
    private static final String USER_LOGIN_ID = "USER_LOGIN_ID";
    private static final String USER_NAME = "USER_NAME";
    private static final String USER_GENDER = "USER_GENDER";
    private static final String USER_PHONE_NUM = "USER_PHONE_NUM";
    private static final String USER_EMAIL = "USER_EMAIL";
    private static final String USER_PROFILEURL = "USER_PROFILEURL";

    public static void login(Context context, kr.co.tje.ilovelgtwins.data.User user) {
        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);


        pref.edit().putInt(USER_ID, user.getId()).apply();
        pref.edit().putString(USER_LOGIN_ID, user.getLoginId());
        pref.edit().putString(USER_NAME, user.getUsername()).apply();
        pref.edit().putInt(USER_GENDER, user.getGender()).apply();
        pref.edit().putString(USER_PHONE_NUM, user.getPhonenum()).apply();
        pref.edit().putString(USER_EMAIL,user.getUseremail()).apply();
        pref.edit().putString(USER_PROFILEURL, user.getProfileurl()).apply();
    }

    public static kr.co.tje.ilovelgtwins.data.User getLoginUserInfo (Context context) {
        kr.co.tje.ilovelgtwins.data.User loginUser = new kr.co.tje.ilovelgtwins.data.User();

        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);


        if (pref.getInt(USER_ID, 0) >= 1) {
//            사용자의 숫자 아이디가 1이상이므로, 로그인이 되어있다고 판단.

            loginUser.setId(pref.getInt(USER_ID, 0));
            loginUser.setLoginId(pref.getString(USER_LOGIN_ID, ""));
            loginUser.setUsername(pref.getString(USER_NAME, ""));


////            가져올수있는데이터:String -> Calendar : SimpleDateFormat
//
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
//            Calendar birthDay = Calendar.getInstance();
//
//            try {
//                Date birthDayDate = sdf.parse(pref.getString(USER_BIRTHDAY, ""));
//                birthDay.setTime(birthDayDate);
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//
//            loginUser.setBirthDay(birthDay);

            loginUser.setGender(pref.getInt(USER_GENDER, 0));
            loginUser.setPhonenum(pref.getString(USER_PHONE_NUM, ""));
            loginUser.setUseremail(pref.getString(USER_EMAIL, ""));
            loginUser.setProfileurl(pref.getString(USER_PROFILEURL, ""));


        }
        else {
//            사용자 숫자 아이디가 0이거나 그보다 작으므로, 로그아웃 상태라고 판단.
//            로그아웃일 경우 : 사용자 정보에 null
            loginUser = null;
        }


        return loginUser;
    }


}
