package com.davis.bean;

import java.util.Date;

public class Plan {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_plan.id
     *
     * @mbg.generated Fri Nov 26 09:49:12 CST 2021
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_plan.content
     *
     * @mbg.generated Fri Nov 26 09:49:12 CST 2021
     */
    private String content;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_plan.end_time
     *
     * @mbg.generated Fri Nov 26 09:49:12 CST 2021
     */
    private Date endTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_plan.username
     *
     * @mbg.generated Fri Nov 26 09:49:12 CST 2021
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_plan.imp
     *
     * @mbg.generated Fri Nov 26 09:49:12 CST 2021
     */
    private Integer imp;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_plan.id
     *
     * @return the value of t_plan.id
     *
     * @mbg.generated Fri Nov 26 09:49:12 CST 2021
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_plan.id
     *
     * @param id the value for t_plan.id
     *
     * @mbg.generated Fri Nov 26 09:49:12 CST 2021
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_plan.content
     *
     * @return the value of t_plan.content
     *
     * @mbg.generated Fri Nov 26 09:49:12 CST 2021
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_plan.content
     *
     * @param content the value for t_plan.content
     *
     * @mbg.generated Fri Nov 26 09:49:12 CST 2021
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_plan.end_time
     *
     * @return the value of t_plan.end_time
     *
     * @mbg.generated Fri Nov 26 09:49:12 CST 2021
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_plan.end_time
     *
     * @param endTime the value for t_plan.end_time
     *
     * @mbg.generated Fri Nov 26 09:49:12 CST 2021
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_plan.username
     *
     * @return the value of t_plan.username
     *
     * @mbg.generated Fri Nov 26 09:49:12 CST 2021
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_plan.username
     *
     * @param username the value for t_plan.username
     *
     * @mbg.generated Fri Nov 26 09:49:12 CST 2021
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_plan.imp
     *
     * @return the value of t_plan.imp
     *
     * @mbg.generated Fri Nov 26 09:49:12 CST 2021
     */
    public Integer getImp() {
        return imp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_plan.imp
     *
     * @param imp the value for t_plan.imp
     *
     * @mbg.generated Fri Nov 26 09:49:12 CST 2021
     */
    public void setImp(Integer imp) {
        this.imp = imp;
    }
}