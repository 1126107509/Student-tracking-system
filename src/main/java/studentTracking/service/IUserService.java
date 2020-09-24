package studentTracking.service;

import studentTracking.model.User;

public interface IUserService {
    /**
     * 根据用户名和密码查询用户的id
     * @param userName
     * @param pwd
     * @return
     */
    User getUser(String userName, String pwd);
}
