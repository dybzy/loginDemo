package com.dyb.demo.system.mapper;

import com.dyb.demo.common.config.MyMapper;
import com.dyb.demo.system.entity.Menu;

import java.util.List;

/**
 * @author dyb
 * @date 2019-11-27
 */

public interface MenuMapper extends MyMapper<Menu> {

    List<Menu> findUserMenus(String username);

    List<Menu> findUserPermissions(String username);

    void changeTopNode(List<Long> ids);
}
