package studentTracking.service;

import org.apache.ibatis.annotations.Param;
import studentTracking.model.Teacher;

import java.util.List;

/**
 * 教师service层接口
 */
public interface ITeacherService {


    /**
     * 通过条件查询老师的总数
     * @param condition  查询条件
     * @return  返回总数
     */
    int teacherNumByCondition(@Param("condition") String condition);


    /**
     * 通过条件查询老师信息
     * @param page 页码
     * @param limit 条数
     * @param condition 查询条件
     * @return  老师集合
     */

    List<Teacher> teacherListByCondition(@Param("page") int page, @Param("limit") int limit, @Param(
            "condition") String condition);
}
