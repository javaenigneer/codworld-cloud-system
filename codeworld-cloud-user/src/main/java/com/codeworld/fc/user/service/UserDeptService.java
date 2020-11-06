package com.codeworld.fc.user.service;

import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.user.entity.UserDept;

import java.util.List;

/**
 * ClassName UserDeptService
 * Description TODO
 * Author Lenovo
 * Date 2020/11/5
 * Version 1.0
**/
public interface UserDeptService {
    /**
     * 根据用户Id获取部门Id
     * @param userId
     * @return
     */
    FCResponse<List<UserDept>> getDeptIdByUserId(Long userId);
}
