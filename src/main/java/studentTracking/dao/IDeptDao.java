package studentTracking.dao;

import org.apache.ibatis.annotations.Param;
import studentTracking.model.Dept;

import java.util.List;

/**
 * 部门dao层接口
 */
public interface IDeptDao {



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
    List<Dept> listDept(@Param("page") int page,@Param("limit") int limit);


    /**
     * 添加部门信息1
     * @param depts
     * @return
     */
    boolean addDept(@Param("depts") List<Dept> depts);

    /**
     * 根据指定的id删除部门信息1
     * @param deptId
     * @return
     */
    boolean delDept(int deptId);
}
