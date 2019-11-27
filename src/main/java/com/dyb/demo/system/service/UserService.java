package com.dyb.demo.system.service;


import com.dyb.demo.common.dto.Tree;
import com.dyb.demo.common.service.BaseService;
import com.dyb.demo.system.entity.Menu;
import com.dyb.demo.system.entity.User;
import com.dyb.demo.system.entity.UserWithRole;

import java.util.List;

/**
 * @author dyb
 * @date 2019-11-27
 */
public interface UserService extends BaseService<User> {

    User findByName(String username);

    UserWithRole findById(Long id);

    List<Tree<Menu>> getMenus(String username);

    List<User> queryList(User user);

    void add(UserWithRole user);

    boolean checkName(String name, String id);

    void update(UserWithRole user);

    void delete(List<Long> keys);

    void updatePassword(String password);
}
