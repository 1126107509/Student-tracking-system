package studentTracking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentTracking.dao.IEvaluateDateDao;
import studentTracking.model.EvaluateDate;
import studentTracking.service.IEvaluateDateService;

import java.util.List;

@Service("evaluateDateService")
public class EvaluateDateServiceImpl implements IEvaluateDateService {

    @Autowired
    private IEvaluateDateDao evaluateDateDao;

    /**
     * 添加工作时间节点1
     *
     * @param times
     * @return
     */
    @Override
    public boolean addJobTime(String[] times) {
        return evaluateDateDao.addJobTime(times);
    }

    /**
     * 查询所有的时间节点1
     *
     * @return
     */
    @Override
    public int listNumJobTime() {
        return evaluateDateDao.listNumJobTime();
    }

    /**
     * 分页查询所有的时间结点1
     *
     * @param i
     * @param limit
     * @return
     */
    @Override
    public List<EvaluateDate> listJobTime(int i, int limit) {
        return evaluateDateDao.listJobTime(i, limit);
    }

    /**
     * 根据id删除指定时间节点1
     *
     * @param dateId
     * @return
     */
    @Override
    public boolean delJobTime(int dateId) {
        return evaluateDateDao.delJobTime(dateId);
    }
}
