package com.dyb.demo.system.mapper;

import com.dyb.demo.common.config.MyMapper;
import com.dyb.demo.system.entity.User;
import com.dyb.demo.system.entity.UserWithRole;

import java.util.List;

/**
 * @author dyb
 * @date 2019-11-27
 */

public interface UserMapper extends MyMapper<User> {

    List<User> queryList(User user);

    List<UserWithRole> findById(Long id);
}
