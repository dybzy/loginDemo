package com.dyb.demo.system.service.impl;

import com.dyb.demo.common.dto.Tree;
import com.dyb.demo.common.service.impl.BaseServiceImpl;
import com.dyb.demo.common.utils.TreeUtils;
import com.dyb.demo.system.entity.Dept;
import com.dyb.demo.system.entity.Menu;
import com.dyb.demo.system.mapper.DeptMapper;
import com.dyb.demo.system.service.DeptService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author dyb
 * @date 2019-11-27
 */
@Service
public class DeptServiceImpl extends BaseServiceImpl<Dept> implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Tree<Dept>> tree() {
        List<Dept> list = queryList(new Dept());
        List<Tree<Dept>> treeList = new ArrayList<>();
        list.forEach(dept -> {
            Tree<Dept> tree = new Tree<>();
            tree.setId(dept.getId());
            tree.setParentId(dept.getParentId());
            tree.setName(dept.getName());
            treeList.add(tree);
        });
        return TreeUtils.build(treeList);
    }

    @Override
    public List<Dept> queryList(Dept dept) {
        try {
            Example example = new Example(Dept.class);
            if (StringUtils.isNotBlank(dept.getName())) {
                example.createCriteria().andCondition("name", dept.getName());
            }
            example.setOrderByClause("create_time");
            return this.selectByExample(example);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public Dept findById(Long id) {
        Example example = new Example(Dept.class);
        example.createCriteria().andCondition("id=", id);
        List<Dept> list = this.selectByExample(example);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    @Transactional
    public void add(Dept dept) {
        Long pid = dept.getParentId();
        if (pid == null) {
            dept.setParentId(0L);
        }
        dept.setCreateTime(new Date());
        this.save(dept);
    }

    @Override
    public boolean checkName(String name, String id) {
        if (name.isEmpty()) {
            return false;
        }
        Example example = new Example(Menu.class);
        if (!id.isEmpty()) {
            example.createCriteria().andCondition("lower(name)=", name.toLowerCase()).andNotEqualTo("id", id);
        } else {
            example.createCriteria().andCondition("lower(name)=", name.toLowerCase());
        }
        List<Dept> depts = this.selectByExample(example);
        if (depts.size() > 0) {
            return false;
        }
        return true;
    }

    @Override
    @Transactional
    public void update(Dept dept) {
        this.updateNotNull(dept);
    }

    @Override
    @Transactional
    public void delete(List<Long> ids) {
        this.batchDelete(ids, "id", Dept.class);
        this.deptMapper.changeTopNode(ids);
    }


}
