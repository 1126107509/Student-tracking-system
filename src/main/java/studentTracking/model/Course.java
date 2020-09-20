package studentTracking.model;

/**
 * 课程实体类
 */
public class Course {
    /**
     * 课程id
     */
    private long courseId;
    /**
     * 课程名称
     */
    private String courseName;
    /**
     * 课程状态
     */
    private String courseState;

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseState() {
        return courseState;
    }

    public void setCourseState(String courseState) {
        this.courseState = courseState;
    }
}
