package com.codeworld.fc.auth.client;

import com.codeworld.fc.auth.domain.Menu;
import com.codeworld.fc.common.response.FCResponse;
import io.swagger.annotations.ApiOperation;
import org.mapstruct.Mapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("codeworld-cloud-menu")
public interface MenuClient {

    @GetMapping("/system-menu/get-menu-role-id")
    @ApiOperation("根据角色id查询菜单")
    public FCResponse<List<Menu>> getMenuByRoleId(@RequestParam("roleId") Long roleId);
}
