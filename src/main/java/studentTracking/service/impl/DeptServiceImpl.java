package studentTracking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentTracking.dao.IDeptDao;
import studentTracking.model.Dept;
import studentTracking.service.IDeptService;

import java.util.List;

@Service("deptService")
public class DeptServiceImpl implements IDeptService {

    @Autowired
    private IDeptDao deptDao;

    /**
     * 查询部门信息数量1
     *
     * @return
     */
    @Override
    public int listNumDept() {
        return deptDao.listNumDept();
    }

    /**
     * 分页查询所有的
     *
     * @param page
     * @param limit
     * @return
     */
    @Override
    public List<Dept> listDept(int page, int limit) {
        return deptDao.listDept(page, limit);
    }

    /**
     * 添加部门信息1
     *
     * @param depts
     * @return
     */
    @Override
    public boolean addDept(List<Dept> depts) {
        return deptDao.addDept(depts);
    }

    /**
     * 根据指定的id删除部门信息1
     *
     * @param deptId
     * @return
     */
    @Override
    public boolean delDept(int deptId) {
        return deptDao.delDept(deptId);
    }
}
