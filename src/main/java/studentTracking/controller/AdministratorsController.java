package studentTracking.controller;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import studentTracking.model.Menu;
import studentTracking.model.Student;
import studentTracking.model.Teacher;
import studentTracking.model.User;
import studentTracking.service.IMenuService;
import studentTracking.service.IStudentService;
import studentTracking.service.ITeacherService;
import studentTracking.service.IUserService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * 后台管理员控制器
 */
@Controller
public class AdministratorsController {

    @Autowired
    private IMenuService menuService;
    @Autowired
    private ITeacherService teacherService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IStudentService studentService;

    /**
     * 根据ID删除用户
     *
     * @param userId
     * @return
     */
    @RequestMapping("/deluser")
    @ResponseBody
    public String delUser(@RequestParam("id") int userId) {

        boolean isdel = userService.delUser(userId);
        JSONObject jsonObject = new JSONObject();
        if (isdel) {
            jsonObject.put("flag", true);
        } else {
            jsonObject.put("flag", false);
        }
        return jsonObject.toString();

    }


    /**
     * 更改用于权限
     *
     * @param userId 用户id
     * @param power  0 未授权 1授权
     * @return
     */
    @RequestMapping("/updatepower")
    @ResponseBody
    public String userPowerList(@RequestParam("id") int userId, int power) {
        boolean isUdt = userService.updatePower(userId, power);
        JSONObject jsonObject = new JSONObject();
        if (isUdt) {
            jsonObject.put("flag", true);
        } else {
            jsonObject.put("flag", false);
        }
        return jsonObject.toString();
    }


