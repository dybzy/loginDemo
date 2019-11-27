package com.dyb.demo.system.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author dyb
 * @date 2019-11-27
 */
@Data
@ToString
@Table(name = "tb_role_menu")
public class RoleMenu implements Serializable {

    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "menu_id")
    private Long menuId;
}
