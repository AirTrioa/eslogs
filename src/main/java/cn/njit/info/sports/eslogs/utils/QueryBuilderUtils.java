/**
 * Copyright (C), 2015-2019, 南京工程学院
 * FileName: QueryBuilderUtils
 * Author:   Administrator
 * Date:     2019/5/12 22:53
 */
package cn.njit.info.sports.eslogs.utils;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;

/**
 * Es查询器构建工具类
 *
 * @author Liuzw
 * @since 2019/5/12
 */
public class QueryBuilderUtils {
  private QueryBuilderUtils() {
  }

  /**
   * 空判断构建器
   *
   * @param boolQueryBuilder ES查询构建器
   * @param builder          匹配构建器
   */
  public static void builder(BoolQueryBuilder boolQueryBuilder, QueryBuilder builder) {
    if (null != builder) {
      boolQueryBuilder.must(builder);
    }
  }
}