package com.cl.xcf.service.impl;

import com.cl.xcf.dao.StepDao;
import com.cl.xcf.dao.impl.StepDaoImpl;
import com.cl.xcf.model.Step;
import com.cl.xcf.service.StepService;

/**
 * CREATE BY INTELLIJ IDEA
 * user: chl
 * Date: 14-2-17 下午5:33
 */
public class StepServiceImpl implements StepService {

    private StepDao stepDao ;

    public StepServiceImpl(){
        stepDao = new StepDaoImpl();
    }

    /**
     * insert new data
     * @param step
     */
    public void save(Step step){
        stepDao.save(step);
    }
}
