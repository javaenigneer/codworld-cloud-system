package com.codeworld.fc.menu.service;

import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.menu.dto.MenuRequestDTO;
import com.codeworld.fc.menu.entity.Menu;
import com.codeworld.fc.menu.entity.RoleMenu;

import java.util.List;

public interface MenuService {
    /**
     * 根据角色id查询角色菜单
     * @param roleId
     * @return
     */
    FCResponse<List<Menu>> getMenuByRoleId(Long roleId);

    /**
     * 获取菜单树
     * @return
     */
    FCResponse<Object> treeMenu();

    /**
     * 删除角色菜单
     * @param roleId
     * @return
     */
    FCResponse<Void> deleteRoleMenuByRoleId(Long roleId);

    /**
     * 添加角色菜单
     * @param roleMenu
     * @return
     */
    FCResponse<Void> addRoleMenu(RoleMenu roleMenu);

    /**
     * 添加菜单
     * @param menuRequestDTO
     * @return
     */
    FCResponse<Void> addMenu(MenuRequestDTO menuRequestDTO);

    /**
     * 删除菜单
     * @param id
     * @return
     */
    FCResponse<Void> deleteMenu(Long id);

    /**
     * 修改菜单
     * @param menuRequestDTO
     * @return
     */
    FCResponse<Void> updateMenu(MenuRequestDTO menuRequestDTO);
}
