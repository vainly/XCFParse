package com.cl.xcf.service;

import com.mongodb.DBObject;

/**
 * CREATE BY INTELLIJ IDEA
 * user: chl
 * Date: 14-2-17 上午10:02
 */
public interface MongoService {
    /**
     * 插入DBObject对象
     * @param idName  该对象的id名称
     * @param dbObject 该对象
     * @return
     */
    public DBObject insert(String idName,DBObject dbObject);

    /**
     * 获取对象
     * @param dbObject
     * @return
     */
    public DBObject getByObj(DBObject dbObject);

    /**
     * 删除对象
     * @param dbObject
     */
    public void remove(DBObject dbObject);
}
