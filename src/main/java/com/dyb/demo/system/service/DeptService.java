package com.dyb.demo.system.service;


import com.dyb.demo.common.dto.Tree;
import com.dyb.demo.common.service.BaseService;
import com.dyb.demo.system.entity.Dept;

import java.util.List;

/**
 * @author dyb
 * @date 2019-11-27
 */
public interface DeptService extends BaseService<Dept> {

    List<Tree<Dept>> tree();

    List<Dept> queryList(Dept dept);

    Dept findById(Long id);

    void add(Dept dept);

    boolean checkName(String name, String id);

    void update(Dept dept);

    void delete(List<Long> ids);
}
