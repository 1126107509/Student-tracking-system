package studentTracking.service;

import studentTracking.model.Class;
import studentTracking.model.Student;

import java.util.List;
import java.util.Map;

public interface IClassService {
    /**
     * 通过班期id获取班期信息
     * @param cId 班期id
     * @return 班期信息
     */
    Class getClassByCId(long cId);

    /**
     * 查询班期数量1
     * @return
     */
    int listNumClass();

    /**
     * 分页查询班级1
     * @param page
     * @param limit
     * @return
     */
    List<Class> listClass(int page, int limit);

    /**
     * 添加班期1
     * @param cls 班级实体
     * @return
     */
    boolean addClass(Class cls);

    /**
     * 根据ID删除指定的班期1
     * @param classId
     * @return
     */
    boolean delClass(int classId);


    /**
     * 获取所有的班期信息 1
     * @return
     */
    List<Class> getAllClass();

    /**
     * 获取可以分配的班期信息1
     * @return
     */
    List<Class> getClassOfAllot();
}
