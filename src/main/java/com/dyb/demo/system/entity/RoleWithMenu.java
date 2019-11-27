package com.dyb.demo.system.entity;

import lombok.Data;

import java.util.List;

/**
 * 为什么创建这个类？
 * 请看 {@link com.dyb.demo.system.entity.UserWithRole} 中的解释
 *
 * @author dyb
 * @date 2019-11-27
 */
@Data
public class RoleWithMenu extends Role {

    private Long menuId;

    private List<Long> menuIds;
}
