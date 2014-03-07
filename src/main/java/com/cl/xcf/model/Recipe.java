package com.cl.xcf.model;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

/**
 * CREATE BY INTELLIJ IDEA
 * user: chl
 * Date: 14-2-18 下午3:59
 */
@Entity("recipe")
public class Recipe {
    @Id
    private String id;

    //食谱地址
    @Property
    private String url;

    //食谱名称
    @Property
    private String name;

    //食谱得分
    @Property
    private double score;

    //作者
    @Property
    private String author;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
