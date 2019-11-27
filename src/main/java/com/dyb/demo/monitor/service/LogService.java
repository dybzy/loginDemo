package com.dyb.demo.monitor.service;

import com.dyb.demo.common.service.BaseService;
import com.dyb.demo.monitor.entity.SysLog;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.scheduling.annotation.Async;

import java.util.List;

/**
 * @author dyb
 * @date 2019-11-27
 */
public interface LogService extends BaseService<SysLog> {

    List<SysLog> findByPage(SysLog log);

    void deleteLogs(List<Long> ids);

    @Async
    void saveLog(ProceedingJoinPoint proceedingJoinPoint, SysLog log) throws JsonProcessingException;
}
