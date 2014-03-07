package com.cl.xcf.dao.impl;

import com.cl.xcf.dao.MorphiaCollection;
import com.cl.xcf.dao.StepDao;
import com.cl.xcf.model.Step;
import org.mongodb.morphia.Datastore;

/**
 * CREATE BY INTELLIJ IDEA
 * user: chl
 * Date: 14-2-17 下午5:27
 */
public class StepDaoImpl extends MorphiaCollection implements StepDao {

    /**
     * 新增step数据
     * @param step
     */
    public void save(Step step){
        Datastore ds = this.getDatastore();
        ds.save(step);
    }
}
