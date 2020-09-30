/**
 * @description Todo
 * @author li
 * @date 2020-09-22 00:33
 */
package studentTracking.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import studentTracking.model.Class;
import studentTracking.model.*;
import studentTracking.service.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 控制页面跳转控制器
 */
@Controller
@SessionAttributes({"user"})
public class HtmlController {

    @Autowired
    private ITeacherService teacherService;
    @Autowired
    private IStudentService studentService;
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IClassService classService;


    /**
     * 检查用户名和密码是否存在1
     *
     * @param userName
     * @param password
     * @return 用户的id
     */
    @RequestMapping("/loginCheck")
    @ResponseBody
    public String loginCheck(String userName, String password, boolean isCheck, HttpServletResponse response) {
        long userId = userService.getUserByLogin(userName, password);
        if (userId > 0 && isCheck) {
            //添加登录时间
            String loginTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            Cookie name = new Cookie("ad_name",userName);
            name.setMaxAge(60*60*24);
            Cookie pwd = new Cookie("ad_pwd",password);
            pwd.setMaxAge(60*60*24);
            response.addCookie(name);
            response.addCookie(pwd);
            userService.updateTimeByUserId(userId,loginTime);
        }
        return Long.toString(userId);
    }

    /**
     * 负责跳转不同用户对应的首页 1
     *
     * @param userId 用户id
     * @param model
     * @return
     */
    @RequestMapping("/loginJudge/{userId}")
    public String loginJudge(@PathVariable("userId") long userId, Model model) {
        User user = userService.getUserByUserId(userId);
        model.addAttribute("user", user);
        if (user.getFlag() == 1) {
            //教师
            return "teacher/index";
        } else if (user.getFlag() == 2) {
            //学生
            return "";
        } else if (user.getFlag() == 3) {
            //部门
            return "";
        } else {
            //管理员
            return "forward:/WEB-INF/view/admin/myindex.jsp";
        }
    }


    /**
     * 跳转管理员首页1
     *
     * @return
     */
    @RequestMapping("/go")
    public String goAdminIndex() {
        return "forward:/WEB-INF/view/admin/myindex.jsp";
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

        model.addAttribute("roles", JSONArray.fromObject(roles));
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


    /**
     * 调转时间节点页面1
     *
     * @return
     */
    @RequestMapping("/timepoint")
    public String goTime() {
        return "forward:/WEB-INF/view/admin/time.html";
    }

    /**
     * 跳转班期页面1
     *
     * @return
     */
    @RequestMapping("/class")
    public String goClass(Model model) {
        List<Teacher> teachers = teacherService.getAllTeacher();
        model.addAttribute("teachers", teachers);
        return "admin/class";
    }


    /**
     * 跳转班期学生页1
     *
     * @return
     */
    @RequestMapping("/classStu")
    public String goClzStuList(Model model) {
        //查询教师信息
        List<Teacher> teachers = teacherService.getAllTeacher();
        //查询班期信息
        List<Class> clzs = classService.getAllClass();
        //获取所有可以分配的班期信息
        List<Class> allotClz = classService.getClassOfAllot();

        model.addAttribute("teachers", teachers);
        model.addAttribute("classes", clzs);
        model.addAttribute("allotClz", allotClz);
        return "forward:/WEB-INF/view/admin/clzstudentlist.jsp";
    }

    /**
     * 跳转部门信息页面1
     *
     * @return
     */
    @RequestMapping("/dept")
    public String goDept() {
        return "forward:/WEB-INF/view/admin/dept.html";
    }


}
