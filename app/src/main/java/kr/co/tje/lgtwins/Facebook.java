package kr.co.tje.lgtwins;

import android.content.Context;
import android.util.Log;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.types.Post;
import com.restfb.types.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by the on 2017-10-25.
 */

public class Facebook {

    // 인증과 관련된 상수들
    private static final String APP_ID = "1648925831797110";
    private static final String APP_SECRET = "af55a6b5cb9fb9d5bfe354c9f0489957";
    public static final String ACCESS_TOKEN = "1648925831797110|fi5BBS1tpdW29Mb-PgCsj_vqeII";

    private Context mContext;

    // 페이스북 인증객체
    private FacebookClient myFacebook;
    private boolean isLogin;


    public Facebook(Context context) {
        mContext = context;
    }

    // 페이스북으로 로그인
    // 성공시 true

    public void auth() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //Facebook 로그인
                myFacebook = new DefaultFacebookClient(ACCESS_TOKEN, Version.LATEST);

                // 로그인이 성공했는지 체크한다.
                // 로그인된 계정의 정보를 가져온다.
                User me = myFacebook.fetchObject("me", User.class);

                Log.d("FACEBOOK", me.getName() + " 계정으로 로그인 함.");

                isLogin = me != null;


            }
        }).start();
    }

    public boolean isLogin() {
        return isLogin;
    }


    public void getTimeLine(final TimelineSerializable timelineSerializable) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 나의 타임라인에서 포스트들을 가져온다.
                Connection<Post> feeds = myFacebook.fetchConnection("me/feed", Post.class, Parameter.with("fields", "id,from,likes,message,story,link"));

                List<Post> postList = new ArrayList<Post>();
                // 타임라인 정보들...
                for (List<Post> posts : feeds) {
                    postList.addAll(posts);

                }
                timelineSerializable.serialize(postList);

            }
        }).start();

    }

    public interface TimelineSerializable {

        public void serialize(List<Post> posts);
    }


}
