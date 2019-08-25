/**
 * Copyright (C), 2015-2019, 南京工程学院
 * FileName: OprLogController
 * Author:   Administrator
 * Date:     2019/5/12 11:28
 */
package cn.njit.info.sports.eslogs.controller;

import cn.njit.info.sports.eslogs.pojo.OprLog;
import cn.njit.info.sports.eslogs.pojo.RestResult;
import cn.njit.info.sports.eslogs.service.OprLogService;
import cn.njit.info.sports.eslogs.utils.RestResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 操作日志查询
 *
 * @author Liuzw
 * @since 2019/5/12
 */
@RestController
@RequestMapping("sports/opr")
public class OprLogController {
  private final OprLogService meService;

  @Autowired
  public OprLogController(OprLogService meService) {
    this.meService = meService;
  }

  @PostMapping("")
  public RestResult create(@RequestParam("params") String params) {
    OprLog save = meService.save(params);
    if (null == save)
      return RestResultUtils.returnError("创建失败");
    return RestResultUtils.returnMessage("创建成功");
  }

  @GetMapping("/{id}")
  public RestResult details(@PathVariable("id") Integer id) {
    OprLog oprLog = meService.details(id);
    return RestResultUtils.returnSuccess(oprLog);
  }

  @GetMapping("/userId/{userId}")
  public RestResult findAllByUserId(@PathVariable("userId") Integer userId) {
    List<OprLog> all = meService.findAllByUserId(userId);
    return RestResultUtils.returnSuccess(all);
  }

  @GetMapping("/page")
  public RestResult page(@RequestParam(value = "params",required = false) String params) {
    List<OprLog> page = meService.page(params);
    return RestResultUtils.returnSuccess(page);
  }

  @GetMapping("/search")
  public RestResult search(@RequestParam("str") String str) {
    List<OprLog> oprLogs = meService.globalSearch(str);
    return RestResultUtils.returnSuccess(oprLogs);
  }

  @DeleteMapping("/{id}")
  public RestResult delete(@PathVariable("id") Integer id) {
    meService.delete(id);
    return RestResultUtils.returnSuccess();
  }
}