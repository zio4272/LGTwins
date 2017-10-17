package kr.co.tjeit.lgtwins.data;

import java.io.Serializable;

/**
 * Created by the on 2017-10-17.
 */

public class MainSliderPost implements Serializable {

//   메인슬라이더에 들어가는 사진은 따로 관리하지 않음
    private String title;
    private String imageURL;

    public MainSliderPost() {
    }

    public MainSliderPost(String title, String imageURL) {
        this.title = title;
        this.imageURL = imageURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
