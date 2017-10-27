package kr.co.tje.ilovelgtwins.data;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by the on 2017-10-16.
 */

public class News implements Serializable {

    private int id;
    private String title;
    private String content;
    private Calendar createAt; //작성날짜


    public News() {
    }

    public News(int id,  String title, String content, Calendar createAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createAt = createAt;
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

    public Calendar getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Calendar createAt) {
        this.createAt = createAt;
    }
}
