package com.codeworld.fc.user.service;

import com.codeworld.fc.common.response.DataResponse;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.user.dto.UserDeptResponse;
import com.codeworld.fc.user.dto.UserInfoResponse;
import com.codeworld.fc.user.entity.User;
import com.codeworld.fc.user.request.UserLoginRequest;
import com.codeworld.fc.user.request.UserRegisterRequest;
import com.codeworld.fc.user.request.UserSearchRequest;
import com.codeworld.fc.user.request.UserUpdateRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface UserService {
    /**
     * 获取全部用户
     * @param userSearchRequest
     * @return
     */
    FCResponse<DataResponse<List<User>>> getAllUser(UserSearchRequest userSearchRequest);


    /**
     * 修改用户状态
     * @param userId
     * @param userStatus
     * @return
     */
    FCResponse<Void> updateUserStatus(Long userId, Integer userStatus);

    /**
     * 删除用户
     * @param userId
     * @return
     */
    FCResponse<Void> deleteUser(Long userId);

    /**
     * 添加用户
     * @param userRegisterRequest
     * @return
     */
    FCResponse<Void> addUser(UserRegisterRequest userRegisterRequest);

    /**
     * 根据用户名获取用户
     * @param username
     * @return
     */
    FCResponse<User> getUserByName(String username);

    /**
     * 根据部门Id获取用户信息
     * @param deptId
     * @return
     */
    FCResponse<List<UserDeptResponse>> getUserByDeptId(Long deptId);

    /**
     * 修改用户
     * @param userUpdateRequest
     * @return
     */
    FCResponse<Void> updateUser(UserUpdateRequest userUpdateRequest);
}
