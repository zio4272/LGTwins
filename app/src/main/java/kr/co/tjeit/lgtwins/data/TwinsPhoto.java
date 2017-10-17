package kr.co.tjeit.lgtwins.data;

import java.io.Serializable;

/**
 * Created by the on 2017-10-17.
 */

public class TwinsPhoto implements Serializable {

    private int id;
    private String title;
    private String content;
    private String imageURL;

    public TwinsPhoto() {
    }

    public TwinsPhoto(int id, String title, String content, String imageURL) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.imageURL = imageURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
