package com.codeworld.fc.auth.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.codeworld.fc.auth.client.MenuClient;
import com.codeworld.fc.auth.client.RoleClient;
import com.codeworld.fc.auth.client.UserClient;
import com.codeworld.fc.auth.config.JWTUtil;
import com.codeworld.fc.auth.config.JwtAuthenticationToken;
import com.codeworld.fc.auth.config.SecurityUtils;
import com.codeworld.fc.auth.domain.*;
import com.codeworld.fc.auth.request.UserLoginRequest;
import com.codeworld.fc.auth.response.UserInfoResponse;
import com.codeworld.fc.auth.service.AuthService;

import com.codeworld.fc.common.enums.HttpFcStatus;
import com.codeworld.fc.common.enums.HttpMsg;
import com.codeworld.fc.common.exception.FCException;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.common.utils.AddressUtil;
import com.codeworld.fc.common.utils.IPUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * ClassName AuthServiceImpl
 * Description TODO
 * Author Lenovo
 * Date 2020/11/4
 * Version 1.0
 **/
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired(required = false)
    private AuthenticationManager authenticationManager;

    @Autowired(required = false)
    private UserClient userClient;
    @Autowired(required = false)
    private RoleClient roleClient;
    @Autowired(required = false)
    private MenuClient menuClient;

    /**
     * 系统登录
     *
     * @param userLoginRequest
     * @return
     */
    @Override
    public FCResponse<Map<String, Object>> login(UserLoginRequest userLoginRequest, HttpServletRequest request, HttpServletResponse response) {
        try {
            // 执行登录授权
            JwtAuthenticationToken authenticationToken = SecurityUtils.login(request, userLoginRequest, authenticationManager);
            Map<String, Object> map = new HashMap<>();
            map.put("token", authenticationToken.getToken());
            return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.user.USER_LOGIN_SUCCESS.getMsg(), map);
        } catch (Exception e) {
            e.printStackTrace();
            throw new FCException("系统错误");
        }
    }

    /**
     * 获取用户信息
     *
     * @param userLoginRequest
     * @param request
     * @param response
     * @return
     */
    @Override
    public FCResponse<UserInfoResponse> getUserInfo(UserLoginRequest userLoginRequest, HttpServletRequest request, HttpServletResponse response) {
        try {
            String userName = JWTUtil.getUserName(userLoginRequest.getToken());
            // 根据用户名查询用户信息
            FCResponse<User> userFCResponse = this.userClient.getUserByName(userName);
            if (userFCResponse.getCode() == HttpFcStatus.PARAMSERROR.getCode()) {
                return FCResponse.dataResponse(HttpFcStatus.PARAMSERROR.getCode(), userFCResponse.getMsg());
            }
            UserInfoResponse userInfoResponse = new UserInfoResponse();
            Set<String> roles = new HashSet<>();
            Set<MenuVO> menuVOS = new HashSet<>();
            Set<ButtonVO> buttonVOS = new HashSet<>();
            BeanUtil.copyProperties(userFCResponse.getData(), userInfoResponse);
            // 根据用户id查询角色信息
            FCResponse<Role> roleFcResponse = this.roleClient.getRoleByUserId(userFCResponse.getData().getUserId());
            if (roleFcResponse.getCode() == HttpFcStatus.PARAMSERROR.getCode()) {
                return FCResponse.dataResponse(HttpFcStatus.PARAMSERROR.getCode(), roleFcResponse.getMsg());
            }
            roles.add(roleFcResponse.getData().getRoleCode());
            // 根据角色id查询角色权限
            FCResponse<List<Menu>> menuFcResponse = this.menuClient.getMenuByRoleId(roleFcResponse.getData().getRoleId());
            if (menuFcResponse.getCode() == HttpFcStatus.PARAMSERROR.getCode()) {
                return FCResponse.dataResponse(HttpFcStatus.PARAMSERROR.getCode(), menuFcResponse.getMsg());
            }
            if (ObjectUtils.isEmpty(menuFcResponse.getData())) {
                return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), menuFcResponse.getMsg());
            }
            List<Menu> menus = menuFcResponse.getData();
            // 菜单不为空
            if (!CollectionUtils.isEmpty(menus)) {
                menus.stream().filter(Objects::nonNull).forEach(menu -> {
                    // 按钮权限
                    if (StringUtils.equalsIgnoreCase("button", menu.getType())) {
                        // 添加到按钮权限
                        ButtonVO buttonVO = new ButtonVO();
                        BeanUtil.copyProperties(menu, buttonVO);
                        buttonVOS.add(buttonVO);
                    }
                    // 菜单权限
                    if (StringUtils.equalsIgnoreCase("menu", menu.getType())) {
                        // 添加到菜单权限
                        MenuVO menuVO = new MenuVO();
                        BeanUtil.copyProperties(menu, menuVO);
                        menuVOS.add(menuVO);
                    }
                });
            }
            userInfoResponse.getRoles().addAll(roles);
            userInfoResponse.getButtons().addAll(buttonVOS);
            userInfoResponse.getMenus().addAll(TreeBuilder.buildTree(menuVOS));
            userInfoResponse.setLoginIp(IPUtil.getIpAddr(request));
            userInfoResponse.setLoginLocation(AddressUtil.getCityInfo(IPUtil.getIpAddr(request)));
            userInfoResponse.setLoginTime(new Date());
            return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.user.USER_AUTH_SUCCESS.getMsg(), userInfoResponse);
        } catch (Exception e) {
            e.printStackTrace();
            throw new FCException("系统错误");
        }
    }
}
