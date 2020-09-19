package com.scuec.pojo;

/**
 * 收藏的文章
 */
public class Attention {
    private Integer id;
    private String username;
    private Integer userid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Attention(Integer id, String username, Integer userid) {
        this.id = id;
        this.username = username;
        this.userid = userid;
    }

    public Attention() {
    }

    @Override
    public String toString() {
        return "Attention{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", userid=" + userid +
                '}';
    }
}
