package studentTracking.service;

import studentTracking.model.EvaluateDate;

import java.util.List;

/**
 * 时间节点接口
 */
public interface IEvaluateDateService {

    /**
     * 添加工作时间节点1
     * @param times
     * @return
     */
    boolean addJobTime(String[] times);

    /**
     * 查询所有的时间节点1
     * @return
     */
    int listNumJobTime();

    /**
     * 分页查询所有的时间结点1
     * @param i
     * @param limit
     * @return
     */
    List<EvaluateDate> listJobTime(int i, int limit);

    /**
     * 根据id删除指定时间节点1
     * @param dateId
     * @return
     */
    boolean delJobTime(int dateId);
}
