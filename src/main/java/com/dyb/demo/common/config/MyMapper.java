package com.dyb.demo.common.config;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 *  通用Mapper
 * @author dyb
 * @date 2019-11-27
 */
public interface  MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
