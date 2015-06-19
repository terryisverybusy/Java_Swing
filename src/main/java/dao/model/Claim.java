package dao.model;

import utils.Utils;

import java.time.LocalDateTime;

/**
 * Created by Rico on 6/13/15.
 */
public class Claim {
    public enum State {OPEN, CLOSED, HANDELING}

    private long id = System.currentTimeMillis();
    private long userId;
    private String title;
    LocalDateTime createTime = LocalDateTime.now();
    LocalDateTime solvedTime = LocalDateTime.of(2000, 1, 1, 0, 0, 0, 0);
    private State state = State.OPEN;
    private String content;


    public Claim(long userId, String title,  String content) {
        this.userId = userId;
        this.title = title;
        this.content = content;
    }

    public Claim(long id, long userId, String title, LocalDateTime createTime, LocalDateTime solvedTime, State state, String content) {
        this(userId, title, content);
        this.id = id;
        this.createTime = createTime;
        this.solvedTime = solvedTime;
        this.state = state;
    }

    public Claim(String s) {
        String[] ss = s.split(Utils.regex);
        this.id = Long.parseLong(ss[1].substring(1));
        this.userId = Long.parseLong(ss[2].substring(1));
        this.title = ss[3];
        this.createTime = LocalDateTime.parse(ss[4]);
        this.solvedTime = LocalDateTime.parse(ss[5]);
        this.state = State.valueOf(ss[6]);
        this.content = ss[7];
    }

    public String toString() {
        String d = Utils.delim;
        return d + "c" + String.valueOf(id) + d + "u" + String.valueOf(userId)
                + d + title + d + createTime.toString() + d +
                solvedTime.toString() + d + state.toString() + d + content;
    }

    public long getId() {
        return id;
    }


    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getSolvedTime() {
        return solvedTime;
    }

    public void setSolvedTime(LocalDateTime solvedTime) {
        this.solvedTime = solvedTime;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }


}
