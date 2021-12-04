package com.davis.controller;

import com.davis.DTO.ResultDTO;
import com.davis.bean.Blog;

import java.util.Map;

/**
 * @author Davis
 * @date 2021-11-29 - 10:52
 * @description
 */
public interface BlogController {
    String addBlog(Blog blog);
    Map<String,Object> listBlog(String username);
    Blog queryBlog(Integer id);
    String updateBlog(Blog blog);
    String deleteBlog(Integer id);
    Long countBlog(String username);
}
