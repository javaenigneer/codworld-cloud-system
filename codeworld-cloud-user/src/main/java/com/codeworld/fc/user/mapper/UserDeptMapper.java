package com.codeworld.fc.user.mapper;

import com.codeworld.fc.user.entity.UserDept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDeptMapper {
    /**
     * 添加用户部门
     * @param userDept
     */
    void addUserDept(UserDept userDept);

    /**
     * 根据用户id删除用户相关部门
     * @param userId
     */
    void deleteUserDeptByUserId(Long userId);

    /**
     * 根据用户Id获取部门Id
     * @param userId
     * @return
     */
    List<UserDept> getDeptIdByUserId(Long userId);
}
