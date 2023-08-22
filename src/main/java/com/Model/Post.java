package com.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//    tieu de
    @Column(nullable = false)
    private String postTitle;
//    tom tat
    @Column(nullable = false)
    private String postAbstract;
//    phụ lục
    @Column(nullable = false)
    private String appendices;
    @Column(nullable = false)
    private String imageMain;
    @Column(nullable = false)
    private String imageSupport1;
    @Column(nullable = false)
    private String imageSupport2;
    @Column(nullable = false)
    private String imageSupport3;
    @Column(nullable = false)
    private String imageSupport4;
    @ManyToOne
    private Category category;
    @Temporal(TemporalType.TIMESTAMP) // Đặt kiểu thời gian
    @Column(name = "postDate", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date postDate;

    public Post() {
    }

    public Post(int id, String postTitle, String postAbstract, String appendices, String imageMain, String imageSupport1, String imageSupport2, String imageSupport3, String imageSupport4 , Category category) {
        this.id = id;
        this.postTitle = postTitle;
        this.postAbstract = postAbstract;
        this.appendices = appendices;
        this.imageMain = imageMain;
        this.imageSupport1 = imageSupport1;
        this.imageSupport2 = imageSupport2;
        this.imageSupport3 = imageSupport3;
        this.imageSupport4 = imageSupport4;
        this.category = category;
        Date date = new Date();
        this.postDate = date;
    }

    public Post(String postTitle, String postAbstract, String appendices, String imageMain, String imageSupport1, String imageSupport2, String imageSupport3, String imageSupport4 , Category category) {
        this.postTitle = postTitle;
        this.postAbstract = postAbstract;
        this.appendices = appendices;
        this.imageMain = imageMain;
        this.imageSupport1 = imageSupport1;
        this.imageSupport2 = imageSupport2;
        this.imageSupport3 = imageSupport3;
        this.imageSupport4 = imageSupport4;
        this.category = category;
        Date date = new Date();
        this.postDate = date;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostAbstract() {
        return postAbstract;
    }

    public void setPostAbstract(String postAbstract) {
        this.postAbstract = postAbstract;
    }

    public String getAppendices() {
        return appendices;
    }

    public void setAppendices(String appendices) {
        this.appendices = appendices;
    }

    public String getImageMain() {
        return imageMain;
    }

    public void setImageMain(String imageMain) {
        this.imageMain = imageMain;
    }

    public String getImageSupport1() {
        return imageSupport1;
    }

    public void setImageSupport1(String imageSupport1) {
        this.imageSupport1 = imageSupport1;
    }

    public String getImageSupport2() {
        return imageSupport2;
    }

    public void setImageSupport2(String imageSupport2) {
        this.imageSupport2 = imageSupport2;
    }

    public String getImageSupport3() {
        return imageSupport3;
    }

    public void setImageSupport3(String imageSupport3) {
        this.imageSupport3 = imageSupport3;
    }

    public String getImageSupport4() {
        return imageSupport4;
    }

    public void setImageSupport4(String imageSupport4) {
        this.imageSupport4 = imageSupport4;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}