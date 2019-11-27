package com.dyb.demo.system.mapper;

import com.dyb.demo.common.config.MyMapper;
import com.dyb.demo.system.entity.Dept;


import java.util.List;

/**
 * @author dyb
 * @date 2019-11-27
 */

public interface DeptMapper extends MyMapper<Dept> {

    void changeTopNode(List<Long> ids);
}
