package com.jin.demo.dao.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class UserScore {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private long userId;
  private String className;
  private long score;

}
