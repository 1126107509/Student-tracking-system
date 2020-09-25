package studentTracking.controller;

import com.alibaba.fastjson.JSONObject;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import studentTracking.model.Course;
import studentTracking.model.Score;
import studentTracking.model.Student;
import studentTracking.service.ICourseService;
import studentTracking.service.IScoreService;
import studentTracking.service.IStudentService;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes({"courseList"})
public class TeacherController {
    @Autowired
    private IStudentService studentService;
    @Autowired
    private IScoreService scoreService;
    @Autowired
    private ICourseService courseService;

    @RequestMapping("/studentList")
    public String studentList(Model model) {
        List<Course> courseList = courseService.getAllCourse();
        model.addAttribute("courseList", courseList);
        return "teacher/studentList";
    }

    /**
     * 根据老师id获取学生信息将其封装进json并返回
     * @param page
     * @param limit
     * @param teacherId
     * @return
     */
    @RequestMapping("/getStuByTeacher")
    @ResponseBody
    public Object getStuByTeacher(int page, int limit, String teacherId) {
        //将前台数据进行处理
        long tId = 0;
        if (teacherId == null) {
            tId = 0;
        } else {
            tId = Integer.parseInt(teacherId);
        }
        page = (page - 1) * limit;


        //根据老师id分页查询到的所有学生信息
        List<Student> studentListByPage = studentService.getStuByTeacher(page, limit, tId);

        //将其封装进json
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 0);
        jsonObject.put("msg", "");

        jsonObject.put("data", JSONArray.fromObject(studentListByPage));

        return jsonObject;
    }
}
