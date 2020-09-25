package studentTracking.service;

import org.apache.ibatis.annotations.Param;

public interface ISchoolEvaluationService {
    /**
     * 添加评价信息
     * @param stuId 学生id
     * @param evaluatePerson 评价人
     * @param evaluateScore 评价分数
     * @param evaluateContent 评价内容
     * @return 是否添加成功
     */
    boolean addSchoolEvaluate(@Param("stuId") long stuId,
                              @Param("evaluatePerson") String evaluatePerson,
                              @Param("evaluateScore") double evaluateScore,
                              @Param("evaluateContent") String evaluateContent);

    /**
     * 修改评价信息
     * @param evaluateId 评价id
     * @param stuId 学生id
     * @param evaluatePerson 评价人
     * @param evaluateScore 评价分数
     * @param evaluateContent 评价内容
     * @return 是否修改成功
     */
    boolean updateSchoolEvaluate(@Param("evaluateId") long evaluateId,
                                 @Param("stuId") long stuId,
                                 @Param("evaluatePerson") String evaluatePerson,
                                 @Param("evaluateScore") double evaluateScore,
                                 @Param("evaluateContent") String evaluateContent);
}
