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
import studentTracking.model.Teacher;
import studentTracking.service.IMenuService;
import studentTracking.service.ITeacherService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * 后台管理员控制器
 */
@Controller
public class Administrators {

    @Autowired
    private IMenuService menuService;
    @Autowired
    private ITeacherService teacherService;


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
        boolean isdel = teacherService.delTeacher(teacherId);
        JSONObject jsonObject = new JSONObject();
        if (isdel) {
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

        boolean isadd = teacherService.addTeacher(teacher);
        JSONObject jsonObject = new JSONObject();
        if (isadd) {
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
