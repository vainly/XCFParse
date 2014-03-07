package com.cl.xcf.model;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

/**
 * CREATE BY INTELLIJ IDEA
 * user: chl
 * Date: 14-2-13 下午1:05
 */
@Entity("step")
public class Step {

    //com.cl.xcf.model.Cooking id
    @Property("cook_id")
    private String cookId;

    @Id
    private String id;

    //序号
    @Property("sep")
    private int seq;

    //步骤内容
    @Property("text")
    private String text;

    //图片地址
    @Property("img_url")
    private String imgUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCookId() {
        return cookId;
    }

    public void setCookId(String cookId) {
        this.cookId = cookId;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
