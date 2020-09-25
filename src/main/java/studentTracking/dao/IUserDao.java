package studentTracking.dao;

import org.apache.ibatis.annotations.Param;
import studentTracking.model.User;

import java.util.List;

/**
 * 用户dao层接口
 */
public interface IUserDao {


    /**
     * 添加用户信息
     *
     * @param user
     * @return
     */
    boolean addUser(User user);


    /**
     * 根据指定的personId删除用户
     *
     * @param peopleID
     * @return
     */
    boolean delPersonByPersonId(int peopleID);


    /**
     * 通过条件查询用户的总数
     *
     * @param condition 查询条件
     * @return 返回总数
     */
    int userNumByCondition(@Param("condition") String condition, @Param("flag") int flag);


    /**
     * 通过条件查询用户信息
     *
     * @param page      页码
     * @param limit     条数
     * @param condition 查询条件
     * @return 用户集合
     */

    List<User> userListByCondition(@Param("page") int page, @Param("limit") int limit, @Param(
            "condition") String condition, @Param("flag") int flag);


    /**
     * 根据用户id修改用户权限
     *
     * @param userId
     * @param power
     * @return
     */
    boolean updatePower(@Param("userId") int userId, @Param("power") int power);


    /**
     * 根据用户id删除用户
     *
     * @param userId
     * @return
     */
    boolean delUser(int userId);
}
