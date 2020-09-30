/**
 * @description Todo
 * @author li
 * @date 2020-09-29 08:29
 */
package studentTracking.model;

/**
 * 查询对象
 */
public class QueryObject {

    //页数
    private int page = 1;

    //每页条数
    private int limit = 5;

    //学生名称
    private String stuName;

    //教师
    private String tname;

    //学生状态
    private int stuState = -1;

    //班期
    private int classId = -1;

    //班级状态
    private int clzState = -1;

    //教师Id
    private long teacherId;

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    public int getPage() {
        return (page - 1) * limit;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
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

    public int getStuState() {
        return stuState;
    }

    public void setStuState(int stuState) {
        this.stuState = stuState;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getClzState() {
        return clzState;
    }

    public void setClzState(int clzState) {
        this.clzState = clzState;
    }

    @Override
    public String toString() {
        return "QueryObject{" +
                "page=" + page +
                ", limit=" + limit +
                ", stuName='" + stuName + '\'' +
                ", tname='" + tname + '\'' +
                ", stuState=" + stuState +
                ", classId=" + classId +
                ", clzState=" + clzState +
                ", teacherId=" + teacherId +
                '}';
    }
}
