package com.codeworld.fc.user.client;


import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.user.entity.UserRole;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient("codeworld-cloud-role")
public interface RoleClient {

    @PostMapping("/system-role/delete-user-role-user-id")
    @ApiOperation("根据用户Id删除用户角色")
    FCResponse<Void> deleteUserRoleByUserId(@RequestParam("userId") Long userId);

    @PostMapping("/system-role/add-user-role")
    @ApiOperation("添加用户角色")
    FCResponse<Void> addUserRole(@RequestBody UserRole userRole);
}
