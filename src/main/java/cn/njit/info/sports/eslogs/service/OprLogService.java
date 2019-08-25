/**
 * Copyright (C), 2015-2019, 南京工程学院
 * FileName: OprLogService
 * Author:   Administrator
 * Date:     2019/5/12 11:24
 */
package cn.njit.info.sports.eslogs.service;

import cn.njit.info.sports.eslogs.dao.OprLogRepo;
import cn.njit.info.sports.eslogs.pojo.Module;
import cn.njit.info.sports.eslogs.pojo.OprLog;
import cn.njit.info.sports.eslogs.utils.ArrayListUtils;
import cn.njit.info.sports.eslogs.utils.QueryBuilderUtils;
import org.elasticsearch.index.query.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * 操作日志服务
 *
 * @author Liuzw
 * @since 2019/5/12
 */
@Service
public class OprLogService {
  private final OprLogRepo meRepo;

  @Autowired
  public OprLogService(OprLogRepo meRepo) {
    this.meRepo = meRepo;
  }

  /**
   * 保存单条数据
   *
   * @param params 参数
   * @return 实例
   */
  public OprLog save(String params) {
    OprLog oprLog = OprLog.read(params);
    return meRepo.save(oprLog);
  }

  /**
   * 根据Id查询单条数据
   *
   * @param id id
   * @return 实例
   */
  public OprLog details(Integer id) {
    Optional<OprLog> optionalOprLog = meRepo.findById(id);
    return optionalOprLog.get();
  }

  /**
   * 全局搜索
   *
   * @param str 搜索参数
   * @return 返回结果
   */
  public List<OprLog> globalSearch(String str) {
    QueryStringQueryBuilder builder = new QueryStringQueryBuilder(str);
    Iterable<OprLog> search = meRepo.search(builder);
    Iterator<OprLog> iterator = search.iterator();
    List<OprLog> resultList = new ArrayList<>();
    while (iterator.hasNext()) {
      resultList.add(iterator.next());
    }
    return resultList;
  }

  /**
   * 批量保存数据
   *
   * @param oprLogs
   * @return
   */
  public int save(List<OprLog> oprLogs) {
    Iterable<OprLog> logs = meRepo.saveAll(oprLogs);
    Iterator<OprLog> iterator = logs.iterator();
    int index = 0;
    while (iterator.hasNext()) {
      index++;
    }
    return index;
  }

  /**
   * 通过UserId查询列表
   *
   * @param userId 用户Id
   * @return 操作日志列表
   */
  public List<OprLog> findAllByUserId(Integer userId) {
    return meRepo.findAllByUserIdOrderByCreateDate(userId);
  }

  /**
   * 分页查询
   *
   * @param params 参数
   * @return 列表
   */
  public List<OprLog> page(String params) {
    OprLog oprLog;
    if (null == params) {
      oprLog = new OprLog();
    } else {
      oprLog = OprLog.read(params);
    }
    //查询器
    BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();

    //模块
    MatchQueryBuilder oprModule = null;
    if (null != oprLog.getOprModule()) {
      String code = Module.codeFromValue(oprLog.getOprModule());
      if (null != code)
        oprModule = QueryBuilders.matchQuery("oprModule", code);
    }
    QueryBuilderUtils.builder(boolQueryBuilder, oprModule);

    //方法
    MatchQueryBuilder method = null;
    if (null != oprLog.getMethod()) {
      method = QueryBuilders.matchQuery("method", oprLog.getMethod());
    }
    QueryBuilderUtils.builder(boolQueryBuilder, method);

    //操作人名字
    MatchQueryBuilder username = null;
    if (null != oprLog.getUsername()) {
      username = QueryBuilders.matchQuery("username", oprLog.getUsername());
    }
    QueryBuilderUtils.builder(boolQueryBuilder, username);

    //时间
    WildcardQueryBuilder createDate = null;
    if (null != oprLog.getCreateDate()) {
      createDate = QueryBuilders.wildcardQuery("createDate", "*" + oprLog.getCreateDate() + "*");
    }
    QueryBuilderUtils.builder(boolQueryBuilder, createDate);

    Iterable<OprLog> search = meRepo.search(boolQueryBuilder);
    Iterator<OprLog> iterator = search.iterator();
    List<OprLog> list = new ArrayList<>();
    while (iterator.hasNext()) {
      list.add(iterator.next());
    }
    return list;
  }

  public List<OprLog> page(OprLog oprLog) {
    //查询器
    BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();

    //模块
    MatchQueryBuilder oprModule = null;
    if (null != oprLog.getOprModule()) {
      String code = Module.codeFromValue(oprLog.getOprModule());
      if (null != code)
        oprModule = QueryBuilders.matchQuery("oprModule", code);
    }
    QueryBuilderUtils.builder(boolQueryBuilder, oprModule);

    //方法
    MatchQueryBuilder method = null;
    if (null != oprLog.getMethod()) {
      method = QueryBuilders.matchQuery("method", oprLog.getMethod());
    }
    QueryBuilderUtils.builder(boolQueryBuilder, method);

    //操作人名字
    MatchQueryBuilder username = null;
    if (null != oprLog.getUsername()) {
      username = QueryBuilders.matchQuery("username", oprLog.getUsername());
    }
    QueryBuilderUtils.builder(boolQueryBuilder, username);

    //时间
    WildcardQueryBuilder createDate = null;
    if (null != oprLog.getCreateDate()) {
      createDate = QueryBuilders.wildcardQuery("createDate", "*" + oprLog.getCreateDate() + "*");
    }
    QueryBuilderUtils.builder(boolQueryBuilder, createDate);

    Iterable<OprLog> search = meRepo.search(boolQueryBuilder);
    Iterator<OprLog> iterator = search.iterator();
    List<OprLog> list = new ArrayList<>();
    while (iterator.hasNext()) {
      list.add(iterator.next());
    }
    return list;
  }

  public void delete(Integer id) {
    meRepo.deleteById(id);
  }
}