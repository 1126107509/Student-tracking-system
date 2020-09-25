package studentTracking.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import studentTracking.model.Student;
import studentTracking.model.Teacher;

import java.util.List;

public interface IStudentService {
    /**
     * 根据老师id查询所属学生信息
     * @param teacherId 老师id
     * @return 学生信息列表
     */
    List<Student> getAllStuByTeacher(long teacherId);

    /**
     * 根据老师id查询所属学生信息
     * @param page 页码
     * @param limit 每页条数
     * @param teacherId 老师id
     * @return 学生信息列表
     */
    List<Student> getStuByTeacher(int page, int limit, long teacherId);


    /**
     * 通过条件查询学生的总数
     * @param condition  查询条件
     * @return  返回总数
     */
    int studentNumByCondition(@Param("condition") String condition);


    /**
     * 通过条件查询学生信息
     * @param page 页码
     * @param limit 条数
     * @param condition 查询条件
     * @return  学生集合
     */

    List<Student> studentListByCondition(@Param("page") int page, @Param("limit") int limit, @Param(
            "condition") String condition);

    /**
     * 添加学生信息
     * @param student
     * @return
     */
    boolean addStudent(Student student);

    /**
     * 根据id获取学生信息
     * @param stuId
     * @return
     */
    Student getStudentById(int stuId);

    /**
     * 根据指定的id删除学生
     * @param stuId
     * @return
     */
    boolean delStudent(int stuId);

    /**
     * 修改学生信息
     * @param student
     * @return
     */
    boolean updateStudent(Student student);


}
