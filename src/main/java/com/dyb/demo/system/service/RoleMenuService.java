package com.dyb.demo.system.service;


import com.dyb.demo.common.service.BaseService;
import com.dyb.demo.system.entity.RoleMenu;

import java.util.List;

/**
 * @author dyb
 * @date 2019-11-27
 */
public interface RoleMenuService extends BaseService<RoleMenu> {

    void deleteRoleMenusByRoleId(List<Long> keys);

    void deleteRoleMenusByMenuId(List<Long> ids);
}
