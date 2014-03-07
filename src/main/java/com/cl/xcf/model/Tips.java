package com.cl.xcf.model;

import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

/**
 * 小贴士对象
 * CREATE BY INTELLIJ IDEA
 * user: chl
 * Date: 14-2-13 下午1:08
 */
public class Tips {

    //com.cl.xcf.model.Cooking id
    @Property("cook_id")
    private String cookId;

    @Id
    private String id;

    //描述信息
    @Property("description")
    private String description;

    public String getCookId() {
        return cookId;
    }

    public void setCookId(String cookId) {
        this.cookId = cookId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
