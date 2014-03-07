package com.cl.xcf.dao.impl;

import com.cl.xcf.dao.CookingDao;
import com.cl.xcf.dao.MorphiaCollection;
import com.cl.xcf.model.Cooking;
import org.mongodb.morphia.Datastore;

/**
 * CREATE BY INTELLIJ IDEA
 * user: chl
 * Date: 14-2-17 下午5:01
 */
public class CookingDaoImpl extends MorphiaCollection implements CookingDao {

    /**
     * 新增 cooking对象
     * @param cooking
     */
    public void save(Cooking cooking){
        Datastore ds = this.getDatastore();
        ds.save(cooking);
    }
}
