package studentTracking.model;

/**
 * 用户实体类
 */
public class User {
    /**
     * 用户id
     */
    private long userId;

    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 用户密码
     */
    private String pwd;
    /**
     * 手机
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;

    /**
     * 权限状态 0未授权 1授权
     */
    private int power;
    /**
     * 标识  教师 1
     */
    private int flag;
    /**
     * 登录时间
     */
    private String loginTime;

    /**
     * 对应的老师或学生的id
     */
    private long peopleId;

    /**
     * 学生名字
     */
    private String stuName;
    /**
     * 教师名字
     */
    private String tname;

    /**
     * 前台用于显示的名字
     */
    public String getRealName() {
        return stuName == null ? tname : stuName;
    }


    public String getPowerName() {
        return power == 0 ? "未授权" : "已授权";
    }

    public String getUserType() {
        return flag == 1 ? "教师" : "学生";
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }


    public long getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(long peopleId) {
        this.peopleId = peopleId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

}
