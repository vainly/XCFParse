package com.cl.xcf.model;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

/**
 * 烹饪所需要的各个调味及材料成分
 * CREATE BY INTELLIJ IDEA
 * user: chl
 * Date: 14-2-13 上午11:35
 */
@Entity("ingredient")
public class Ingredient {
    //com.cl.xcf.model.Cooking id
    @Property("cook_id")
    private String cookId;

    @Id
    private String id;

    //材料名称
    @Property("name")
    private String name;

    //材料用量
    @Property("unit")
    private String unit;

    //材料详情
    @Property("url")
    private String url;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
