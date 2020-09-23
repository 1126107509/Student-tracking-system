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
}
