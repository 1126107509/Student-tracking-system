package studentTracking.model;

/**
 * 培训学校评价实体类
 */
public class SchoolEvaluation {
    /**
     * 评价id
     */
    private long evaluateId;
    /**
     * 学生id
     */
    private long stuId;
    /**
     * 评价人
     */
    private String evaluatePerson;
    /**
     * 评价成绩
     */
    private double evaluateScore;
    /**
     * 评语
     */
    private String evaluateContent;

    public long getEvaluateId() {
        return evaluateId;
    }

    public void setEvaluateId(long evaluateId) {
        this.evaluateId = evaluateId;
    }

    public long getStuId() {
        return stuId;
    }

    public void setStuId(long stuId) {
        this.stuId = stuId;
    }

    public String getEvaluatePerson() {
        return evaluatePerson;
    }

    public void setEvaluatePerson(String evaluatePerson) {
        this.evaluatePerson = evaluatePerson;
    }

    public double getEvaluateScore() {
        return evaluateScore;
    }

    public void setEvaluateScore(double evaluateScore) {
        this.evaluateScore = evaluateScore;
    }

    public String getEvaluateContent() {
        return evaluateContent;
    }

    public void setEvaluateContent(String evaluateContent) {
        this.evaluateContent = evaluateContent;
    }
}
