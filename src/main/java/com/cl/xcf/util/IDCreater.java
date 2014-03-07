package com.cl.xcf.util;

import com.mongodb.*;

import java.net.UnknownHostException;

/**
 * CREATE BY INTELLIJ IDEA
 * user: chl
 * Date: 14-2-17 下午4:22
 */
public class IDCreater {

    private final String DEFAULT_DB_NAME = "test";
    private final String INC_IDS = "inc_ids";

    private DBCollection dbc;

    public IDCreater(){
        Mongo mongo = getMongo();
        //获取数据库
        this.dbc = mongo.getDB(DEFAULT_DB_NAME).getCollection(INC_IDS);
    }

    public IDCreater(String dbName){
        Mongo mongo = getMongo();
        this.dbc = mongo.getDB(dbName).getCollection(INC_IDS);
    }

    public Mongo getMongo(){
        Mongo mongo = null;
        try{
            mongo = new MongoClient();
        }catch (UnknownHostException e){
            e.printStackTrace();
        }catch (MongoException e){
            e.printStackTrace();
        }
        return mongo;
    }

    /**
     * 生成自增涨主键
     * @param idName
     * @return
     */
    public String getAutoIncID(String idName){
        BasicDBObject query = new BasicDBObject();
        query.put("name",idName);

        BasicDBObject update = new BasicDBObject();
        update.put("$inc",new BasicDBObject("id",1));
        DBObject id = dbc.findAndModify(query,null,null,false,update,true,true);
        return id.get("id").toString();
    }
}
