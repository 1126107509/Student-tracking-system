package studentTracking.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import studentTracking.model.QueryObject;
import studentTracking.model.Student;
import studentTracking.model.Teacher;

import java.util.List;

public interface IStudentService {



    /**
     * 通过条件查询学生的总数1
     * @param condition  查询条件
     * @return  返回总数
     */
    int studentNumByCondition(@Param("condition") String condition);


    /**
     * 通过条件查询学生信息 1
     * @param page 页码
     * @param limit 条数
     * @param condition 查询条件
     * @return  学生集合
     */

    List<Student> studentListByCondition(@Param("page") int page, @Param("limit") int limit, @Param(
            "condition") String condition);

    /**
     * 添加学生信息 1
     * @param student
     * @return
     */
    boolean addStudent(Student student);

    /**
     * 根据id获取学生信息 1
     * @param stuId
     * @return
     */
    Student getStudentById(int stuId);

    /**
     * 根据指定的id删除学生 1
     * @param stuId
     * @return
     */
    boolean delStudent(int stuId);

    /**
     * 修改学生信息 1
     * @param student
     * @return
     */
    boolean updateStudent(Student student);


    /**
     * 根据查询条件获取学生数量1
     * @param qo 查询对象，封装了查询条件
     * @return 学生数量
     */
    int stuNumByCondition(QueryObject qo);

    /**
     * 根据查询条件获取学生集合1
     * @param qo 查询对象，封装了查询条件
     * @return  学生集合
     */
    List<Student> stuByCondition(QueryObject qo);

    /**
     * 给选中的学生分配班级 1
     * @param stuids 学生id数组
     * @param classId  班级ID
     * @param state  分配的学生状态
     * @return
     */
    boolean updateStuClassId(int[] stuids, int classId,int state);

    /**
     * 根据学生的id重置该学生的班级分配状态 1
     * @param stuId
     * @return
     */
    boolean resetStuClassByStuId(int stuId);
}
