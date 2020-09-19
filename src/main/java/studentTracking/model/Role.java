package studentTracking.model;

/**
 * 角色实体类
 */
public class Role {
    /**
     * 角色id
     */
    private long roleId;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色类型
     */
    private String roleType;
    /**
     * 备注
     */
    private String note;
    /**
     * 标识
     */
    private String flag;
    /**
     * 用户角色类型
     */
    private String roleUserType;

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getRoleUserType() {
        return roleUserType;
    }

    public void setRoleUserType(String roleUserType) {
        this.roleUserType = roleUserType;
    }
}
