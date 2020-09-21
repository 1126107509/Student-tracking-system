package studentTracking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentTracking.dao.IStudentDao;
import studentTracking.model.Student;
import studentTracking.service.IStudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private IStudentDao studentDao;

    /**
     * 根据老师id查询所属学生信息
     * @param teacherId 老师id
     * @return 学生信息列表
     */
    @Override
    public List<Student> getAllStuByTeacher(long teacherId) {
        return studentDao.getAllStuByTeacher(teacherId);
    }

    /**
     * 根据老师id查询所属学生信息
     * @param page      页码
     * @param limit     每页条数
     * @param teacherId 老师id
     * @return 学生信息列表
     */
    @Override
    public List<Student> getStuByTeacher(int page, int limit, long teacherId) {
        return studentDao.getStuByTeacher(page, limit, teacherId);
    }
}
