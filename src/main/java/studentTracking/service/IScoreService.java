package studentTracking.service;

import org.apache.ibatis.annotations.Param;
import studentTracking.model.Score;

import java.util.List;
import java.util.Map;

public interface IScoreService {
    /**
     * 根据用户名和密码查询个人成绩
     * @param userName 用户名
     * @param pwd 密码
     * @return 学生的各科成绩
     */
    List<Map<String,Object>> getPersonScores(String userName,String pwd);

}
