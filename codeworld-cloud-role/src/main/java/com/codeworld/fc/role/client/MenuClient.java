package com.codeworld.fc.role.client;

import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.role.entity.RoleMenu;
import com.codeworld.fc.role.vo.RoleMenuRequest;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("codeworld-cloud-menu")
public interface MenuClient {

    @GetMapping("/system-menu/delete-role-menu-role-id")
    @ApiOperation("删除用户角色菜单")
    FCResponse<Void> deleteRoleMenuByRoleId(@RequestParam("roleId") Long roleId);

    @PostMapping("/system-menu/add-role-menu")
    @ApiOperation("添加角色菜单")
    FCResponse<Void> addRoleMenu(@RequestBody RoleMenu roleMenu);
}
