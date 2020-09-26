package studentTracking.dao;

import studentTracking.model.Role;

import java.util.List;

/**
 * 角色dao层接口
 */
public interface IRoleDao {
    /**
     * 获取所有的角色1
     * @return
     */
    List<Role> getAllRole();
}
