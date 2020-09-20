package studentTracking.model;

/**
 * 角色菜单分配实体类
 */
public class RolePower {
    /**
     * 角色id
     */
    private long roleId;
    /**
     * 菜单id
     */
    private long menuId;

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public long getMenuId() {
        return menuId;
    }

    public void setMenuId(long menuId) {
        this.menuId = menuId;
    }
}
