package com.dyb.demo.system.controller;

import com.dyb.demo.common.annotation.Log;
import com.dyb.demo.common.controller.BaseController;
import com.dyb.demo.common.dto.QueryPage;
import com.dyb.demo.common.dto.ResponseCode;
import com.dyb.demo.common.enums.StatusEnums;
import com.dyb.demo.common.exception.GlobalException;
import com.dyb.demo.system.entity.Menu;
import com.dyb.demo.system.service.MenuService;
import io.swagger.annotations.Api;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 菜单管理
 * @author dyb
 * @date 2019-11-27
 */
@RestController
@RequestMapping("/system/menu")
@Api(value = "MenuController", tags = {"菜单管理模块接口"})
public class MenuController extends BaseController {

    @Autowired
    private MenuService menuService;

    @PostMapping("/list")
    public ResponseCode queryList(QueryPage queryPage, Menu menu) {
        return ResponseCode.success(super.selectByPageNumSize(queryPage, () -> menuService.queryList(menu)));
    }

    @GetMapping("/urlList")
    public ResponseCode getAllUrl() {
        return ResponseCode.success(menuService.queryList(new Menu()));
    }

    @GetMapping("/menuButtonTree")
    public ResponseCode getMenuButtonTree() {
        try {
            return ResponseCode.success(menuService.getMenuButtonTree());
        } catch (Exception e) {
            e.printStackTrace();
            throw new GlobalException(e.getMessage());
        }
    }

    @GetMapping("/menuTree")
    public ResponseCode getMenuTree() {
        try {
            return ResponseCode.success(menuService.getMenuTree());
        } catch (Exception e) {
            e.printStackTrace();
            throw new GlobalException(e.getMessage());
        }
    }

    @GetMapping("/findById")
    public ResponseCode findById(Long id) {
        try {
            return ResponseCode.success(menuService.findById(id));
        } catch (Exception e) {
            e.printStackTrace();
            throw new GlobalException(e.getMessage());
        }
    }

    @Log("添加菜单")
    @PostMapping("/add")
    @RequiresPermissions("menu:add")
    public ResponseCode add(@RequestBody Menu menu) {
        try {
            menuService.add(menu);
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
        if (!menuService.checkName(name, id)) {
            return new ResponseCode(StatusEnums.PARAM_REPEAT);
        }
        return ResponseCode.success();
    }

    @Log("更新菜单")
    @PostMapping("/update")



    @RequiresPermissions("menu:update")
    public ResponseCode update(@RequestBody Menu menu) {
        try {
            menuService.update(menu);
            return ResponseCode.success();
        } catch (Exception e) {
            e.printStackTrace();
            throw new GlobalException(e.getMessage());
        }
    }

    @Log("删除菜单")
    @PostMapping("/delete")
    @RequiresPermissions("menu:delete")
    public ResponseCode delete(@RequestBody List<Long> ids) {
        try {
            menuService.delete(ids);
            return ResponseCode.success();
        } catch (Exception e) {
            e.printStackTrace();
            throw new GlobalException(e.getMessage());
        }
    }
}
