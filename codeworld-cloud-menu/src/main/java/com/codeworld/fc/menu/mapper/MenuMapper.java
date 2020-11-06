package com.codeworld.fc.menu.mapper;

import com.codeworld.fc.menu.entity.Menu;
import com.codeworld.fc.menu.entity.RoleMenu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MenuMapper {


    /**
     * 根据角色id查询菜单
     * @param roleId
     * @return
     */
    List<Menu> getMenuByRoleId(Long roleId);

    /**
     * 获取全部菜单
     * @return
     */
    List<Menu> getAllMenu();

    /**
     * 删除用户角色菜单
     * @param roleId
     */
    void deleteRoleMenuByRoleId(Long roleId);

    /**
     * 添加角色菜单
     * @param roleMenu
     */
    void addRoleMenu(RoleMenu roleMenu);

    /**
     * 添加菜单
     * @param menu
     */
    void addMenu(Menu menu);

    /**
     * 根据菜单id查询信息
     * @param id
     * @return
     */
    Menu getMenuById(Long id);

    /**
     * 查询自己的子菜单
     * @param id
     * @return
     */
    List<Menu> getChildMenuById(Long id);

    /**
     * 删除角色关联的菜单
     * @param ids
     */
    void deleteRoleMenu(List<Long> ids);

    /**
     * 删除菜单信息
     * @param id
     */
    void deleteMenuById(Long id);

    /**
     * 删除子集菜单
     * @param id
     */
    void deleteChildMenu(Long id);

    /**
     * 修改菜单
     * @param menu
     */
    void updateMenu(Menu menu);
}

