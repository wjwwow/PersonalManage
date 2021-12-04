package com.davis.controller.imp;

import com.davis.DTO.ResultDTO;
import com.davis.bean.Blog;
import com.davis.controller.BlogController;
import com.davis.service.BlogService;
import com.davis.service.imp.BlogServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Davis
 * @date 2021-11-29 - 10:55
 * @description
 */
@RestController
@CrossOrigin
public class BlogControllerImpl implements BlogController {
    @Autowired
    BlogServiceImpl blogService;
    @Override
    @PostMapping("/article/create")
    public String addBlog(@RequestBody Blog blog) {
        Integer add = blogService.add(blog);
        if (add ==1){
            return "success";
        }else {
            return "error";
        }
    }

    @Override
    @GetMapping("/article/list/{username}")
    public HashMap<String,Object> listBlog(@PathVariable("username") String username) {
        List<Blog> blogs = blogService.queryList(username);
        Long count = blogService.count(username);
        HashMap<String,Object> map = new HashMap<>();
        map.put("items", blogs);
        map.put("total", count);
        return map;
    }

    @Override
    @GetMapping("/article/detail")
    public Blog queryBlog(@RequestParam Integer id) {
        return blogService.queryById(id);
    }

    @Override
    @PostMapping("/article/update")
    public String updateBlog(@RequestBody Blog blog) {
        Integer update = blogService.update(blog);
        if (update==1){
            return "success";
        }else {
            return "error";
        }
    }

    @Override
    @GetMapping("/article/delete/{id}")
    public String deleteBlog(@PathVariable("id") Integer id) {
        Integer delete = blogService.delete(id);
        if (delete==1){
            return "success";
        }else {
            return "error";
        }
    }

    @Override
    @GetMapping("/article/count/{username}")
    public Long countBlog(@PathVariable("username") String username) {
        return blogService.count(username);
    }
}
