package studentTracking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentTracking.dao.IScoreDao;
import studentTracking.model.Score;
import studentTracking.service.IScoreService;

import java.util.List;
import java.util.Map;

@Service
public class ScoreServiceImpl implements IScoreService {
    @Autowired
    private IScoreDao scoreDao;

    /**
     * 根据用户名和密码查询个人成绩
     * @param userName 用户名
     * @param pwd 密码
     * @return 各科成绩
     */
    @Override
    public List<Map<String, Object>> getPersonScores(String userName, String pwd) {
        return scoreDao.getPersonScores(userName, pwd);
    }
}
