package studentTracking.dao;

import org.apache.ibatis.annotations.Param;
import studentTracking.model.Teacher;

import java.util.List;

/**
 * 教师dao层接口
 */
public interface ITeacherDao {


    /**
     * 通过条件查询老师的总数1
     * @param condition  查询条件
     * @return  返回总数
     */
    int teacherNumByCondition(@Param("condition") String condition);


    /**
     * 通过条件查询老师信息1
     * @param page 页码
     * @param limit 条数
     * @param condition 查询条件
     * @return  老师集合
     */

    List<Teacher> teacherListByCondition(@Param("page") int page, @Param("limit") int limit, @Param(
            "condition") String condition);

    /**
     * 添加教师信息1
     * @param teacher 老师实体
     * @return
     */
    boolean addTeacher(Teacher teacher);

    /**
     * 删除教师1
     * @param teacherId  老师id
     * @return
     */
    boolean delTeacher(int teacherId);

    /**
     * 根据id查找老师1
     * @param teacherId 老师id
     * @return
     */
    Teacher getTeacherById(int teacherId);

    /**
     * 教师信息的修改1
     * @param teacher
     * @return
     */
    boolean updateTeacher(Teacher teacher);

    /**
     * 获取所有的教师1
     * @return
     */
    List<Teacher> getAllTeacher();
}
