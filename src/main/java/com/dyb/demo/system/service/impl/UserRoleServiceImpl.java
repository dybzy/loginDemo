package com.dyb.demo.system.service.impl;

import com.dyb.demo.common.service.impl.BaseServiceImpl;
import com.dyb.demo.system.entity.UserRole;
import com.dyb.demo.system.mapper.UserRoleMapper;
import com.dyb.demo.system.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author dyb
 * @date 2019-11-27
 */
@Service
public class UserRoleServiceImpl extends BaseServiceImpl<UserRole> implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    @Transactional
    public void deleteUserRolesByUserId(List<Long> keys) {
        this.batchDelete(keys, "userId", UserRole.class);
    }

    @Override
    @Transactional
    public void deleteUserRolesByRoleId(List<Long> keys) {
        this.batchDelete(keys, "roleId", UserRole.class);
    }
}
