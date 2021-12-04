package com.davis.service;


import com.davis.bean.Plan;

import java.util.List;

/**
 * @author Davis
 * @date 2021-11-16 - 10:39
 * @description
 */
public interface PlanService {
    List<Plan> findAllPlan(String username);
    Integer update(Plan plan);
    Integer addPlan(Plan plan);
    Integer deletePlan(Integer id);
    long countPlan(String username);
}
