package dao.model;

import java.time.LocalDateTime;

/**
 * Created by Rico on 6/13/15.
 */
public class Claim {
    public enum State {
        OPEN, CLOSED, HANDELING
    }

    private int id;
    private int userId;
    private String title;

    LocalDateTime createTime;
    LocalDateTime solvedTime;
    private State state;
    private String content;

    public String toString() {
        return String.valueOf(id) + "||" + String.valueOf(userId)
                + "||" + title + "||" + createTime.toString() + "||" +
                solvedTime.toString() + "||" + state.toString() + "||" + content + "||";
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
