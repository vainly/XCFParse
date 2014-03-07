package com.cl.xcf.dao;

import com.cl.xcf.model.Ingredient;

/**
 * CREATE BY INTELLIJ IDEA
 * user: chl
 * Date: 14-2-17 下午5:24
 */
public interface IngredientDao {

    /**
     * 新增 ingredient 数据
     * @param ingredient
     */
    public void save(Ingredient ingredient);
}
