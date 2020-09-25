package studentTracking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentTracking.dao.IStudentDao;
import studentTracking.model.Student;
import studentTracking.model.Teacher;
import studentTracking.service.IStudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private IStudentDao studentDao;

    /**
     * 根据老师id查询所属学生信息
     *
     * @param teacherId 老师id
     * @return 学生信息列表
     */
    @Override
    public List<Student> getAllStuByTeacher(long teacherId) {
        return studentDao.getAllStuByTeacher(teacherId);
    }

    /**
     * 根据老师id查询所属学生信息
     *
     * @param page      页码
     * @param limit     每页条数
     * @param teacherId 老师id
     * @return 学生信息列表
     */
    @Override
    public List<Student> getStuByTeacher(int page, int limit, long teacherId) {
        return studentDao.getStuByTeacher(page, limit, teacherId);
    }

    /**
     * 通过条件查询学生的总数
     *
     * @param condition 查询条件
     * @return 返回总数
     */
    @Override
    public int studentNumByCondition(String condition) {
        return studentDao.studentNumByCondition(condition);
    }

    /**
     * 通过条件查询学生信息
     *
     * @param page      页码
     * @param limit     条数
     * @param condition 查询条件
     * @return 学生集合
     */
    @Override
    public List<Student> studentListByCondition(int page, int limit, String condition) {
        return studentDao.studentListByCondition(page, limit, condition);
    }

    /**
     * 添加学生信息
     * @param student
     * @return
     */
    @Override
    public boolean addStudent(Student student) {
        return studentDao.addStudent(student);
    }

    /**
     * 根据id获取学生信息
     *
     * @param stuId
     * @return
     */
    @Override
    public Student getStudentById(int stuId) {
        return studentDao.getStudentById(stuId);
    }

    /**
     * 根据指定的id删除学生
     *
     * @param stuId
     * @return
     */
    @Override
    public boolean delStudent(int stuId) {
        return studentDao.delStudent(stuId);
    }

    /**
     * 修改学生信息
     *
     * @param student
     * @return
     */
    @Override
    public boolean updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }


}
