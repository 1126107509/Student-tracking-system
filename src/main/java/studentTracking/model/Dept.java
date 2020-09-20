package studentTracking.model;

/**
 * 部门实体类
 */
public class Dept {
    /**
     * 部门编号
     */
    private long deptId;
    /**
     * 部门id
     */
    private String deptName;
    /**
     * 部门地址
     */
    private String deptAddress;

    public long getDeptId() {
        return deptId;
    }

    public void setDeptId(long deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptAddress() {
        return deptAddress;
    }

    public void setDeptAddress(String deptAddress) {
        this.deptAddress = deptAddress;
    }
}
