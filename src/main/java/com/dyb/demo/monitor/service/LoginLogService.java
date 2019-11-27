package com.dyb.demo.monitor.service;

import com.dyb.demo.common.service.BaseService;
import com.dyb.demo.monitor.entity.LoginLog;

import java.util.List;

/**
 * @author dyb
 * @date 2019-11-27
 */
public interface LoginLogService extends BaseService<LoginLog> {

    List<LoginLog> findByPage(LoginLog log);

    void delete(List<Long> ids);

    void saveLog(LoginLog log);
}
