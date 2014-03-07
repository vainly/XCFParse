package com.cl.xcf.dao;

import com.cl.xcf.model.Cooking;

/**
 * CREATE BY INTELLIJ IDEA
 * user: chl
 * Date: 14-2-17 下午5:01
 */
public interface CookingDao {
    /**
     * 新增 cooking对象
     * @param cooking
     */
    public void save(Cooking cooking);
}
