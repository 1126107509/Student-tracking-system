package studentTracking.dao;

import org.apache.ibatis.annotations.Param;

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
     * @return
     */
    List<Map<String,Object>> getPersonScore(@Param("userName")String userName,@Param("pwd")String pwd);
}
