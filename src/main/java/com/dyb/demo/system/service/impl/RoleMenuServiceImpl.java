package com.dyb.demo.system.service.impl;

import com.dyb.demo.common.service.impl.BaseServiceImpl;
import com.dyb.demo.system.entity.RoleMenu;
import com.dyb.demo.system.service.RoleMenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author dyb
 * @date 2019-11-27
 */
@Service
public class RoleMenuServiceImpl extends BaseServiceImpl<RoleMenu> implements RoleMenuService {

    @Override
    @Transactional
    public void deleteRoleMenusByRoleId(List<Long> keys) {
        batchDelete(keys, "roleId", RoleMenu.class);
    }

    @Override
    public void deleteRoleMenusByMenuId(List<Long> ids) {
        this.batchDelete(ids, "menuId", RoleMenu.class);
    }
}
