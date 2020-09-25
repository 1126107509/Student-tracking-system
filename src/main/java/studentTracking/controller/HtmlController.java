/**
 * @description Todo
 * @author li
 * @date 2020-09-22 00:33
 */
package studentTracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import studentTracking.model.Student;
import studentTracking.model.Teacher;
import studentTracking.service.IStudentService;
import studentTracking.service.ITeacherService;

/**
 * 控制页面跳转控制器
 */
@Controller
public class HtmlController {

    @Autowired
    private ITeacherService teacherService;
    @Autowired
    private IStudentService studentService;

    /**
     * 跳转管理员首页
     *
     * @return
     */
    @RequestMapping("/go")
    public String goAdminIndex() {
        return "forward:/WEB-INF/view/admin/index.html";
    }

    /**
     * 跳转教师信息页
     *
     * @return
     */
    @RequestMapping("/teacher")
    public String goTeacher() {
        return "forward:/WEB-INF/view/admin/teacherlist.html";
    }

    /**
     * 跳转教师添加页面
     * @return
     */
    @RequestMapping("/addteacher")
    public String goAddTeacher() {
        return "forward:/WEB-INF/view/admin/addteacher.html";
    }

    /**
     * 跳转教师更改页面
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
     * 跳转教师信息页
     *
     * @return
     */
    @RequestMapping("/student")
    public String goStudent() {
        return "forward:/WEB-INF/view/admin/studentlist.html";
    }

    /**
     * 跳转学生添加页面
     * @return
     */
    @RequestMapping("/goAddstudent")
    public String goAddStudent() {
        return "forward:/WEB-INF/view/admin/addstudent.html";
    }


    /**
     * 跳转学生更改页面
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
     * 跳转权限授权页面
     * @return
     */
    @RequestMapping("/allocatepower")
    public String goPower() {
        return "forward:/WEB-INF/view/admin/allotpower.html";
    }

}
