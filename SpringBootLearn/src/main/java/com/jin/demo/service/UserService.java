package com.jin.demo.service;

import com.jin.demo.dao.UserInfoDao;
import com.jin.demo.dao.UserScoreDao;
import com.jin.demo.dao.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserInfoDao userInfoDao;

    @Autowired
    private UserScoreDao userScoreDao;

    @Cacheable(value = "user")
    public UserInfo getUserInfo(Long id) {
        System.out.println("==== service getUserInfo doing ! id = " + id);
        return userInfoDao.findById(id).get();
    }

    @Cacheable(value = "user")
    public UserInfo getUserInfoByDesc(String desc) {
        System.out.println("==== service getUserInfoByDesc doing ! desc = " + desc);
        return userInfoDao.findByDesc(desc);
    }

}
