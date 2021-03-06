package com.davis.DAO;

import com.davis.bean.Plan;
import com.davis.bean.PlanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PlanMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_plan
     *
     * @mbg.generated Fri Nov 26 09:49:12 CST 2021
     */
    long countByExample(PlanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_plan
     *
     * @mbg.generated Fri Nov 26 09:49:12 CST 2021
     */
    int deleteByExample(PlanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_plan
     *
     * @mbg.generated Fri Nov 26 09:49:12 CST 2021
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_plan
     *
     * @mbg.generated Fri Nov 26 09:49:12 CST 2021
     */
    int insert(Plan record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_plan
     *
     * @mbg.generated Fri Nov 26 09:49:12 CST 2021
     */
    int insertSelective(Plan record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_plan
     *
     * @mbg.generated Fri Nov 26 09:49:12 CST 2021
     */
    List<Plan> selectByExample(PlanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_plan
     *
     * @mbg.generated Fri Nov 26 09:49:12 CST 2021
     */
    Plan selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_plan
     *
     * @mbg.generated Fri Nov 26 09:49:12 CST 2021
     */
    int updateByExampleSelective(@Param("record") Plan record, @Param("example") PlanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_plan
     *
     * @mbg.generated Fri Nov 26 09:49:12 CST 2021
     */
    int updateByExample(@Param("record") Plan record, @Param("example") PlanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_plan
     *
     * @mbg.generated Fri Nov 26 09:49:12 CST 2021
     */
    int updateByPrimaryKeySelective(Plan record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_plan
     *
     * @mbg.generated Fri Nov 26 09:49:12 CST 2021
     */
    int updateByPrimaryKey(Plan record);
}