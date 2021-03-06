package com.dyb.demo.common.dto;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * 树的节点
 * @author dyb
 * @date 2019-11-27
 */
@Data
@ToString
public class Tree<T> {

    private Long id; //节点ID

    private Long parentId; //父节点ID

    private Boolean hasChildren; //是否有子节点

    private Boolean hasParent; //是否有父节点

    private String name; //节点名称

    private String url; //节点URL

    private String icon; //图标

    private List<Tree<T>> children = new ArrayList<>(); //子节点信息

}
