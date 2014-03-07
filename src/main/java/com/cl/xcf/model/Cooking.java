package com.cl.xcf.model;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

/**
 * 烹饪对象
 * 用来存储烹饪名称、描述、成分、步骤等
 * CREATE BY INTELLIJ IDEA
 * user: chl
 * Date: 14-2-13 上午11:29
 */
@Entity("cooking")
public class Cooking {

    //com.cl.xcf.model.Cooking id

    @Id
    private String id ;

    //烹饪名称
    @Property("name")
    private String name;

    //烹饪简介
    @Property("description")
    private String description;

    //第一图片地址
    @Property("img_url")
    private String imgUrl;

    @Property("author")
    private String author;

    @Property("author_url")
    private String authorUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthorUrl() {
        return authorUrl;
    }

    public void setAuthorUrl(String authorUrl) {
        this.authorUrl = authorUrl;
    }
}
