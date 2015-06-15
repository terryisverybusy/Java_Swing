package dao.model;

import utils.Utils;

import java.time.LocalDateTime;

/**
 * Created by Rico on 6/13/15.
 */
public class Claim {
    public enum State {OPEN, CLOSED, HANDELING}

    private int id;
    private int userId;
    private String title;

    LocalDateTime createTime;
    LocalDateTime solvedTime = LocalDateTime.of(2000, 1, 1, 0, 0, 0, 0);
    private State state = State.OPEN;
    private String content;


    public Claim(int id, int userId, String title, LocalDateTime createTime, String content) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.createTime = createTime;
        this.content = content;
    }

    public Claim(int id, int userId, String title, LocalDateTime createTime, LocalDateTime solvedTime, State state, String content) {
        this(id, userId, title, createTime, content);
        this.solvedTime = solvedTime;
        this.state = state;
    }

    public Claim(String s) {
        String[] ss = s.split(Utils.regex);
        this.id = Integer.parseInt(ss[1].substring(1));
        this.userId = Integer.parseInt(ss[2].substring(1));
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
                solvedTime.toString() + d + state.toString() + d + content + "\n";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
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