    /**
     * 用于权限信息展示
     *
     * @param page      页码
     * @param limit     条数
     * @param condition 查询条件
     * @return json字符串
     */
    @RequestMapping("/userpower")
    @ResponseBody
    public String userPowerList(int page, int limit, String condition) {
        int num = userService.userNumByCondition(condition);
        List<User> users = userService.userListByCondition((page - 1) * limit, limit,
                condition);
        System.out.println("users = " + users);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 0);
        jsonObject.put("count", num);
        jsonObject.put("data", JSONArray.fromObject(users));
        return jsonObject.toString();

    }


    @RequestMapping("/udtstudent")
    @ResponseBody
    public String udtStudent(Student student) {
        boolean isUdt = studentService.updateStudent(student);
        JSONObject jsonObject = new JSONObject();
        if (isUdt) {
            jsonObject.put("flag", true);
        } else {
            jsonObject.put("flag", false);
        }
        return jsonObject.toString();

    }


    /**
     * 删除学生信息
     *
     * @param stuId 学生id
     * @return
     */
    @RequestMapping("/delstudent")
    @ResponseBody
    public String delStudent(@RequestParam("id") int stuId) {
        //删除学生表信息
        boolean isdel = studentService.delStudent(stuId);
        //删除用户表的信息
        boolean deluser = userService.delPersonByPersonId(stuId);
        JSONObject jsonObject = new JSONObject();
        if (isdel && deluser) {
            jsonObject.put("flag", true);
        } else {
            jsonObject.put("flag", false);
        }
        return jsonObject.toString();

    }


    /**
     * 添加学生信息
     *
     * @param student 学生实体
     * @return
     */
    @RequestMapping("/addstudent")
    @ResponseBody
    public String addStudent(Student student) {

        //添加学生信息
        boolean isadd = studentService.addStudent(student);
        //在user表中插入一条学生信息
        User user = new User();
        user.setUserName(student.getStuName());
        user.setPwd("666666");
        user.setPhone(student.getTelephone());
        user.setFlag(2);
        user.setPeopleId(student.getStuId());
        user.setPower(0);
        boolean addUser = userService.addUser(user);
        JSONObject jsonObject = new JSONObject();
        if (isadd && addUser) {
            jsonObject.put("flag", true);
        } else {
            jsonObject.put("flag", false);
        }
        return jsonObject.toString();

    }


    /**
     * 学生信息展示
     *
     * @param page      页码
     * @param limit     条数
     * @param condition 查询条件
     * @return json字符串
     */
    @RequestMapping("/liststudent")
    @ResponseBody
    public String studentList(int page, int limit, String condition) {
        List<Student> students = studentService.studentListByCondition((page - 1) * limit, limit,
                condition);
        int num = studentService.studentNumByCondition(condition);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 0);
        jsonObject.put("count", num);
        jsonObject.put("data", JSONArray.fromObject(students));
        return jsonObject.toString();

    }


    /**
     * 处理图片
     *
     * @param file    上传的图片
     * @param request 请求
     * @return
     * @throws IOException
     */
    @RequestMapping("/saveimg")
    @ResponseBody
    public String saveImg(MultipartFile file, HttpServletRequest request) throws IOException {
        System.out.println(file.getOriginalFilename());
        //获取存取头像的image路径
        String path = request.getServletContext().getRealPath("/static/img");
        System.out.println("path = " + path);
        File folder = new File(path);
        System.out.println("folder.exists() = " + folder.exists());
        //文件夹不存在，就创建
        if (!folder.exists()) {
            folder.mkdir();
        }
        String filename = file.getOriginalFilename();
        String prefix = UUID.randomUUID().toString().replace("-", "");
        String newImgName = prefix + "-" + filename;
        File img = new File(folder, newImgName);
        file.transferTo(img);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("img", "img/" + newImgName);
        return jsonObject.toString();

    }

    /**
     * 根据图片的名字删除图片
     *
     * @param photo
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping("/delimg")
    @ResponseBody
    public String dealImg(String photo, HttpServletRequest request) throws IOException {
        System.out.println(photo);
        //获取存取头像的image路径
        String path = request.getServletContext().getRealPath("/static/" + photo);

        File image = new File(path);
        //文件存在就删除
        if (image.exists() && image.isFile()) {
            image.delete();
        }
        return "删除成功";

    }

    @RequestMapping("/udttea")
    @ResponseBody
    public String updateTeacher(Teacher teacher) {

        boolean isadd = teacherService.updateTeacher(teacher);
        JSONObject jsonObject = new JSONObject();
        if (isadd) {
            jsonObject.put("flag", true);
        } else {
            jsonObject.put("flag", false);
        }
        return jsonObject.toString();

    }


    /**
     * 删除教师信息
     *
     * @param teacherId 教师id
     * @return
     */
    @RequestMapping("/delteacher")
    @ResponseBody
    public String delTeacher(@RequestParam("id") int teacherId) {
        //删除教师表数据
        boolean isdel = teacherService.delTeacher(teacherId);
        //删除用户表对应的教师信息
        boolean deluser = userService.delPersonByPersonId(teacherId);
        JSONObject jsonObject = new JSONObject();
        if (isdel && deluser) {
            jsonObject.put("flag", true);
        } else {
            jsonObject.put("flag", false);
        }
        return jsonObject.toString();

    }


    /**
     * 添加教师信息
     *
     * @param teacher 教师实体
     * @return
     */
    @RequestMapping("/addtea")
    @ResponseBody
    public String addTeacher(Teacher teacher) {

        //添加教师信息
        boolean isadd = teacherService.addTeacher(teacher);
        //在user表中插入一条教师信息
        User user = new User();
        user.setUserName(teacher.getTname());
        user.setPwd("666666");
        user.setPhone(teacher.getPhone());
        user.setFlag(1);
        user.setPeopleId(teacher.getTeacherId());
        user.setPower(0);
        boolean addUser = userService.addUser(user);
        JSONObject jsonObject = new JSONObject();
        if (isadd && addUser) {
            jsonObject.put("flag", true);
        } else {
            jsonObject.put("flag", false);
        }
        return jsonObject.toString();

    }


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
        List<Teacher> teachers = teacherService.teacherListByCondition((page - 1) * limit, limit,
                condition);
        int num = teacherService.teacherNumByCondition(condition);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 0);
        jsonObject.put("count", num);
        jsonObject.put("data", JSONArray.fromObject(teachers));
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
        return jsonObject.toString();

    }
}
