package com.cl.xcf.service.impl;

import com.cl.xcf.dao.CookingDao;
import com.cl.xcf.dao.impl.CookingDaoImpl;
import com.cl.xcf.model.Cooking;
import com.cl.xcf.service.CookingService;

/**
 * CREATE BY INTELLIJ IDEA
 * user: chl
 * Date: 14-2-17 下午5:14
 */
public class CookingServiceImpl implements CookingService {
    private CookingDao cookingDao;

    public CookingServiceImpl(){
        this.cookingDao = new CookingDaoImpl();
    }

    /**
     * 新增cooking数据
     * @param cooking
     */
    public void save(Cooking cooking){
        cookingDao.save(cooking);
    }
}
