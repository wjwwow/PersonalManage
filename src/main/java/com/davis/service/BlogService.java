package com.davis.service;

import com.davis.bean.Blog;

import java.util.List;

/**
 * @author Davis
 * @date 2021-11-29 - 10:50
 * @description
 */
public interface BlogService {
    List<Blog> queryList(String username);
    Blog queryById(Integer id);
    Long count(String username);
    Integer add(Blog blog);
    Integer update(Blog blog);
    Integer delete(Integer id);
}
