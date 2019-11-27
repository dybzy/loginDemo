package com.dyb.demo.system.mapper;

import com.dyb.demo.common.config.MyMapper;
import com.dyb.demo.system.entity.Role;
import com.dyb.demo.system.entity.RoleWithMenu;

import java.util.List;

/**
 * @author dyb
 * @date 2019-11-27
 */

public interface RoleMapper extends MyMapper<Role> {

    List<Role> findUserRole(String username);

    List<RoleWithMenu> findById(Long id);
}
