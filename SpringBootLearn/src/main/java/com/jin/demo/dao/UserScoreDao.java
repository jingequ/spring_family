package com.jin.demo.dao;

import com.jin.demo.dao.model.UserScore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserScoreDao extends JpaRepository<UserScore, Long> {
}
