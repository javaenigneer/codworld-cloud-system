package com.codeworld.fc.user.controller;

import com.codeworld.fc.common.response.DataResponse;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.user.dto.UserDeptResponse;
import com.codeworld.fc.user.dto.UserInfoResponse;
import com.codeworld.fc.user.entity.User;
import com.codeworld.fc.user.entity.UserDept;
import com.codeworld.fc.user.request.UserLoginRequest;
import com.codeworld.fc.user.request.UserRegisterRequest;
import com.codeworld.fc.user.request.UserSearchRequest;
import com.codeworld.fc.user.request.UserUpdateRequest;
import com.codeworld.fc.user.service.UserDeptService;
import com.codeworld.fc.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

/**
 * ClassName UserController
 * Description 用户管理接口
 * Author Lenovo
 * Date 2020/10/29
 * Version 1.0
**/
@RestController
@RequestMapping("system-user")
@ApiOperation("用户管理模块接口")
public class UserController {

    @Autowired(required = false)
    private UserService userService;
    @Autowired(required = false)
    private UserDeptService userDeptService;



    @PostMapping("get-all-user")
    @ApiOperation("获取全部用户")
    public FCResponse<DataResponse<List<User>>> getAllUser(@RequestBody UserSearchRequest userSearchRequest) {
        return this.userService.getAllUser(userSearchRequest);
    }

    @PostMapping("update-user-status")
    @ApiOperation("修改用户状态")
    public FCResponse<Void> updateUserStatus(@RequestParam("userId") Long userId,
                                             @RequestParam("status") Integer userStatus) {
        return this.userService.updateUserStatus(userId, userStatus);
    }

    @PostMapping("delete-user")
    @ApiOperation("删除用户")
    public FCResponse<Void> deleteUser(@RequestParam("userId") Long userId) {
        return this.userService.deleteUser(userId);
    }

    @PostMapping("add-user")
    @ApiOperation("添加用户")
    public FCResponse<Void> addUser(@RequestBody @Valid UserRegisterRequest userRegisterRequest) {
        return this.userService.addUser(userRegisterRequest);
    }

    @GetMapping("get-user-name")
    @ApiOperation("根据用户名获取用户")
    public FCResponse<User> getUserByName(@RequestParam("username") String username){
        return this.userService.getUserByName(username);
    }

    @GetMapping("get-dept-user-id")
    @ApiOperation("根据用户Id获取部门Id")
    public FCResponse<List<UserDept>> getDeptIdByUserId(@RequestParam("userId") Long userId){
        return this.userDeptService.getDeptIdByUserId(userId);
    }

    @PostMapping("update-user")
    @ApiOperation("修改用户")
    public FCResponse<Void> updateUser(@RequestBody @Valid UserUpdateRequest userUpdateRequest) {
        return this.userService.updateUser(userUpdateRequest);
    }

    @PostMapping("get-user-dept-id")
    @ApiOperation("根据部门Id获取用户信息")
    public FCResponse<List<UserDeptResponse>> getUserByDeptId(@RequestParam("deptId") Long deptId){
        return this.userService.getUserByDeptId(deptId);
    }
}
