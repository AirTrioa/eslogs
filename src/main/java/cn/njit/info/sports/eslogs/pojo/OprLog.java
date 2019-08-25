/**
 * Copyright (C), 2015-2019, 南京工程学院
 * FileName: OprLog
 * Author:   Administrator
 * Date:     2019/5/12 10:47
 */
package cn.njit.info.sports.eslogs.pojo;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * 操作日志
 *
 * @author Liuzw
 * @since 2019/5/12
 */
@Document(indexName = "sports", type = "OprLog")
public class OprLog {
  @Id
  private Integer id;
  @Field(type = FieldType.Integer)
  private Integer userId;
  /**
   * 操作人
   */
  @Field(type = FieldType.Text)
  private String username;
  /**
   * 操作
   */
  @Field(type = FieldType.Text)
  private String operation;
  /**
   * 方法名
   */
  @Field(type = FieldType.Text)
  private String method;
  /**
   * 参数
   */
  @Field(type = FieldType.Text)
  private String params;
  /**
   * 操作时间
   */
  @Field(type = FieldType.Text)
  private String createDate;
  /**
   * 操作模块
   */
  @Field(type = FieldType.Text)
  private String oprModule;

  public OprLog() {
  }

  public OprLog(Integer id, Integer userId, String username, String operation, String method, String params, String createDate, String oprModule) {
    this.id = id;
    this.userId = userId;
    this.username = username;
    this.operation = operation;
    this.method = method;
    this.params = params;
    this.createDate = createDate;
    this.oprModule = oprModule;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getOperation() {
    return operation;
  }

  public void setOperation(String operation) {
    this.operation = operation;
  }

  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }

  public String getParams() {
    return params;
  }

  public void setParams(String params) {
    this.params = params;
  }

  public String getCreateDate() {
    return createDate;
  }

  public void setCreateDate(String createDate) {
    this.createDate = createDate;
  }

  public String getOprModule() {
    return oprModule;
  }

  public void setOprModule(String oprModule) {
    this.oprModule = oprModule;
  }

  public static OprLog read(String params) {
    JSONObject jsonObject = JSONObject.parseObject(params);
    Integer id = jsonObject.getInteger("id");
    Integer userId = jsonObject.getInteger("userId");
    String username = jsonObject.getString("username");
    String operation = jsonObject.getString("operation");
    String method = jsonObject.getString("method");
    String params1 = jsonObject.getString("params");
    String createDate = jsonObject.getString("createDate");
    String oprModule = jsonObject.getString("oprModule");
    return new OprLog(id, userId, username, operation, method, params1, createDate, oprModule);
  }
}