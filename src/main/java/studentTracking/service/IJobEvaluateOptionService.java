package studentTracking.service;

import studentTracking.model.EvaluateDate;
import studentTracking.model.JobEvaluateOption;

import java.util.List;

/**
 * 评价分项接口1
 */
public interface IJobEvaluateOptionService {


    /**
     * 查询所有积分1
     * @param page
     * @param limit
     * @return
     */
    List<JobEvaluateOption> listJobItem(int page, int limit);

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
    boolean addJobItem( String[] optionNames);

    /**
     * 根据指定的optionId删除评价分项1
     * @param optionId
     * @return
     */
    boolean delJobItem(int optionId);



}
