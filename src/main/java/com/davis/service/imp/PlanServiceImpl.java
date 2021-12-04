package com.davis.service.imp;

import com.davis.DAO.PlanMapper;
import com.davis.bean.Plan;
import com.davis.bean.PlanExample;
import com.davis.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Davis
 * @date 2021-11-16 - 10:42
 * @description
 */
@Service
public class PlanServiceImpl implements PlanService {
    @Autowired
    PlanMapper planMapper;
    @Override
    public List<Plan> findAllPlan(String username) {
        PlanExample planExample = new PlanExample();
        planExample.createCriteria().andUsernameEqualTo(username);
        return planMapper.selectByExample(planExample);
    }

    @Override
    public Integer update(Plan plan) {
        return planMapper.updateByPrimaryKeySelective(plan);
    }
    @Override
    public Integer addPlan(Plan plan) {
        return planMapper.insert(plan);
    }

    @Override
    public Integer deletePlan(Integer id) {
        return planMapper.deleteByPrimaryKey(id);
    }

    @Override
    public long countPlan(String username) {
        PlanExample planExample = new PlanExample();
        planExample.createCriteria().andUsernameEqualTo(username);
        return planMapper.countByExample(planExample);
    }
}
