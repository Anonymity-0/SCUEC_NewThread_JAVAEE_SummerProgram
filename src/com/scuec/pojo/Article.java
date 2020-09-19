package com.scuec.pojo;

/**
 * @author anonymity-0
 * @date 2020/8/28 - 17:36
 */
public class Article extends Collect {
        private Integer id; //主键
        private String header; //标题
        private String content; //文章内容
        private String author; //作者

    public static Integer getTotalNumber() {
        return totalNumber;
    }

    public static void setTotalNumber(Integer totalNumber) {
        Article.totalNumber = totalNumber;
    }

    private static Integer totalNumber=0;

    public Article(Integer id, String header, String content, String author) {
        this.id = id;
        this.header = header;
        this.content = content;
        this.author = author;
    }

    public Article() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }



    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", header='" + header + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
