package studentTracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import studentTracking.dao.IScoreDao;
import studentTracking.model.Student;
import studentTracking.service.IScoreService;
import studentTracking.service.IStudentService;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class StudentController {
    @Autowired
    private IStudentService studentService;
    @Autowired
    private IScoreService scoreService;
    /**
     * 获取登陆学生信息,并将其传输到stuShow.jsp前台页面     *
     **/
    @RequestMapping("/getStuInformation")
    public String getStuInformation(Model model) {
        String userName = "林崑鹏";
        String pwd = "666666";
        Student student = studentService.getStuInform(userName,pwd);
        model.addAttribute("student",student);
        return "student/stuShow";
    }

    /**
     * 查询学生个人成绩
     * @return 个人成绩列表
     */
    @RequestMapping("/getStuScore")
    public String getStuScore(Model model, HttpServletRequest request) {
        String userName = "林崑鹏";
        String pwd = "666666";
        request.setAttribute("stuScore",scoreService.getPersonScore(userName,pwd));
        return "forword:student/stuScore";
    }
}
