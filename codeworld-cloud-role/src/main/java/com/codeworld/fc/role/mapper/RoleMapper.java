package com.codeworld.fc.role.mapper;

import com.codeworld.fc.role.entity.Role;
import com.codeworld.fc.role.entity.RoleMenu;
import com.codeworld.fc.role.entity.UserRole;
import com.codeworld.fc.role.vo.RoleSearchVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface RoleMapper {

    /**
     * 根据用户id删除角色id
     * @param userId
     */
    void deleteUserRoleByUserId(Long userId);

    /**
     * 添加用户角色
     * @param userRole
     */
    void addUserRole(UserRole userRole);

    /**
     * 根据用户id查询角色
     * @param userId
     * @return
     */
    Role getRoleByUserId(Long userId);

    /**
     * 获取全部角色
     * @return
     */
    List<Role> getAllRoleNoParam();

    /**
     * 获取全部角色
     * @param roleSearchVO
     * @return
     */
    List<Role> getAllRole(RoleSearchVO roleSearchVO);

    /**
     * 获取角色菜单
     * @param roleId
     * @return
     */
    List<RoleMenu> getRoleMenuByRoleId(Long roleId);

    /**
     * 修改角色
     * @param role
     */
    void updateRole(Role role);

    /**
     * 添加角色
     * @param role
     */
    void addRole(Role role);

    /**
     * 删除角色关联的用户
     * @param roleId
     */
    void deleteUserRoleByRoleId(Long roleId);

    /**
     * 删除角色信息
     * @param roleId
     */
    void deleteRoleByRoleId(Long roleId);

    /**
     * 获取角色关联的用户Id
     * @param roleId
     * @return
     */
    List<Long> getUserIdByRoleId(Long roleId);

    /**
     * 直接将角色关联的用户的角色id修改为默认角色
     * @param map
     */
    void updateUserRoleByRoleId(Map<String, Object> map);
}
