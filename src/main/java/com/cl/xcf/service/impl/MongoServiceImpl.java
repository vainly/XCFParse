package com.cl.xcf.service.impl;

import com.cl.xcf.service.MongoService;
import com.mongodb.*;

import java.net.UnknownHostException;

/**
 * CREATE BY INTELLIJ IDEA
 * user: chl
 * Date: 14-2-17 上午10:06
 */
public class MongoServiceImpl implements MongoService {

    private DB db;
    private String tableName;

    public MongoServiceImpl(String dbName, String tableName) {
        this.tableName = tableName;
        Mongo mongo;
        try {
            /* 已被标记为“@Deprecated"
            mongo = new Mongo("localhost");
            this.db = mongo.getDB(dbName);
            */
            //最新用法
            MongoClient mc = new MongoClient("localhost", 27017);
            this.db = mc.getDB(dbName);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    /**
     * 插入对象
     *
     * @param idName   该对象的id名称
     * @param dbObject 该对象
     * @return
     */
    public DBObject insert(String idName, DBObject dbObject) {
        Integer id = getAutoIncID(idName);
        dbObject.put(idName, id);
        getCollection().insert(dbObject);
        return dbObject;
    }

    /**
     * 查询对象信息
     *
     * @param dbObject
     * @return
     */
    public DBObject getByObj(DBObject dbObject) {
        return getCollection().findOne(dbObject);
    }

    /**
     * 删除指定对象
     * @param dbObject
     */
    public void remove(DBObject dbObject) {
        WriteResult wr = getCollection().remove(dbObject);
    }

    /**
     * 自增涨id
     *
     * @param idName
     * @return
     */
    public Integer getAutoIncID(String idName) {
        BasicDBObject query = new BasicDBObject();
        query.put("name", idName);

        BasicDBObject update = new BasicDBObject();
        update.put("$inc", new BasicDBObject("id", 1));

        DBObject dbObject = getCollection("inc_ids").findAndModify(query, null, null, false, update, true, true);

        Integer id = (Integer) dbObject.get("id");
        return id;
    }

    /**
     * 获取默认(tableName)的数据链接
     *
     * @return 、
     */
    public DBCollection getCollection() {
        return db.getCollection(tableName);
    }

    /**
     * 获取指定tableName 的数据链接
     *
     * @param tableName
     * @return
     */
    public DBCollection getCollection(String tableName) {
        return this.db.getCollection(tableName);
    }
}
