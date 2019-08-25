/**
 * Copyright (C), 2015-2019, 南京工程学院
 * FileName: OprLogRepo
 * Author:   Administrator
 * Date:     2019/5/12 10:53
 */
package cn.njit.info.sports.eslogs.dao;

import cn.njit.info.sports.eslogs.pojo.OprLog;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 操作日志Jpa
 * @author Liuzw
 * @since 2019/5/12
 */
@Repository
public interface OprLogRepo extends ElasticsearchRepository<OprLog,Integer> {

  List<OprLog> findAllByUserIdOrderByCreateDate(Integer userId);

}