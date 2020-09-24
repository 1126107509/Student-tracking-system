package studentTracking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentTracking.dao.IUserDao;
import studentTracking.model.User;
import studentTracking.service.IUserService;
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;

    /**
     * 根据用户名和密码查询到userId
     * @param userName 用户名
     * @param pwd 密码
     * @return 用户的id
     */
    @Override
    public User getUser(String userName, String pwd) {
        return userDao.getUser(userName,pwd);
    }
}
