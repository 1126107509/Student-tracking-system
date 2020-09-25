package studentTracking.service;

import studentTracking.model.User;

import java.util.List;
import java.util.Map;

public interface IUserService {

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
    int userNumByCondition(String condition);


    /**
     * 通过条件查询用户信息
     * @param page
     * @param limit
     * @param condition
     * @return
     */
    List<User> userListByCondition(int page, int limit, String condition);

    /**
     * 根据用户id修改用户权限
     * @param userId
     * @param power
     * @return
     */
    boolean updatePower(int userId, int power);

    /**
     * 根据用户id删除用户
     * @param userId
     * @return
     */
    boolean delUser(int userId);
}
