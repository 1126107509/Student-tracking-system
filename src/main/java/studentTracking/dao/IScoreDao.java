package studentTracking.dao;

import org.apache.ibatis.annotations.Param;
import studentTracking.model.Score;

import java.util.List;
import java.util.Map;

/**
 * 成绩dao层接口
 */
public interface IScoreDao {
    /**
     * 根据用户名和密码查询个人成绩
     * @param userName 用户名
     * @param pwd 密码
     * @return 学生的各科成绩
     */
    List<Map<String,Object>> getPersonScores(@Param("userName")String userName,@Param("pwd")String pwd);

}
