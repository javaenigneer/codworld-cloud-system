package com.codeworld.fc.role.service;

import com.codeworld.fc.common.response.DataResponse;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.role.entity.Role;
import com.codeworld.fc.role.entity.RoleMenu;
import com.codeworld.fc.role.entity.UserRole;
import com.codeworld.fc.role.vo.RoleAddRequest;
import com.codeworld.fc.role.vo.RoleMenuRequest;
import com.codeworld.fc.role.vo.RoleSearchVO;
import com.codeworld.fc.role.vo.RoleUpdateRequest;

import java.util.List;

public interface RoleService {
    /**
     * 根据用户id删除用户角色
     * @param userId
     * @return
     */
    FCResponse<Void> deleteUserRoleByUserId(Long userId);

    /**
     * 添加用户角色
     * @param userRole
     * @return
     */
    FCResponse<Void> addUserRole(UserRole userRole);

    /**
     * 根据用户id获取角色信息
     * @param userId
     * @return
     */
    FCResponse<Role> getRoleByUserId(Long userId);

    /**
     * 获取全部角色无参数
     * @return
     */
    FCResponse<List<Role>> getAllRoleNoParam();

    /**
     * 获取全部角色
     * @param roleSearchVO
     * @return
     */
    FCResponse<DataResponse<List<Role>>> getAllRole(RoleSearchVO roleSearchVO);

    /**
     * 获取角色菜单
     * @param roleId
     * @return
     */
    FCResponse<List<RoleMenu>> getRoleMenu(Long roleId);

    /**
     * 修改角色
     * @param roleUpdateRequest
     * @return
     */
    FCResponse<Void> updateRole(RoleUpdateRequest roleUpdateRequest);

    /**
     * 设置角色菜单
     * @param roleMenuRequest
     * @return
     */
    FCResponse<Void> addRoleMenu(RoleMenuRequest roleMenuRequest);

    /**
     * 添加角色
     * @param roleAddRequest
     * @return
     */
    FCResponse<Void> addRole(RoleAddRequest roleAddRequest);

    /**
     * 删除角色
     * @param roleId
     * @return
     */
    FCResponse<Void> deleteRole(Long roleId);
}
