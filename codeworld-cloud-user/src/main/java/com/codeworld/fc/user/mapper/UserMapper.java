package com.codeworld.fc.user.mapper;

import com.codeworld.fc.user.dto.UserDeptResponse;
import com.codeworld.fc.user.entity.User;
import com.codeworld.fc.user.request.UserSearchRequest;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper{


    /**
     * 获取全部用户
     * @param userSearchRequest
     * @return
     */
    List<User> getAllUser(UserSearchRequest userSearchRequest);

    /**
     * 修改用户状态
     * @param user
     */
    void updateUserStatus(User user);

    /**
     * 删除用户
     * @param userId
     */
    void deleteUser(Long userId);

    /**
     * 根据用户名获取用户
     * @param userName
     * @return
     */
    User getUserByName(String userName);

    /**
     * 添加用户
     * @param user
     */
    void addUser(User user);

    /**
     * 修改用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 根据部门Id获取用户信息
     * @param deptId
     * @return
     */
    List<UserDeptResponse> getUserByDeptId(Long deptId);
}
