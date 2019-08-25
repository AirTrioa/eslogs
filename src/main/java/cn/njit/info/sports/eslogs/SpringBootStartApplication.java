/**
 * Copyright (C), 2015-2019, 南京工程学院
 * FileName: SpringBootStartApplication
 * Author:   Administrator
 * Date:     2019/5/14 16:37
 */
package cn.njit.info.sports.eslogs;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 *
 * @author Liuzw
 * @since 2019/5/14
 */
public class SpringBootStartApplication extends SpringBootServletInitializer {
  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
    return builder.sources(EslogsApplication.class);
  }
}