package studentTracking.dao;

import org.apache.ibatis.annotations.Param;
import studentTracking.model.User;

/**
 * 用户dao层接口
 */
public interface IUserDao {
    /**
     * 根据用户名和密码获得登录用户id
     * @param userName 用户名
     * @param password 密码
     * @return 用户id
     */
    long getUserByLogin(@Param("userName") String userName, @Param("password") String password);

    /**
     * 根据用户id获取用户信息
     * @param userId 用户id
     * @return 用户信息
     */
    User getUserByUserId(long userId);

    /**
     * 根据用户id修改密码
     * @param userId 用户id
     * @param newPwd 新密码
     * @return 是否修改成功
     */
    boolean modifyPwdByUserId(@Param("userId") long userId, @Param("newPwd") String newPwd);
}
