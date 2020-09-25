package studentTracking.model;

import java.util.List;

/**
 * 学生实体类
 */
public class Student {
    /**
     * 学生id
     */
    private long stuId;
    /**
     *学生姓名
     */
    private String stuName;
    /**
     * 性别
     */
    private String sex;
    /**
     * 民族
     */
    private String nation;
    /**
     * 出生日期
     */
    private String birthday;
    /**
     * 出生地
     */
    private String birthPlace;
    /**
     * 婚姻状态
     */
    private String marry;
    /**
     * tel
     */
    private String telephone;
    /**
     * 身份证号
     */
    private String idCard;
    /**
     * 毕业院校
     */
    private String university;
    /**
     * 专业
     */
    private String major;
    /**
     * 照片
     */
    private String photo;
    /**
     * 备注
     */
    private String note;
    /**
     * 目前状态
     */
    private String state;
    /**
     * 班级id
     */
    private long classId;
    /**
     * 部门id
     */
    private long deptId;
    /**
     * 分数
     */
    private List<Score> scoreList;
    /**
     * 培训学校评价
     */
    private SchoolEvaluation schoolEvaluation;

    /**
     * 邮箱
     */
    private String email;



    public Student() {
    }

    public Student(long stuId, String stuName, String sex, String nation, String birthday,
                   String birthPlace, String marry, String telephone, String idCard,
                   String university, String major, String photo, String note, String state,
                   long classId, long deptId, String email) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.sex = sex;
        this.nation = nation;
        this.birthday = birthday;
        this.birthPlace = birthPlace;
        this.marry = marry;
        this.telephone = telephone;
        this.idCard = idCard;
        this.university = university;
        this.major = major;
        this.photo = photo;
        this.note = note;
        this.state = state;
        this.classId = classId;
        this.deptId = deptId;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getStuId() {
        return stuId;
    }

    public void setStuId(long stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getMarry() {
        return marry;
    }

    public void setMarry(String marry) {
        this.marry = marry;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getClassId() {
        return classId;
    }

    public void setClassId(long classId) {
        this.classId = classId;
    }

    public long getDeptId() {
        return deptId;
    }

    public void setDeptId(long deptId) {
        this.deptId = deptId;
    }

    public List<Score> getScoreList() {
        return scoreList;
    }

    public void setScoreList(List<Score> scoreList) {
        this.scoreList = scoreList;
    }

    public SchoolEvaluation getSchoolEvaluation() {
        return schoolEvaluation;
    }

    public void setSchoolEvaluation(SchoolEvaluation schoolEvaluation) {
        this.schoolEvaluation = schoolEvaluation;
    }
}
