package kr.co.tje.lgtwins.data;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by the on 2017-10-17.
 */

public class NoticeAndEvent implements Serializable {
    private int id;
    private String title;
    private String content;
    private Calendar createAt; //작성날짜


    public NoticeAndEvent() {
    }

    public NoticeAndEvent(int id,  String title, String content, Calendar createAt) {
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
