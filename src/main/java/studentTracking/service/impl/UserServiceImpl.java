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
    public int userNumByCondition(String condition, int flag) {
        return userDao.userNumByCondition(condition, flag);
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
    public List<User> userListByCondition(int page, int limit, String condition, int flag) {
        return userDao.userListByCondition(page, limit, condition, flag);
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


    /**
     * 根据用户名和密码获得登录用户id
     *
     * @param userName 用户名
     * @param password 密码
     * @return 用户id
     */
    @Override
    public long getUserByLogin(String userName, String password) {
        return userDao.getUserByLogin(userName, password);
    }

    /**
     * 根据用户id获取用户信息
     *
     * @param userId 用户id
     * @return 用户信息
     */
    @Override
    public User getUserByUserId(long userId) {
        return userDao.getUserByUserId(userId);
    }

    /**
     * 根据用户id修改密码
     *
     * @param userId 用户id
     * @param newPwd 新密码
     * @return 是否修改成功
     */
    @Override
    public boolean modifyPwdByUserId(long userId, String newPwd) {
        return userDao.modifyPwdByUserId(userId, newPwd);
    }

    /**
     * 根据用户ID批量修改权限1
     *
     * @param ids
     * @param power
     * @return
     */
    @Override
    public boolean updatePowerByPeopleIds(int[] ids, int power) {
        return userDao.updatePowerByPeopleIds(ids, power);
    }

    /**
     * 根据用户id修改登录时间 1
     *
     * @param userId
     * @param loginTime
     */
    @Override
    public void updateTimeByUserId(long userId, String loginTime) {
        userDao.updateTimeByUserId(userId, loginTime);
    }

    /**
     * 根据用户ID修改密码 1
     *
     * @param user 用户 实体
     * @return
     */
    @Override
    public boolean alterPwd(User user) {
        return userDao.alterPwd(user);
    }


}
