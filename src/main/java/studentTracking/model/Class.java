package studentTracking.model;

import java.util.List;

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
    /**
     * 教师id
     */
    private long teacherId;
    /**
     * 开课状态 0 未开课  1已开课  2已结课
     */
    private int state;

    public void setState(int state) {
        this.state = state;
    }

    /**
     * 学生集合
     */
    private List<Student> students;

    /**
     * 教师
     */
    private Teacher teacher;

    public Class() {
    }

    public Class(String className, long teacherId, List<Student> students) {
        this.className = className;
        this.teacherId = teacherId;
        this.students = students;
    }

    /** 班期状态 1
     * 0 未开课  1已开课  2已结课'
     * @return
     */
    public String getStateName() {
        switch (state) {

            case 0:
                return "未开课";
            case 1:
                return "已开课";
            default:
                return "已结课";
        }
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

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

    public long getState() {
        return state;
    }


    @Override
    public String toString() {
        return "Class{" +
                "classId=" + classId +
                ", className='" + className + '\'' +
                ", teacherId='" + teacherId + '\'' +
                ", students=" + students +
                '}';
    }
}
