package com.dyb.demo.monitor.service.impl;

import com.dyb.demo.common.service.impl.BaseServiceImpl;
import com.dyb.demo.monitor.entity.LoginLog;
import com.dyb.demo.monitor.service.LoginLogService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dyb
 * @date 2019-11-27
 */
@Service
public class LoginLogServiceImpl extends BaseServiceImpl<LoginLog> implements LoginLogService {

    @Override
    public List<LoginLog> findByPage(LoginLog log) {
        try {
            Example example = new Example(LoginLog.class);
            Criteria criteria = example.createCriteria();
            if (StringUtils.isNotBlank(log.getLocation())) {
                criteria.andCondition("location=", log.getLocation());
            }
            if (StringUtils.isNotBlank(log.getFiledTime())) {
                String[] split = log.getFiledTime().split(",");
                criteria.andCondition("data_format(CREATE_TIME, '%Y-%m-%d') >=", split[0]);
                criteria.andCondition("data_format(CREATE_TIME, '%Y-%m-%d') <=", split[1]);
            }
            example.setOrderByClause("create_time desc");
            return this.selectByExample(example);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    @Transactional
    public void delete(@RequestBody List<Long> ids) {
        try {
            super.batchDelete(ids, "id", LoginLog.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    @Transactional
    public void saveLog(LoginLog log) {
        try {
            super.save(log);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
