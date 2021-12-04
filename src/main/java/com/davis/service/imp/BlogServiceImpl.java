package com.davis.service.imp;

import com.davis.DAO.BlogMapper;
import com.davis.bean.Blog;
import com.davis.bean.BlogExample;
import com.davis.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Davis
 * @date 2021-11-29 - 10:51
 * @description
 */
@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogMapper blogMapper;

    @Override
    public List<Blog> queryList(String username) {
        BlogExample blogExample = new BlogExample();
        blogExample.createCriteria().andUsernameEqualTo(username);
        return blogMapper.selectByExample(blogExample);
    }

    @Override
    public Blog queryById(Integer id) {
        return blogMapper.selectByPrimaryKey(id);
    }

    @Override
    public Long count(String username) {
        BlogExample blogExample = new BlogExample();
        blogExample.createCriteria().andUsernameEqualTo(username);
        return blogMapper.countByExample(blogExample);
    }

    @Override
    public Integer add(Blog blog) {
        return blogMapper.insert(blog);
    }

    @Override
    public Integer update(Blog blog) {
        return blogMapper.updateByPrimaryKeySelective(blog);
    }

    @Override
    public Integer delete(Integer id) {
        return blogMapper.deleteByPrimaryKey(id);
    }
}
