package com.jin.demo.dao;

import com.jin.demo.dao.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoDao extends JpaRepository<UserInfo, Long> {

    public UserInfo findByDesc(String desc);
}
