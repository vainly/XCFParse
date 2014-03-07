package com.cl.xcf.dao.impl;

import com.cl.xcf.dao.IngredientDao;
import com.cl.xcf.dao.MorphiaCollection;
import com.cl.xcf.model.Ingredient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;

/**
 * CREATE BY INTELLIJ IDEA
 * user: chl
 * Date: 14-2-17 下午5:30
 */
public class IngredientDaoImpl extends MorphiaCollection implements IngredientDao {

    /**
     * 新增 ingredient 数据
     * @param ingredient
     */
    public void save(Ingredient ingredient){
        Datastore ds = this.getDatastore();
        ds.save(ingredient);
    }
}
