package com.dyb.demo.system.controller;

import com.dyb.demo.common.annotation.Log;
import com.dyb.demo.common.controller.BaseController;
import com.dyb.demo.common.dto.QueryPage;
import com.dyb.demo.common.dto.ResponseCode;
import com.dyb.demo.common.enums.StatusEnums;
import com.dyb.demo.common.exception.GlobalException;
import com.dyb.demo.system.entity.Role;
import com.dyb.demo.system.entity.RoleWithMenu;
import com.dyb.demo.system.service.RoleService;
import io.swagger.annotations.Api;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 角色管理
 * @author dyb
 * @date 2019-11-27
 */
@RestController
@RequestMapping("/system/role")
@Api(value = "RoleController", tags = {"角色管理模块接口"})
public class RoleController extends BaseController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/list")
    public ResponseCode queryList(QueryPage queryPage, Role role) {
        return ResponseCode.success(super.selectByPageNumSize(queryPage, () -> roleService.queryList(role)));
    }

    @GetMapping("/findById")
    public ResponseCode findById(Long id) {
        return ResponseCode.success(roleService.findById(id));
    }

    @Log("添加角色")
    @PostMapping("/add")
    @RequiresPermissions("role:add")
    public ResponseCode add(@RequestBody RoleWithMenu role) {
        try {
            roleService.add(role);
            return ResponseCode.success();
        } catch (Exception e) {
            e.printStackTrace();
            throw new GlobalException(e.getMessage());
        }
    }

    @GetMapping("/checkName")
    public ResponseCode checkName(String name, String id) {
        if (name.isEmpty()) {
            return new ResponseCode(StatusEnums.PARAM_ERROR);
        }
        if (!roleService.checkName(name, id)) {
            return new ResponseCode(StatusEnums.PARAM_REPEAT);
        }
        return ResponseCode.success();
    }

    @Log("更新角色")
    @PostMapping("update")
    @RequiresPermissions("role:update")
    public ResponseCode update(@RequestBody RoleWithMenu role) {
        try {
            roleService.update(role);
            return ResponseCode.success();
        } catch (Exception e) {
            e.printStackTrace();
            throw new GlobalException(e.getMessage());
        }
    }

    @Log("删除角色")
    @PostMapping("/delete")
    @RequiresPermissions("role:delete")
    public ResponseCode delete(@RequestBody List<Long> ids) {
        try {
            roleService.delete(ids);
            return ResponseCode.success();
        } catch (Exception e) {
            e.printStackTrace();
            throw new GlobalException(e.getMessage());
        }
    }
}
