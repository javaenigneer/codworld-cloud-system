package com.codeworld.fc.role.controller;

import com.codeworld.fc.common.response.DataResponse;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.role.entity.Role;
import com.codeworld.fc.role.entity.RoleMenu;
import com.codeworld.fc.role.entity.UserRole;
import com.codeworld.fc.role.service.RoleService;
import com.codeworld.fc.role.vo.RoleAddRequest;
import com.codeworld.fc.role.vo.RoleMenuRequest;
import com.codeworld.fc.role.vo.RoleSearchVO;
import com.codeworld.fc.role.vo.RoleUpdateRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * ClassName RoleController
 * Description 角色接口管理
 * Author Lenovo
 * Date 2020/11/4
 * Version 1.0
 **/
@RestController
@RequestMapping("system-role")
@Api(tags = "角色管理接口")
public class RoleController {

    @Autowired(required = false)
    private RoleService roleService;

    @PostMapping("delete-user-role-user-id")
    @ApiOperation("根据用户Id删除用户角色")
    public FCResponse<Void> deleteUserRoleByUserId(@RequestParam("userId") Long userId) {
        return this.roleService.deleteUserRoleByUserId(userId);
    }

    @PostMapping("add-user-role")
    @ApiOperation("添加用户角色")
    public FCResponse<Void> addUserRole(@RequestBody UserRole userRole) {
        return this.roleService.addUserRole(userRole);
    }

    @GetMapping("get-role-user-id")
    @ApiOperation("根据用户id获取角色")
    public FCResponse<Role> getRoleByUserId(@RequestParam("userId") Long userId) {
        return this.roleService.getRoleByUserId(userId);
    }

    @PostMapping("get-all-role-no-param")
    @ApiOperation("获取全部角色--无参数")
    public FCResponse<List<Role>> getAllRoleNoParam() {
        return this.roleService.getAllRoleNoParam();
    }

    @PostMapping("get-all-role")
    @ApiOperation("获取全部角色")
    public FCResponse<DataResponse<List<Role>>> getAllRole(@RequestBody RoleSearchVO roleSearchVO) {
        return this.roleService.getAllRole(roleSearchVO);
    }

    @PostMapping("get-role-menu")
    @ApiOperation("获取角色菜单")
    public FCResponse<List<RoleMenu>> getRoleMenu(@RequestParam("roleId") Long roleId) {
        return this.roleService.getRoleMenu(roleId);
    }

    @PostMapping("update-role")
    @ApiOperation("修改角色")
    public FCResponse<Void> updateRole(@RequestBody @Valid RoleUpdateRequest roleUpdateRequest) {
        return this.roleService.updateRole(roleUpdateRequest);
    }

    @PostMapping("add-role-menu")
    @ApiOperation("设置角色菜单")
    public FCResponse<Void> addRoleMenu(@RequestBody RoleMenuRequest roleMenuRequest) {
        return this.roleService.addRoleMenu(roleMenuRequest);
    }

    @PostMapping("add-role")
    @ApiOperation("添加角色")
    public FCResponse<Void> addRole(@RequestBody @Valid RoleAddRequest roleAddRequest) {
        return this.roleService.addRole(roleAddRequest);
    }

    @PostMapping("delete-role")
    @ApiOperation("删除角色")
    public FCResponse<Void> deleteRole(@RequestParam("roleId") Long roleId){
        return this.roleService.deleteRole(roleId);
    }
}
