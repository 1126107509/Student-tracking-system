package studentTracking.dao;

import org.apache.ibatis.annotations.Param;
import studentTracking.model.User;

/**
 * 用户dao层接口
 */
public interface IUserDao {
    /**
     * 根据用户名和密码查询用户的所有信息
     * @param userName 用户名
     * @param pwd 密码
     * @return 封装后的user实体类
     */
    User getUser(@Param("userName") String userName, @Param("pwd") String pwd);
}
