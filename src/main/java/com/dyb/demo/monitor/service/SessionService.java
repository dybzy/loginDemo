package com.dyb.demo.monitor.service;

import com.dyb.demo.monitor.entity.OnlineUser;

import java.util.List;

/**
 * @author dyb
 * @date 2019-11-27
 */
public interface SessionService {

    List<OnlineUser> list();

    void forceLogout(String id);
}
