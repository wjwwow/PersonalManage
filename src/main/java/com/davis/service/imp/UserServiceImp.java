package com.davis.service.imp;

import com.davis.DAO.UserMapper;
import com.davis.bean.User;
import com.davis.bean.UserExample;
import com.davis.service.UserService;
import com.davis.util.KaisaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Davis
 * @date 2021-11-09 - 11:24
 * @description
 */
@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> queryUser(String username, String password) {
        String s = KaisaUtil.encryptKaisa(password,3);
        System.out.println(s);
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(username).andPasswordEqualTo(s);
        return userMapper.selectByExample(userExample);

    }

    @Override
    public Integer addUser(User user) {
        String s = KaisaUtil.encryptKaisa(user.getPassword(),3);
        user.setPassword(s);
        user.setIntroduction("改用户还未填写简介...");
        user.setAvatar("http://46o2352s89.zicp.vip/vue-admin-template/static/upload/default.jpg");
        return userMapper.insert(user);
    }

    @Override
    public List<User> queryUserByUserName(String username) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        return userMapper.selectByExample(userExample);
    }

    @Override
    public Integer update(User user) {
        if (user.getPassword()!=null){
            String s = KaisaUtil.decryptKaiser(user.getPassword(), 3);
            user.setPassword(s);
        }
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(user.getUsername());
        return userMapper.updateByExampleSelective(user,userExample);
    }

    @Override
    public List<User> findUserByEmail(String email) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andEmailEqualTo(email);
        return userMapper.selectByExample(userExample);
    }
}
