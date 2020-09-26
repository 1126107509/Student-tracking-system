package studentTracking.dao;

import org.apache.ibatis.annotations.Param;
import studentTracking.model.EvaluateDate;

import java.util.List;

/**
 * 评价时间节点dao层接口
 */
public interface IEvaluateDateDao {

    /**
     * 添加工作时间节点1
     * @param times
     * @return
     */
    boolean addJobTime(@Param("times") String[] times);


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
