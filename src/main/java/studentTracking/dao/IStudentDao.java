package studentTracking.dao;

import org.apache.ibatis.annotations.Param;
import studentTracking.model.Student;

import java.util.List;

/**
 * 学生dao层接口
 */
public interface IStudentDao {
    /**
     * 根据老师id查询所属学生信息
     * @param teacherId 老师id
     * @return 学生信息列表
     */
    List<Student> getAllStuByTeacher(long teacherId);

    /**
     * 根据老师id分页查询所属学生信息
     * @param page 页码
     * @param limit 每页条数
     * @param teacherId 老师id
     * @return 学生信息列表
     */
    List<Student> getStuByTeacher(@Param("page") int page, @Param("limit") int limit, @Param("teacherId") long teacherId);

    /**
     * 根据用户名和密码查询单个学生信息
     * @param userName 用户名
     * @Param pwd 用户密码
     * @return
     */
    Student getStuInform(@Param("userName") String userName,@Param("pwd") String pwd);
}
