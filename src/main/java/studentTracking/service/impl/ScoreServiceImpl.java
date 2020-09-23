package studentTracking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentTracking.dao.IScoreDao;
import studentTracking.service.IScoreService;

import java.util.List;
import java.util.Map;
@Service
public class ScoreServiceImpl implements IScoreService {
    @Autowired
    private IScoreDao scoreDao;

    /**
     * 获取学生的个人成绩
     * @param userName 用户名
     * @param pwd 密码
     * @return 学生的各科成绩
     */
    @Override
    public List<Map<String, Object>> getPersonScore(String userName, String pwd) {
        return scoreDao.getPersonScore(userName, pwd);
    }



}
