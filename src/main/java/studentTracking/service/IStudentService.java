package studentTracking.service;

import org.springframework.stereotype.Service;
import studentTracking.model.Student;

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
}
