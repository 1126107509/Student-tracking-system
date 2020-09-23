package studentTracking.controller;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import studentTracking.dao.ITeacherDao;
import studentTracking.model.Menu;
import studentTracking.model.Teacher;
import studentTracking.service.IMenuService;

import java.util.List;

/**
 * 后台管理员控制器
 */
@Controller
public class Administrators {

    @Autowired
    private IMenuService menuService;
    @Autowired
    private ITeacherDao teacherDao;


    /**
     * 教师信息展示
     *
     * @param page      页码
     * @param limit     条数
     * @param condition 查询条件
     * @return json字符串
     */
    @RequestMapping("/listteacher")
    @ResponseBody
    public String teacherList(int page, int limit, String condition) {
        List<Teacher> teachers = teacherDao.teacherListByCondition((page - 1) * limit, limit,
                condition);
        int num = teacherDao.teacherNumByCondition(condition);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 0);
        jsonObject.put("count", num);
        jsonObject.put("data", JSONArray.fromObject(teachers));
        System.out.println(jsonObject.toString());
        return jsonObject.toString();

    }


    /**
     * 侧边目录展示
     *
     * @return
     */
    @RequestMapping("/adminmenu")
    @ResponseBody
    public String showMenu() {
        List<Menu> menus = menuService.listMenu();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", JSONArray.fromObject(menus));
        System.out.println(JSONArray.fromObject(menus));
        return jsonObject.toString();

    }
}
