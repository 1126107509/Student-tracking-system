package studentTracking.model;

/**
 * 用户角色分配实体类
 */
public class UserRoleRelation {
    /**
     * 用户id
     */
    private long userId;
    /**
     * 角色id
     */
    private long roleId;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }
}
