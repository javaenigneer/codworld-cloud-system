package com.codeworld.fc.auth.service;

import com.codeworld.fc.auth.request.UserLoginRequest;
import com.codeworld.fc.auth.response.UserInfoResponse;
import com.codeworld.fc.common.response.FCResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public interface AuthService {
    /**
     * 系统登录
     *
     * @param userLoginRequest
     * @return
     */
    FCResponse<Map<String, Object>> login(UserLoginRequest userLoginRequest, HttpServletRequest request, HttpServletResponse response);

    /**
     * 获取用户信息
     * @param userLoginRequest
     * @param request
     * @param response
     * @return
     */
    FCResponse<UserInfoResponse> getUserInfo(UserLoginRequest userLoginRequest, HttpServletRequest request, HttpServletResponse response);
}
