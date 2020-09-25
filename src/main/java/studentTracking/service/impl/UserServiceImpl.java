package studentTracking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentTracking.dao.IUserDao;
import studentTracking.model.User;
import studentTracking.service.IUserService;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    /**
     * 添加用户信息
     *
     * @param user
     * @return
     */
    @Override
    public boolean addUser(User user) {
        return userDao.addUser(user);
    }

    /**
     * 根据指定的personId删除用户
     *
     * @param peopleID
     * @return
     */
    @Override
    public boolean delPersonByPersonId(int peopleID) {
        return userDao.delPersonByPersonId(peopleID);
    }

    /**
     * 通过条件查询用户的总数
     *
     * @param condition 查询条件
     * @return 返回总数
     */
    @Override
    public int userNumByCondition(String condition) {
        return userDao.userNumByCondition(condition);
    }

    /**
     * 通过条件查询用户信息
     *
     * @param page      页码
     * @param limit     条数
     * @param condition 查询条件
     * @return 用户集合
     */
    @Override
    public List<User> userListByCondition(int page, int limit, String condition) {
        return userDao.userListByCondition(page, limit, condition);
    }

    /**
     * 根据用户id修改用户权限
     *
     * @param userId
     * @param power
     * @return
     */
    @Override
    public boolean updatePower(int userId, int power) {
        return userDao.updatePower(userId, power);
    }

    /**
     * 根据用户id删除用户
     *
     * @param userId
     * @return
     */
    @Override
    public boolean delUser(int userId) {
        return userDao.delUser(userId);
    }
}
