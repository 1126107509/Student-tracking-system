package studentTracking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentTracking.dao.IStudentDao;
import studentTracking.model.QueryObject;
import studentTracking.model.Student;
import studentTracking.service.IStudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private IStudentDao studentDao;

    /**
     * 通过条件查询学生的总数 1
     *
     * @param condition 查询条件
     * @return 返回总数
     */
    @Override
    public int studentNumByCondition(String condition) {
        return studentDao.studentNumByCondition(condition);
    }

    /**
     * 通过条件查询学生信息 1
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
     * 添加学生信息1
     *
     * @param student
     * @return
     */
    @Override
    public boolean addStudent(Student student) {
        return studentDao.addStudent(student);
    }

    /**
     * 根据id获取学生信息 1
     *
     * @param stuId
     * @return
     */
    @Override
    public Student getStudentById(int stuId) {
        return studentDao.getStudentById(stuId);
    }

    /**
     * 根据指定的id删除学生1
     *
     * @param stuId
     * @return
     */
    @Override
    public boolean delStudent(int stuId) {
        return studentDao.delStudent(stuId);
    }

    /**
     * 修改学生信息1
     *
     * @param student
     * @return
     */
    @Override
    public boolean updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }


    /**
     * 根据查询条件获取学生数量1
     *
     * @param qo 查询对象，封装了查询条件
     * @return 学生数量
     */
    @Override
    public int stuNumByCondition(QueryObject qo) {
        return studentDao.stuNumByCondition(qo);
    }

    /**
     * 根据查询条件获取学生集合1
     *
     * @param qo 查询对象，封装了查询条件
     * @return 学生集合
     */
    @Override
    public List<Student> stuByCondition(QueryObject qo) {
        return studentDao.stuByCondition(qo);
    }

    /**
     * 给选中的学生分配班级 1
     *
     * @param stuids  学生id数组
     * @param classId 班级ID
     * @return
     */
    @Override
    public boolean updateStuClassId(int[] stuids, int classId, int state) {
        return studentDao.updateStuClassId(stuids, classId, state);
    }

    /**
     * 根据学生的id重置该学生的班级分配状态 1
     *
     * @param stuId
     * @return
     */
    @Override
    public boolean resetStuClassByStuId(int stuId) {
        return studentDao.resetStuClassByStuId(stuId);
    }

}
