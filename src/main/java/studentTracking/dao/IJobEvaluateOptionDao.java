package studentTracking.dao;

import org.apache.ibatis.annotations.Param;
import studentTracking.model.JobEvaluateOption;

import java.util.List;

/**
 * 评价分项dao层接口
 */
public interface IJobEvaluateOptionDao {

    /**
     * 查询所有的评价分项1
     * @param page
     * @param limit
     * @return
     */
    List<JobEvaluateOption> listJobItem(@Param("page") int page, @Param("limit") int limit);

    /**
     * 查询所有的评价分项1
     * @return
     */
    int listNumJobEvaluation();


    /**
     * 添加工作评分项1
     * @param optionNames
     * @return
     */
    boolean addJobItem(@Param("optionNames")String[] optionNames);

    /**
     * 根据指定的optionId删除评价分项1
     * @param optionId
     * @return
     */
    boolean delJobItem(int optionId);
}
