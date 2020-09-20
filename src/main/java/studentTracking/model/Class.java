package studentTracking.model;

/**
 * 班级实体类
 */
public class Class {
    /**
     * 班级id
     */
    private long classId;
    /**
     * 班级名称
     */
    private String className;

    public long getClassId() {
        return classId;
    }

    public void setClassId(long classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
