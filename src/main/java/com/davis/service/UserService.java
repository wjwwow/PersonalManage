package com.davis.service;

import com.davis.DTO.ResultDTO;
import com.davis.bean.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Davis
 * @date 2021-11-09 - 11:19
 * @description
 */

public interface UserService {
    List<User> queryUser(String username, String password);
    Integer addUser(User user) ;
    List<User> queryUserByUserName(String username);
    Integer update(User user);
    List<User> findUserByEmail(String email);
}
