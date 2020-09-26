/**
 * @description Todo
 * @author li
 * @date 2020-09-22 00:33
 */
package studentTracking.controller;

import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import studentTracking.model.Role;
import studentTracking.model.Student;
import studentTracking.model.Teacher;
import studentTracking.service.IRoleService;
import studentTracking.service.IStudentService;
import studentTracking.service.ITeacherService;

import java.util.List;

/**
 * 控制页面跳转控制器
 */
@Controller
public class HtmlController {

    @Autowired
    private ITeacherService teacherService;
    @Autowired
    private IStudentService studentService;
    @Autowired
    private IRoleService roleService;

    /**
     * 跳转管理员首页1
     *
     * @return
     */
    @RequestMapping("/go")
    public String goAdminIndex() {
        return "forward:/WEB-INF/view/admin/index.html";
    }

    /**
     * 跳转教师信息页1
     *
     * @return
     */
    @RequestMapping("/teacher")
    public String goTeacher() {
        return "forward:/WEB-INF/view/admin/teacherlist.html";
    }

    /**
     * 跳转教师添加页面1
     *
     * @return
     */
    @RequestMapping("/addteacher")
    public String goAddTeacher() {
        return "forward:/WEB-INF/view/admin/addteacher.html";
    }

    /**
     * 跳转教师更改页面1
     *
     * @param teacherId
     * @param model
     * @return
     */
    @RequestMapping("/udtteacher/{id}")
    public String goUdpTeacher(@PathVariable("id") int teacherId, Model model) {
        Teacher teacher = teacherService.getTeacherById(teacherId);
        model.addAttribute("teacher", teacher);
        return "forward:/WEB-INF/view/admin/updateteacher.jsp";
    }


    /**
     * 跳转教师信息页1
     *
     * @return
     */
    @RequestMapping("/student")
    public String goStudent() {
        return "forward:/WEB-INF/view/admin/studentlist.html";
    }

    /**
     * 跳转学生添加页面1
     *
     * @return
     */
    @RequestMapping("/goAddstudent")
    public String goAddStudent() {
        return "forward:/WEB-INF/view/admin/addstudent.html";
    }


    /**
     * 跳转学生更改页面1
     *
     * @param stuId
     * @param model
     * @return
     */
    @RequestMapping("/updstudent/{id}")
    public String goUdpStudent(@PathVariable("id") int stuId, Model model) {
        Student student = studentService.getStudentById(stuId);
        model.addAttribute("student", student);
        return "forward:/WEB-INF/view/admin/updatestudent.jsp";
    }


    /**
     * 跳转权限授权页面1
     *
     * @return
     */
    @RequestMapping("/allocatepower")
    public String goPower(Model model) {
        List<Role> roles = roleService.getAllRole();
      /*  List<Map> list = new ArrayList<>();

        for (Role role : roles) {
            HashMap<Object, Object> map = new HashMap<>();
            map.put("roleId", role.getRoleId());
            map.put("flag", role.getFlag());
            map.put("roleName", role.getRoleName());
            list.add(map);
        }
        System.out.println("roles = " + JSONArray.fromObject(list));*/

        model.addAttribute("roles",  JSONArray.fromObject(roles));
        return "forward:/WEB-INF/view/admin/allotpower.jsp";
    }

    /**
     * 跳转学生权限1
     *
     * @return
     */
    @RequestMapping("/studentpower")
    public String goStuPower() {
        return "forward:/WEB-INF/view/admin/studentpower.html";
    }


    /**
     * 跳转老师权限1
     *
     * @return
     */
    @RequestMapping("/teacherpower")
    public String goTeaPower() {
        return "forward:/WEB-INF/view/admin/teacherpower.html";
    }

    /**
     * 跳转评价分项1
     *
     * @return
     */
    @RequestMapping("/commentitem")
    public String goItem() {
        return "forward:/WEB-INF/view/admin/item.html";
    }



    @RequestMapping("/timepoint")
    public String goTime() {
        return "forward:/WEB-INF/view/admin/time.html";
    }

}
