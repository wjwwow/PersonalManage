package com.davis.controller;

import com.davis.bean.Plan;

import java.util.List;

/**
 * @author Davis
 * @date 2021-11-16 - 10:53
 * @description
 */
public interface PlanController {
    List<Plan> showAllPlans(String username);
    String updatePlan(Plan plan);
    String createPlan(Plan plan);
    String deletePlan(Integer id);
    long count(String username);
}
