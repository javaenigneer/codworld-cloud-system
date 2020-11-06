package com.codeworld.fc.auth.config;

import com.codeworld.fc.auth.client.MenuClient;
import com.codeworld.fc.auth.client.RoleClient;
import com.codeworld.fc.auth.client.UserClient;
import com.codeworld.fc.auth.domain.Menu;
import com.codeworld.fc.auth.domain.Role;
import com.codeworld.fc.auth.domain.User;
import com.codeworld.fc.common.enums.HttpFcStatus;
import com.codeworld.fc.common.enums.HttpMsg;
import com.codeworld.fc.common.enums.StatusEnum;
import com.codeworld.fc.common.exception.FCException;
import com.codeworld.fc.common.response.FCResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * ClassName UserDetailServiceImpl
 * Description 用户登录认证信息查询
 * Author Lenovo
 * Date 2020/11/4
 * Version 1.0
**/
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailServiceImpl.class);

    @Autowired(required = false)
    private UserClient userClient;
    @Autowired(required = false)
    private RoleClient roleClient;
    @Autowired(required = false)
    private MenuClient menuClient;

    private final String USER_INFO = "USER_INFO:USER:ID:";


    @Override
    public UserDetails loadUserByUsername(String username) {
        // 根据用户名查询用户
        FCResponse<User> userFCResponse = this.userClient.getUserByName(username);
        if (userFCResponse.getCode() == HttpFcStatus.PARAMSERROR.getCode()){
            throw new FCException(userFCResponse.getMsg());
        }
        if (ObjectUtils.isEmpty(userFCResponse.getData())){
            throw new FCException(userFCResponse.getMsg());
        }
        User user = userFCResponse.getData();
        if (user.getUserStatus() == StatusEnum.USER_DISABLE){
            throw new FCException(HttpMsg.user.USER_DISABLE.getMsg());
        }
        // 根据用户id查询角色信息
        FCResponse<Role> roleFCResponse = this.roleClient.getRoleByUserId(user.getUserId());
        if (roleFCResponse.getCode() == HttpFcStatus.PARAMSERROR.getCode()){
            throw new FCException(roleFCResponse.getMsg());
        }
        if (ObjectUtils.isEmpty(roleFCResponse.getData())){
            throw new FCException(roleFCResponse.getMsg());
        }
        Role role = roleFCResponse.getData();
        // 根据角色id查询权限信息
        FCResponse<List<Menu>> menuFCResponse = this.menuClient.getMenuByRoleId(role.getRoleId());
        if (menuFCResponse.getCode() == HttpFcStatus.PARAMSERROR.getCode()){
            throw new FCException(menuFCResponse.getMsg());
        }
        if (ObjectUtils.isEmpty(menuFCResponse.getData())){
            throw new FCException(menuFCResponse.getMsg());
        }
        List<Menu> menus = menuFCResponse.getData();
        Set<String> permissions = new HashSet<>();
        permissions = menus.stream().map(Menu::getResources).collect(Collectors.toSet());
        List<GrantedAuthority> grantedAuthorities = permissions.stream().map(GrantedAuthorityImpl::new).collect(Collectors.toList());
        return new JwtUserDetails(username, new BCryptPasswordEncoder().encode("123456"), grantedAuthorities);
    }
}
