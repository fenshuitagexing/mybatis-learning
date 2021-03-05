package net.xdclass.online_class.domain;

import java.io.Serializable;
import java.util.Date;

// DTO class
public class VideoOrder implements Serializable {

    private int id;
    private int videoId;
    private int userId;
    private String orderNumber;
    private int state;
    private Date creationTime;
    private int totalFee;
    private String videoTitle;
    private String videoImg;
    private User user;

    @Override
    public String toString() {
        return "VideoOrder{" +
                "id=" + id +
                ", videoId=" + videoId +
                ", userId=" + userId +
                ", orderNumber='" + orderNumber + '\'' +
                ", state=" + state +
                ", creationTime=" + creationTime +
                ", totalFee=" + totalFee +
                ", videoTitle='" + videoTitle + '\'' +
                ", videoImg='" + videoImg + '\'' +
                ", user=" + user +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public int getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(int totalFee) {
        this.totalFee = totalFee;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public String getVideoImg() {
        return videoImg;
    }

    public void setVideoImg(String videoImg) {
        this.videoImg = videoImg;
    }
}
