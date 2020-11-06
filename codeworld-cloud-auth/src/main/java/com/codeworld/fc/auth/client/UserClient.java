package com.codeworld.fc.auth.client;

import com.codeworld.fc.auth.domain.User;
import com.codeworld.fc.common.response.FCResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("codeworld-cloud-user")
public interface UserClient {

    @GetMapping("/system-user/get-user-name")
    @ApiOperation("根据用户名获取用户")
    FCResponse<User> getUserByName(@RequestParam("username") String username);
}
