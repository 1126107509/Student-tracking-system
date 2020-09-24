package studentTracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import studentTracking.model.Student;
import studentTracking.service.IScoreService;
import studentTracking.service.IStudentService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class StudentController {
    @Autowired
    private IStudentService studentService;
    @Autowired
    private IScoreService scoreService;

    @RequestMapping("/stuScore")
    public String stuScore() {
        return "student/stuScore";
    }

    /**
     * 查询到学生的个人信息返回到前台页面
     * @param model
     * @return 学生个人信息展示页面
     */
    @RequestMapping("/getStuInformation")
    public String getStuInformation(Model model) {
        String userName = "林崑鹏";
        String pwd = "666666";
        Student student = studentService.getStuInform(userName,pwd);
        model.addAttribute("student",student);
        return "student/stuShow";
    }

    /**
     * 根据用户名和密码查询个人成绩信息
     * @param request 学生个人成绩
     * @return
     */
    @RequestMapping("/getStuScore")
    public String getStuScore(HttpServletRequest request) {
        String userName = "林崑鹏";
        String pwd = "666666";
        request.setAttribute("stuScore",scoreService.getPersonScores(userName,pwd));
        return "forward:stuScore";
    }
}
