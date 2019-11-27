package com.dyb.demo.common.service;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dyb
 * @date 2019-11-27
 */
@Service
public interface BaseService<T> {

    List<T> selectAll();

    T selectByKey(Object key);

    void save(T entity);

    void delete(Object key);

    void batchDelete(List<Long> ids, String property, Class<T> clazz);

    void updateAll(T entity);

    void updateNotNull(T entity);

    List<T> selectByExample(Object example);
}
