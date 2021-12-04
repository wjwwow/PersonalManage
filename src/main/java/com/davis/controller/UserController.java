package com.davis.controller;

import com.davis.DTO.R;
import com.davis.DTO.ResultDTO;
import com.davis.bean.User;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author Davis
 * @date 2021-11-09 - 11:43
 * @description
 */
public interface UserController {
    public R login(String username, String password);

    public String queryUser(String username);
    public String updateUser(User user);
}
