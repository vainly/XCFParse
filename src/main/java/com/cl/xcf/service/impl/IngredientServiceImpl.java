package com.cl.xcf.service.impl;

import com.cl.xcf.dao.IngredientDao;
import com.cl.xcf.dao.impl.IngredientDaoImpl;
import com.cl.xcf.model.Ingredient;
import com.cl.xcf.service.IngredientService;

/**
 * CREATE BY INTELLIJ IDEA
 * user: chl
 * Date: 14-2-17 下午5:36
 */
public class IngredientServiceImpl implements IngredientService {

    private IngredientDao ingredientDao;

    public IngredientServiceImpl(){
        ingredientDao = new IngredientDaoImpl();
    }

    /**
     * insert new data
     * @param ingredient
     */
    public void save(Ingredient ingredient){
        ingredientDao.save(ingredient);
    }
}
