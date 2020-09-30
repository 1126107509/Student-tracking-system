/**
 * @description Todo
 * @author li
 * @date 2020-09-22 17:59
 */
package studentTracking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentTracking.dao.ITeacherDao;
import studentTracking.model.Teacher;
import studentTracking.service.ITeacherService;

import java.util.List;

@Service("teacherService")
public class TeacherServiceImpl implements ITeacherService {


    @Autowired
    private ITeacherDao teacherDao;

    @Override
    public int teacherNumByCondition(String condition) {
        return teacherDao.teacherNumByCondition(condition);
    }

    /**
     * 通过条件查询老师信息
     *
     * @param page      页码
     * @param limit     条数
     * @param condition 查询条件
     * @return 老师集合
     */
    @Override
    public List<Teacher> teacherListByCondition(int page, int limit, String condition) {
        return teacherDao.teacherListByCondition(page, limit, condition);
    }

    /**
     * 添加教师信息
     *
     * @param teacher
     */
    @Override
    public boolean addTeacher(Teacher teacher) {
        return teacherDao.addTeacher(teacher);
    }

    @Override
    public boolean delTeacher(int teacherId) {
        return teacherDao.delTeacher(teacherId);
    }

    /**
     * 根据id查找老师
     *
     * @param teacherId 老师id
     * @return
     */
    @Override
    public Teacher getTeacherById(int teacherId) {
        return teacherDao.getTeacherById(teacherId);
    }

    /**
     * 教师信息的修改
     *
     * @param teacher
     * @return
     */
    @Override
    public boolean updateTeacher(Teacher teacher) {
        return teacherDao.updateTeacher(teacher);
    }

    /**
     * 获取所有的教师1
     *
     * @return
     */
    @Override
    public List<Teacher> getAllTeacher() {
        return teacherDao.getAllTeacher();
    }


}
