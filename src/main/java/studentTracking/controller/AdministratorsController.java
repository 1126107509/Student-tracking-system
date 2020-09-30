package studentTracking.controller;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import studentTracking.model.Class;
import studentTracking.model.*;
import studentTracking.service.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
    @Autowired
    private IJobEvaluateOptionService jobEvaluateOptionService;
    @Autowired
    private IEvaluateDateService evaluateDateService;
    @Autowired
    private IClassService classService;
    @Autowired
    private IDeptService deptService;


    /**
     * 根据用户id修改密码
     * @param user
     * @return
     */
    @RequestMapping("/alter")
    @ResponseBody
    public String alterPwd(User user) {
        System.out.println("user = " + user);
        boolean alterPwd = userService.alterPwd(user);
        System.out.println("alterPwd = " + alterPwd);

        if (alterPwd) {
            return "修改密码成功.....";
        }

        return "修改密码失败.....";

    }

    /**
     * 退出系统
     *
     * @param request
     * @return
     */
    @RequestMapping("/exit")
    @ResponseBody
    public String exit(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.getAttribute("user");
        session.removeAttribute("user");
        session.getAttribute("user");
        return "退出成功,即将跳转登录页面.....";

    }

    /**
     * 根据指定的id删除部门信息
     *
     * @param deptId
     * @return
     */

    @RequestMapping("/deldept")
    @ResponseBody
    public String delDept(int deptId) {
        boolean delJobTime = deptService.delDept(deptId);
        JSONObject jsonObject = new JSONObject();
        if (delJobTime) {
            jsonObject.put("flag", true);
        } else {
            jsonObject.put("flag", false);
        }
        return jsonObject.toString();

    }


    /**
     * 添加部门信息1
     *
     * @param dept
     * @return
     */
    @RequestMapping("/addDept")
    @ResponseBody
    public String addJDept(String dept) {
        String[] nameAndAddresss = dept.split("\\+");
        List<Dept> depts = new ArrayList<>();
        for (String nameAndAddress : nameAndAddresss) {
            String[] strings = nameAndAddress.split("/");
            Dept dep = new Dept(strings[0], strings[1]);
            depts.add(dep);
        }
        boolean addDepts = deptService.addDept(depts);
        JSONObject jsonObject = new JSONObject();
        if (addDepts) {
            jsonObject.put("flag", true);
        } else {
            jsonObject.put("flag", false);
        }
        return jsonObject.toString();

    }


    /**
     * 查询部门信息1
     *
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/deptlist")
    @ResponseBody
    public String listDept(int page, int limit) {

        int classNum = deptService.listNumDept();
        List<Dept> depts = deptService.listDept((page - 1) * limit,
                limit);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 0);
        jsonObject.put("count", classNum);
        jsonObject.put("data", JSONArray.fromObject(depts));
        return jsonObject.toString();

    }

    /**
     * 重置该学生的班级分配状态 1
     *
     * @param stuId
     * @return
     */
    @RequestMapping("/resetStu")
    @ResponseBody
    public String resetStuClass(int stuId) {
        System.out.println("stuId = " + stuId);
        boolean isReset = studentService.resetStuClassByStuId(stuId);
        JSONObject jsonObject = new JSONObject();
        if (isReset) {
            jsonObject.put("flag", true);
        } else {
            jsonObject.put("flag", false);
        }
        return jsonObject.toString();

    }


    /**
     * 为选中的学生分配班级 1
     *
     * @param stuids  所选择的所有学生的ID
     * @param classId 班级id
     * @return
     */
    @RequestMapping("/udtStuOfClzId")
    @ResponseBody
    public String updateStuClassId(@RequestParam("stuids[]") int[] stuids, @RequestParam("classId"
    ) int classId, @RequestParam("state") int state) {
        boolean isUdt = studentService.updateStuClassId(stuids, classId, state);
        JSONObject jsonObject = new JSONObject();
        if (isUdt) {
            jsonObject.put("flag", true);
        } else {
            jsonObject.put("flag", false);
        }
        return jsonObject.toString();
    }


    /**
     * 展示所有学生（分配班期）1
     *
     * @param qo 查询条件对象，封装了查询条件
     * @return
     */
    @RequestMapping("/clzAndStus")
    @ResponseBody
    public String listAllStus(QueryObject qo) {
        System.out.println("qo = " + qo);
        int stuNum = studentService.stuNumByCondition(qo);
        System.out.println("stuNum = " + stuNum);
        List<Student> stus = studentService.stuByCondition(qo);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 0);
        jsonObject.put("count", stuNum);
        jsonObject.put("data", JSONArray.fromObject(stus));
        System.out.println("JSONArray.fromObject(stus) = " + JSONArray.fromObject(stus));
        return jsonObject.toString();

    }


    /**
     * 根据ID删除班期
     *
     * @param classId 班期ID
     * @return
     */
    @RequestMapping("/delClass")
    @ResponseBody
    public String delClass(int classId) {
        boolean delClass = classService.delClass(classId);
        JSONObject jsonObject = new JSONObject();
        if (delClass) {
            jsonObject.put("flag", true);
        } else {
            jsonObject.put("flag", false);
        }
        return jsonObject.toString();

    }


    /**
     * 添加班期1
     *
     * @param cls
     * @return
     */
    @RequestMapping("/addclass")
    @ResponseBody
    public String addClass(Class cls) {

        boolean addClass = classService.addClass(cls);
        JSONObject jsonObject = new JSONObject();
        if (addClass) {
            jsonObject.put("flag", true);
        } else {
            jsonObject.put("flag", false);
        }
        return jsonObject.toString();

    }

    /**
     * 查询所有的班期1
     *
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/listclass")
    @ResponseBody
    public String listClass(int page, int limit) {

        int classNum = classService.listNumClass();
        List<Class> classes = classService.listClass((page - 1) * limit,
                limit);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 0);
        jsonObject.put("count", classNum);
        jsonObject.put("data", JSONArray.fromObject(classes));
        return jsonObject.toString();

    }


    /**
     * 根据指定的ID删除时间节点1
     *
     * @param dateId
     * @return
     */
    @RequestMapping("/delTime")
    @ResponseBody
    public String delJobTime(int dateId) {
        boolean delJobTime = evaluateDateService.delJobTime(dateId);
        JSONObject jsonObject = new JSONObject();
        if (delJobTime) {
            jsonObject.put("flag", true);
        } else {
            jsonObject.put("flag", false);
        }
        return jsonObject.toString();

    }


    /**
     * 添加时间结点1
     *
     * @param time
     * @return
     */
    @RequestMapping("/addTime")
    @ResponseBody
    public String addJobTime(String time) {
        String[] times = time.split("\\+");
        boolean addJobItem = evaluateDateService.addJobTime(times);
        JSONObject jsonObject = new JSONObject();
        if (addJobItem) {
            jsonObject.put("flag", true);
        } else {
            jsonObject.put("flag", false);
        }
        return jsonObject.toString();

    }


    /**
     * 展示所有的时间节点1
     *
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/jobtime")
    @ResponseBody
    public String listJobTime(int page, int limit) {

        int itemNum = evaluateDateService.listNumJobTime();
        List<EvaluateDate> jobTimes = evaluateDateService.listJobTime((page - 1) * limit,
                limit);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 0);
        jsonObject.put("count", itemNum);
        jsonObject.put("data", JSONArray.fromObject(jobTimes));
        return jsonObject.toString();

    }

    /**
     * 根据指定的id删除评价分项1
     *
     * @param optionId
     * @return
     */
    @RequestMapping("/deljobitem")
    @ResponseBody
    public String delJobItem(int optionId) {
        boolean delJobItem = jobEvaluateOptionService.delJobItem(optionId);
        JSONObject jsonObject = new JSONObject();
        if (delJobItem) {
            jsonObject.put("flag", true);
        } else {
            jsonObject.put("flag", false);
        }
        return jsonObject.toString();

    }

    /**
     * 添加工作评分项1
     *
     * @param optionName 评分项
     * @return
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public String addJobItem(String optionName) {
        String[] optionNames = optionName.split("\\+");
        System.out.println("optionNames = " + Arrays.toString(optionNames));
        boolean addJobItem = jobEvaluateOptionService.addJobItem(optionNames);
        JSONObject jsonObject = new JSONObject();
        if (addJobItem) {
            jsonObject.put("flag", true);
        } else {
            jsonObject.put("flag", false);
        }
        return jsonObject.toString();

    }

    /**
     * 查询所有的评分列表1
     *
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/jobitem")
    @ResponseBody
    public String listJobItem(int page, int limit) {

        int itemNum = jobEvaluateOptionService.listNumJobEvaluation();
        List<JobEvaluateOption> jobItems = jobEvaluateOptionService.listJobItem((page - 1) * limit,
                limit);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 0);
        jsonObject.put("count", itemNum);
        jsonObject.put("data", JSONArray.fromObject(jobItems));
        return jsonObject.toString();

    }


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
     * 根据用户id批量修改权限 1
     *
     * @param ids   用户id数组
     * @param power 权限标志 0 未授权 1 授权
     * @return
     */
    @RequestMapping("/updatepowers")
    @ResponseBody
    public String updatePowers(@RequestParam("ids[]") int[] ids, @RequestParam("power") int power) {
        boolean isUdt = userService.updatePowerByPeopleIds(ids, power);
        JSONObject jsonObject = new JSONObject();
        if (isUdt) {
            jsonObject.put("flag", true);
        } else {
            jsonObject.put("flag", false);
        }
        return jsonObject.toString();
    }

    /**
     * 根据用户id更改用于权限1
     *
     * @param userId 用户id
     * @param power  0 未授权 1授权
     * @return
     */
    @RequestMapping("/updatepower")
    @ResponseBody
    public String updatePower(@RequestParam("id") int userId, int power) {
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
     * 用于权限信息展示1
     *
     * @param page      页码
     * @param limit     条数
     * @param condition 查询条件
     * @return json字符串
     */
    @RequestMapping("/userpower")
    @ResponseBody
    public String userPowerList(int page, int limit, String condition, User user) {
        int num = userService.userNumByCondition(condition, user.getFlag());
        List<User> users = userService.userListByCondition((page - 1) * limit, limit,
                condition, user.getFlag());
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

    /**
     * 更该教师信息1
     *
     * @param teacher
     * @return
     */
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
