package com.dyb.demo.system.service;


import com.dyb.demo.common.dto.Tree;
import com.dyb.demo.common.service.BaseService;
import com.dyb.demo.system.entity.Menu;

import java.util.List;

/**
 * @author dyb
 * @date 2019-11-27
 */
public interface MenuService extends BaseService<Menu> {

    List<Menu> findUserPerms(String username);

    List<Menu> findUserPermissions(String username);

    List<Menu> findUserResources(String username);

    List<Menu> findAllResources(Menu menu);

    List<Menu> queryList(Menu menu);

    List<Tree<Menu>> getMenuButtonTree();

    List<Tree<Menu>> getMenuTree();

    Menu findById(Long id);

    void add(Menu menu);

    boolean checkName(String name, String id);

    void update(Menu menu);

    void delete(List<Long> ids);
}
