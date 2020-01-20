package com.dyb.demo.common.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 分页
 * @author dyb
 * @date 2019-11-27
 */
@Data
@ToString
public class QueryPage implements Serializable {

    private int pageCode; //当前页
    private int pageSize; //每页显示的记录数
}
