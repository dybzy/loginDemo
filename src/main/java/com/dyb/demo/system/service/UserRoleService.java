package com.dyb.demo.system.service;


import com.dyb.demo.common.service.BaseService;
import com.dyb.demo.system.entity.UserRole;

import java.util.List;

/**
 * @author dyb
 * @date 2019-11-27
 */
public interface UserRoleService extends BaseService<UserRole> {

    void deleteUserRolesByUserId(List<Long> keys);

    void deleteUserRolesByRoleId(List<Long> keys);
}
