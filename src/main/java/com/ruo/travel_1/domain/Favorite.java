package com.ruo.travel_1.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 收藏实体类
 */
public class Favorite implements Serializable {
    private Route route;//旅游线路对象

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;//收藏时间

    private User user;//所属用户

    private  int rid;
    private  int uid;
    /**
     * 无参构造方法
     */
    public Favorite() {
    }

    /**
     * 有参构造方法
     * @param route
     * @param date
     * @param user
     */


    public Favorite(Route route, Date date, User user, int rid, int uid) {
        this.route = route;
        this.date = date;
        this.user = user;
        this.rid = rid;
        this.uid = uid;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
