package com.davis.controller.imp;

import com.davis.bean.Plan;
import com.davis.controller.PlanController;
import com.davis.service.imp.PlanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * @author Davis
 * @date 2021-11-16 - 10:54
 * @description
 */
@RestController
@CrossOrigin
public class PlanControllerImpl implements PlanController {
    @Autowired
    PlanServiceImpl planService;
    @Override
    @GetMapping("/plan/{username}")
    public List<Plan> showAllPlans(@PathVariable("username") String username) {
        return planService.findAllPlan(username);
    }

    @Override
    @PostMapping("/updatePlan")
    @ResponseBody
    public String updatePlan(@RequestBody Plan plan){
        System.out.println("update");
        try {
            Integer i = planService.update(plan);
            if (i == 0){
                return "error";
            }
        }catch (Exception e){
            return "error";
        }
        return "success";
    }

    @Override
    @PostMapping("/createPlan")
    public String createPlan(@RequestBody Plan plan) {
        try {
            Integer integer = planService.addPlan(plan);
            if (integer==1){
                return "success";
            }else {
                return "error";
            }
        } catch (Exception e) {
            return "error";
        }
    }

    @Override
    @GetMapping("/delete/{id}")
    public String deletePlan(@PathVariable("id") Integer id) {
        try {
            Integer integer = planService.deletePlan(id);
            if (integer==1){
                return "success";
            }else {
                return "error";
            }
        } catch (Exception e) {
            return "error";
        }
    }

    @Override
    @GetMapping("/countPlan/{username}")
    public long count(@PathVariable("username") String username) {
        return planService.countPlan(username);
    }
}
