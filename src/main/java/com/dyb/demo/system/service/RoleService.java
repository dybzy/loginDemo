package com.dyb.demo.system.service;


import com.dyb.demo.common.service.BaseService;
import com.dyb.demo.system.entity.Role;
import com.dyb.demo.system.entity.RoleWithMenu;

import java.util.List;

/**
 * @author dyb
 * @date 2019-11-27
 */
public interface RoleService extends BaseService<Role> {

    List<Role> findUserRole(String username);

    List<Role> findAllRole(Role role);

    List<Role> queryList(Role role);

    RoleWithMenu findById(Long id);

    void add(RoleWithMenu role);

    boolean checkName(String name, String id);

    void update(RoleWithMenu role);

    void delete(List<Long> keys);
}
