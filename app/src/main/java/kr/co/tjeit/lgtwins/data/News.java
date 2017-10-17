package kr.co.tjeit.lgtwins.data;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by the on 2017-10-16.
 */

public class News implements Serializable {

    private int id;
    private int category;
    private String title;
    private String content;
    private Calendar createAt; //작성날짜


    public News() {
    }

    public News(int id, int category, String title, String content, Calendar createAt) {
        this.id = id;
        this.category = category;
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

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
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
