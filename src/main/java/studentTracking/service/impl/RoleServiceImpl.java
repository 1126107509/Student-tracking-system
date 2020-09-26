package studentTracking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentTracking.dao.IRoleDao;
import studentTracking.model.Role;
import studentTracking.service.IRoleService;

import java.util.List;

@Service("roleService")
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;

    /**
     * 获取所有的角色1
     *
     * @return
     */
    @Override
    public List<Role> getAllRole() {
        return roleDao.getAllRole();
    }
}
