package com.scuec.pojo;

/**
 * @author anonymity-0
 * @date 2020/8/28 - 17:36
 */
public class Collect {
    private Integer collect_id;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    private Integer user_id; //主键
    private String header; //标题
    private String author; //作者

    public Collect() {
    }

    public Integer getCollect_id() {
        return collect_id;
    }

    public void setCollect_id(Integer collect_id) {
        this.collect_id = collect_id;
    }


    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Collect(Integer collect_id, Integer user_id, String header, String author) {
        this.collect_id = collect_id;
        this.user_id = user_id;
        this.header = header;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Collect{" +
                "collectid=" + collect_id +
                ", userid=" + user_id +
                ", header='" + header + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
