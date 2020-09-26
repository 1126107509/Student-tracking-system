package studentTracking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentTracking.dao.IJobEvaluateOptionDao;
import studentTracking.model.JobEvaluateOption;
import studentTracking.service.IJobEvaluateOptionService;

import java.util.List;

/**
 * 评价分项实现类
 */
@Service("jobEvaluateOptionService")
public class JobEvaluateOptionServiceImpl implements IJobEvaluateOptionService {


    @Autowired
    private IJobEvaluateOptionDao jobEvaluateOptionDao;

    /**
     * 查询所有的评价分项1
     *
     * @return
     */
    @Override
    public List<JobEvaluateOption> listJobItem(int page, int limit) {
        return jobEvaluateOptionDao.listJobItem(page,limit);
    }

    /**
     * 查询所有的评价分项1
     *
     * @return
     */
    @Override
    public int listNumJobEvaluation() {
        return jobEvaluateOptionDao.listNumJobEvaluation();
    }

    /**
     * 添加工作评分项1
     *
     * @param optionNames
     * @return
     */
    @Override
    public boolean addJobItem(String[] optionNames) {
        return jobEvaluateOptionDao.addJobItem(optionNames);
    }

    /**
     * 根据指定的optionId删除评价分项
     *
     * @param optionId
     * @return
     */
    @Override
    public boolean delJobItem(int optionId) {
        return jobEvaluateOptionDao.delJobItem(optionId);
    }
}
