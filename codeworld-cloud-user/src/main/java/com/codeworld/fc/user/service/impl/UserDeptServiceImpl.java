package com.codeworld.fc.user.service.impl;

import com.codeworld.fc.common.enums.HttpFcStatus;
import com.codeworld.fc.common.enums.HttpMsg;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.user.entity.UserDept;
import com.codeworld.fc.user.mapper.UserDeptMapper;
import com.codeworld.fc.user.service.UserDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName UserDeptServiceImpl
 * Description TODO
 * Author Lenovo
 * Date 2020/11/5
 * Version 1.0
 **/
@Service
public class UserDeptServiceImpl implements UserDeptService {

    @Autowired(required = false)
    private UserDeptMapper userDeptMapper;

    /**
     * 根据用户Id获取部门Id
     *
     * @param userId
     * @return
     */
    @Override
    public FCResponse<List<UserDept>> getDeptIdByUserId(Long userId) {
        if (userId == null || userId <= 0) {
            return FCResponse.dataResponse(HttpFcStatus.PARAMSERROR.getCode(), HttpMsg.user.USER_ID_ERROR.getMsg(), null);
        }

        List<UserDept> userDepts = this.userDeptMapper.getDeptIdByUserId(userId);
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.dept.DEPT_GET_SUCCESS.getMsg(), userDepts);
    }
}
