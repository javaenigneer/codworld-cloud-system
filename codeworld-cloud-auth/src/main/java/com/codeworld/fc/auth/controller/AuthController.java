package com.codeworld.fc.auth.controller;

import com.codeworld.fc.auth.request.UserLoginRequest;
import com.codeworld.fc.auth.request.UserRegisterRequest;
import com.codeworld.fc.auth.response.UserInfoResponse;
import com.codeworld.fc.auth.service.AuthService;
import com.codeworld.fc.common.response.FCResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Map;

/**
 * ClassName AuthController
 * Description 授权接口管理
 * Author Lenovo
 * Date 2020/11/4
 * Version 1.0
 **/
@RequestMapping("system-auth")
@RestController
@Api(tags = "授权接口管理")
public class AuthController {

    @Autowired(required = false)
    private AuthService authService;

    @PostMapping("user-login")
    @ApiOperation("系统登录")
    public FCResponse<Map<String, Object>> login(@RequestBody @Valid UserLoginRequest userLoginRequest,
                                                 HttpServletRequest request,
                                                 HttpServletResponse response) {
        return this.authService.login(userLoginRequest, request, response);
    }

    @PostMapping("get-user-info")
    @ApiOperation("获取用户信息")
    public FCResponse<UserInfoResponse> getUserInfo(@RequestBody UserLoginRequest userLoginRequest,
                                                    HttpServletRequest request,
                                                    HttpServletResponse response) {
        return this.authService.getUserInfo(userLoginRequest, request, response);
    }
}
