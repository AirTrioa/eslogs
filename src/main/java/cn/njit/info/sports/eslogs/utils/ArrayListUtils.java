/**
 * Copyright (C), 2015-2019, 南京工程学院
 * FileName: ArrayListUtils
 * Author:   Administrator
 * Date:     2019/5/12 22:59
 */
package cn.njit.info.sports.eslogs.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 获取列表的Utils
 *
 * @author Liuzw
 * @since 2019/5/12
 */
public class ArrayListUtils {
  private ArrayListUtils() {
  }

  /**
   * 获取list
   *
   * @param iterable 迭代器
   * @param <T>      T
   * @return TList
   */
  public static <T> List<T> it(Iterable<T> iterable) {
    List<T> list = new ArrayList<>();
    while (iterable.iterator().hasNext()) {
      list.add(iterable.iterator().next());
    }
    return list;
  }
}