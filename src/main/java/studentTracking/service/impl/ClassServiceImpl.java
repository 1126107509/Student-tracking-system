package studentTracking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentTracking.dao.IClassDao;
import studentTracking.model.Class;
import studentTracking.model.Student;
import studentTracking.service.IClassService;

import java.util.List;
import java.util.Map;

@Service
public class ClassServiceImpl implements IClassService {
    @Autowired
    private IClassDao classDao;

    /**
     * 通过班期id获取班期信息
     *
     * @param cId 班期id
     * @return 班期信息
     */
    @Override
    public Class getClassByCId(long cId) {
        return classDao.getClassByCId(cId);
    }

    /**
     * 查询班期数量1
     *
     * @return
     */
    @Override
    public int listNumClass() {
        return classDao.listNumClass();
    }

    /**
     * 分页查询班级1
     *
     * @param page
     * @param limit
     * @return
     */
    @Override
    public List<Class> listClass(int page, int limit) {
        return classDao.listClass(page, limit);
    }

    /**
     * 添加班期1
     *
     * @param cls
     * @return
     */
    @Override
    public boolean addClass(Class cls) {
        return classDao.addClass(cls);
    }

    /**
     * 根据ID删除指定的班期1
     *
     * @param classId
     * @return
     */
    @Override
    public boolean delClass(int classId) {
        return classDao.delClass(classId);
    }

    /**
     * 获取所有的班期信息 1
     *
     * @return
     */
    @Override
    public List<Class> getAllClass() {
        return classDao.getAllClass();
    }

    /**
     * 获取可以分配的班期信息1
     *
     * @return
     */
    @Override
    public List<Class> getClassOfAllot() {
        return classDao.getClassOfAllot();
    }


}
