package studentTracking.service;

import studentTracking.model.Dept;

import java.util.List;

public interface IDeptService {

    /**
     * 查询部门信息数量1
     *
     * @return
     */
    int listNumDept();

    /**
     *分页查询所有的
     * @param page
     * @param limit
     * @return
     */
    List<Dept> listDept(int page, int limit);

    /**
     * 添加部门信息1
     * @param depts
     * @return
     */
    boolean addDept(List<Dept> depts);

    /**
     * 根据指定的id删除部门信息1
     * @param deptId
     * @return
     */
    boolean delDept(int deptId);
}
